# Garbage Collection(GC)



### Garbage Collection(GC)이란?

- 메모리 관련 기법 중 하나로 프로그램이 동적으로 할당했던 메모리 영역중에서 필요없게 된 영역을 자동으로 해제하는 기능
- 동적 할당된 메모리 영역 가운데 어떤 변수도 가리키지 않는 메모리 영역을 탐지하여 자동으로 해제한다.
- 객체가 null인 경우, 블럭안에 생성된 객체, 부모 객체가 null이 된 자식 객체 가 GC대상이 된다.
- Java, C#, 일부 스크립트 언어들은 GC 기법을 염두하며 설계됨



### Garbage Collection(GC) 의 장단점

|                             장점                             |                             단점                             |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| 이미 동적 할당된 메모리를 해제한 영역에 접근하게 되는 버그를 예방할 수 있다. | 어떤 메모리를 해제해야 할 지 결정해야할 때에 사용되는 알고리즘에 의해 시간과 비용이 든다. |
|  이미 해제된 메모리를 또 다시 해제하는 오류를 줄일 수 있다.  | GC가 행동하는 타이밍이나, 점유시간을 사전에 예측하기 어렵기 때문에 실시간 시스템에는 적합하지 않다. |
| 더 이상 사용하지 않는 메모리 영역을 해제하지 않고 남겨진 것이 쌓이게 되는 **메모리 누수** 를 예방할 수 있다. |                                                              |



### Garbage Collection(GC) 무조건 좋은 걸까?

단점으로 지적된 **실시간 시스템** 에서 사용된다면 치명적인 오류를 발생시킬 수 있다.

군사목적의 프로그래밍 중 비행시스템 등에서 실시간으로 목표물을 향해 날아가는 중간에 GC가 돟작한다면 알고리즘의 동작이 멈추어 목표물을 찾지 못하기 때문에 실시간 시스템에서 GC는 지양해야한다.



### Heap 영역의 구조	

Heap영역은 크게 2가지로 나뉩니다. (Permanent Generation 제외)

- **Young Generation** - 객체 사용이 짧은 객체들이 모여있는 곳

  - 종류

    1. Eden

    2. Survivor 2개

  - 새롭게 생성된 객체가 위치한다.

  - 매우 많은 객체가 생성되었다가 사라지는 곳이다.

  - 이 지역에서 객체가 사라지면, **MinorGC** 가 발생했다고 한다.

- **Old Generation (Tunured Space)** - 오래 사용되는 객체들

  - Young영역에서 살아남은 객체가 이 곳으로 복사된다.
  - Young영역보다 메모리가 크게 할당되어 상대적으로 Young영역보다 상대적으로 GC는 적게 발생한다.
  - 이 지역에서 객체가 사라지면 **MajorGc (Full GC)** 가 발생했다고 한다.

- **[Non-Heap] Permanent Generation (PermGen)**

  - 이 영역에서는 JVM에 의해서 사용되는 클래스와 메서드 객체 정보를 담고있다.
  - JDK8부터 PermGendms Metaspace로 교체된다.

- Minor GC, Major GC가 실패한다면 **Full GC** 가 발생할 수도 있다.

- 진행 과정

  - ![java-garbage-collection-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Language/images/java-garbage-collection-1.png)
    - 일반적으로 객체를 생성하면, Young 영역에 먼저 위치하고 오랫동안 사용되는 객체는 GC과정을 통해 Old영역으로 이동한다.
  - ![java-garbage-collection-2](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Language/images/java-garbage-collection-2.png)
    - Allocation (배당하다) : 새로 생성된 객체가 유입됨
    - Promotion : 오래 사용되는 객체가 이동 (Young ㅡ> Old)



### 왜 Heap영역을 두 가지 영역으로 나눈 것일까?

여러 연구를 진행한 결과 애플리케이션에서 객체가 생성되고 사라지는 패턴은 다음 2가지 특성은 가진다.

- 대부분의 생성된 객체는 금방 사용하지 않는다.
- 객체들은 대개 오랜시간동안 남아있지 않는다. (객체가 짧게 사용됨)

이러한 특성을 가지고 있어 Heap영역을 두 가지로 나누고, GC 알고리즘도 이에 기반하여 설계됨



### Garbage Collection 타입

각 영역마다 실행되는 GC는 다르다.

- Minor GC
  - Young영역에서 발생
  - 트리거 되는 시점 : Eden이 Full이 된 경우
- Major GC
  - Old영역에서 발생
  - 트리거 되는 시점 : Minor GC가 실패하는 경우
- Full GC
  - Young Generation + Old Generation + MetaSpace(PermGen) 영역 (전체)
  - 트리거 되는 시점 : Minor GC, Major GC가 실패하는 경우



### Garbage Collection 알고리즘

- **Serial**
- **Parallel**
- **Parallel Old (Parallel Compacting GC)**
- **Concurrent Mark & Sweep (CMS)**
- **G1 (Garage First)**
  - JDK 7u4부터 도입
  - JDK9부터 기본 GC로 변경

ps) stop-the-world : GC에서 자주 사용되는 용어, GC를 실행하면 JVM이 애플리케이션 실행을 멈추는 현상

GC가 일어나면 GC를 실행하는 쓰레드를 제외한 모든 쓰레드를 정지시키기 때문이다. 이러한 경우엔 애플리케이션 성능에 많은 영향을 준다...



### 참고블로그

- https://advenoh.tistory.com/14

- https://www.crocus.co.kr/1512
- https://ko.wikipedia.org/wiki/%EC%93%B0%EB%A0%88%EA%B8%B0_%EC%88%98%EC%A7%91_(%EC%BB%B4%ED%93%A8%ED%84%B0_%EA%B3%BC%ED%95%99)



## 한 줄 요약

GC: 메모리에서 더 이상 사용하지 않는 영역(쓰레기)를 자동으로 처리해주는 기술 (매우 편리하지만 단점도 존재함)