# [Java] 고유 락 (Intrinsic Lock)


## (Java 동기화를 보장하는 방법)



### 가시성(visiblity)

동기화 프로그램의 이슈 중 하나는 **가시성 문제**이다. 가시성 문제는 스레드가 변경한 값이 메인 메모리에 저장되지 않아서 다른 스레드가 이 값을 볼 수 없는 상황을 말한다. 여러 개의 스레드가 동시에 같은 작업을 수행하지 않는다고 해도 여전히 가시성 문제는 남아있다. `cnt++`과 같은 연산을 수행할 때, 메모리에서 읽고, 증가시키고, 쓰는 과정이 이루어진다. read-modify-write 과정 동안 한 스레드가 쓴 값을 다른 스레드가 볼 수도 있고 그렇지 않을 수도 있기 때문이다. 가시성 문제를 해결하는 방법은 **volatile**이나 **lock**을 이용하는 방법이 있다.



### volatile이란?

volatile이란 Java 변수를 메인 메모리에서 바로 읽어(Read) 조작하고 메인 메모리에 반영(Write)하겠다고 명시하는 키워드이다. volatile 키워드가 없는 변수는 값을 변경한 후 언제 다시 메인 메모리에 반영될지 보장할 수 없다.

```java
public volatile int cnt = 0;
```

스레드가 cnt 값을 증가시키는 작업을 수행할 때 다음 과정을 거친다.


![IntrinsicLock-1](https://github.com/Songwonseok/CS-Study/blob/main/Language/images/IntrinsicLock-1.png)

- 메인 메모리로 부터 자신의 cpu cache 영역에 값을 가져온 후
- 값을 증가시키고
- 변경된 값을 메인 메모리에 반영함

cnt를 증가시키는 작업을 하는 여러 개의 스레드가 있을 때, 한 스레드가 변경된 값을 아직 메인 메모리에 반영하기 전에 다른 스레드가 메인 메모리에서 값을 읽고 같은 연산을 수행한다면 잘못된 결과를 확인할 수 있다. 이러한 상황에서는 volatile 키워드로 가시성을 보장할 수 없다. 때문에 volatile 키워드로 가시성을 보장하는 것은 **하나의 스레드만 write**를 하고 **다른 스레드는 read**하는 상황일 때 적합하다.



### 자바의 고유 락(IntrinsicRock)

자바의 모든 객체는 고유의 락(intrinsic lock)을 가지고 있고, 이를 모니터, 모니터 락, 뮤텍스라고도 한다. 고유 락을 이용한 `synchronized` 블록은 동시성 문제를 해결하는 가장 간편한 방법이다.

```java
public class Counter {
  private int count;
  
  public int increase() {
    return ++count; // 스레드 안전하지 않은 연산.
  }
}
```

앞서 설명한 cnt 변수의 증가 예시처럼 `increase()` 함수는 동시성 문제가 있다. 이를 객체의 lock을 이용하는 `synchronized`를 통해 변수로 접근하는 스레드를 제어할 수 있다.

```java
public class Counter {
  private int count;
 
  public int increase() {
    synchronized(this) {
      return ++count;
    }
  }
}
```

synchronized가 increase() 메소드 전체를 감싸고 있는데 이런 경우에는 synchronized 키워드를 추가하는 것으로 더욱 간결하게 표현할 수 있다.

```java
public class Counter {
  private int count;
  
  public synchronized int increase() {
    return ++count;
  }
}
```



### 재진입 가능성(Reentrancy)

자바의 고유 락은 재진입 가능하다. 재진입 가능하다는 것은 락의 획득이 호출 단위가 아닌 스레드 단위로 일어난다는 것을 의미한다. 이미 락을 획득한 스레드는 같은 락을 얻기 위해 대기할 필요 없다.

```java
public class Reentrancy {
  public synchronized void a() {
    System.out.println("a");
    // b가 synchronized로 선언되어 있지만 a진입시 이미 락을 획득하였으므로,
    // b를 호출할 수 있다.
    b();
  }
  public synchronized void b() {
    System.out.println("b");
  }
  public static void main(String[] args) {
    new Reentrancy().a();
  }
}
```

b 메소드는 `synchronized`로 선언되어 있지만 a 메소드 내부에서 b를 호출하는 시점에는 이미 해당 객체의 락이 획득한 상태이므로 대기 없이 b를 호출할 수 있다. 만약 고유 락이 재진입이 불가능하다면 b를 호출하는 지점에서 데드락이 발생할 수 있다.



### 구조적인 락(StructuredLock)

`synchronized`를 이용한 동기화를 구조적인 락(structured lock)이라고 한다. `synchronized` 블록 단위로 락의 획득과 해제가 일어나므로 구조적이라고 한다. synchronized 블록을 진입할 때 락의 획득이 일어나고, 블록을 벗어날 때 락의 해제가 일어난다. 따라서 구조적인 락 A와 B가 있을 때 A 획득 -> B 획득 -> B 해제 -> A 해제는 가능하지만 A 획득 -> B 획득 -> A 해제 -> B 해제는 불가능 하다. 이런 순서로 락을 사용해야 하는 경우라면 `ReentrantLock`과 같은 명시적인 락을 사용해야 한다.



### 명시적인 락(ReentrantLock)

`synchronized`와 동일하게 가시성과 상호 배제 기능을 제공한다. 명시적인 락은 `synchronized`만으로 해결할 수 없는 복잡한 상황에서 사용하기 위한 방법이다.

```java
import java.util.concurrent.locks.ReentrantLock;

Lock lock = new ReentrantLock();
lock.lock();
try { // 임계영역
 .
 .  
 .
} finally {
    lock.unlock();
}
```

명시적인 락을 사용할 경우 `try`문에서 예외가 발생하면 락이 해제되지 않는 경우가 발생한다. 따라서 락이 해제될 수 있도록 `catch`,`finally` 블록에서 락을 해제하는 것이 중요하다.

- **공정성**
  ReentrantLock는 두 종류의 락 공정성 설정을 지원한다. 공정성은 스레드가 사용하고자하는 락을 이미 다른 스레드가 사용중일 때 대기하는 스레드를 처리하는 기준을 의미한다. `synchronized`는 스레드간의 락을 획득하는 순서를 보장해주지 않고, ReentrantLock는 **공정한 방법**과 **불공정한 방법**을 지원한다.
  - 공정한 방법
    - 스레드가 락을 사용하고자 할 때, 해당 락이 이미 사용중이라면 스레드는 대기열 맨 뒤에 위치한다.
  - 불공정한 방법
    - 스레드가 락을 사용하고자 할 때, 해당 락이 이미 사용중이라면 스레드는 대기열 맨 뒤에 위치한다.
    - 스레드가 락을 사용하고자 할 때, 그 순간 해당 락이 해제되었다면 대기열에 스레드가 있더라도 락을 확보한다.
  - **성능**
    대부분의 경우 공정한 방법보다 불공정한 방법을 적용하는 것이 성능상의 이점이 크다. 그 이유는 대기 상태에 있던 스레드가 다시 실행 상태로 돌아가고, 실제로 실행되기까지 상당한 시간이 걸리기 때문이다.
- **명시적인 락을 사용해야하는 경우**
  - 락을 확보할 때 타임아웃을 지정해야 하는 경우
  - 대기 상태 큐 처리 방법을 공정하게 해야 하는 경우
    - ex) 스레드 간의 락 경쟁이 심하지 않거나, 락을 한 번 획득하면 상대적으로 오래 가지고 있는 경우
  - 동시성을 보장해야 하는 코드가 블록 형태를 넘어서는 경우



### 읽기/쓰기 락(Read/Write Lock)

명시적인 락은 한 시점에 하나의 스레드만 락을 확보할 수 있다. 이로인해 동시성을 보장해야하는 상황에서 스레드의 접근을 제한하기도 하지만 그럴 필요가 없는 경우에도 제한한다. 그 예로 read 연산은 락의 획득과 무관하게 여러 스레드가 동시에 접근해도 데이터의 일관성을 해치지 않지만 명시적인 락에서 제한된다. 명시적인 락을 사용하는 경우 read 연산을 수행하기 위해 다수의 스레드는 락을 획득하기 위해 대기해야한다. 이러한 문제를 해결한 기법이 Read/Write Lock이다.

- **동작 방식**
  - A 스레드가 read 연산을 수행하면 read-lock을 획득한다.
  - 객체가 read-lock 상태일 때 B 스레드가 read 연산을 수행하고 read-lock을 획득한다.
  - C 스레드가 write 연산을 수행하면 write-lock을 획득하고 모든 연산이 완료되어 write-lock이 해제될 때 까지 다른 스레드는 read/write lock을 획득할 수 없다.
- **성능**
  - 특정 상황에서 성능을 크게 높일 수 있다.
    - ex) 읽기 작업이 많고 쓰기 작업이 적은 구조에 사용하면 성능을 크게 높일 수 있음
- **고려사항**
  - 구현상의 복잡도가 높기 때문에 최적화된 상황이 아니면 명시적인 락에 비해 성능이 떨어지기도 한다.
  - read-write lock 적용 적합 여부는 성능 측정을 통해서만 알 수 있다.



### 참고

https://velog.io/@nunddu/Java-%EB%8F%99%EA%B8%B0%EB%A5%BC-%EB%B3%B4%EC%9E%A5%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95

https://parkcheolu.tistory.com/24

https://jhnyang.tistory.com/36