# Thread 활용



### Thread의 간단 복습!

- 한 프로그램이 하나 이상의 독립적인 서브태스크로 분리되어 실행될 때, 각 서브태스크를 쓰레드라 한다.
- 쓰레드는 별개로 실행하면서 CPU를 공동으로 사용한다. 하나의 프로세스에서는 동시에 여러 쓰레드가 실행 될 수 있다.



### Thread의 생명 주기

- ![java-thread-활용-1](C:\Users\박민식\Desktop\MY문서\CS\CS-Study\Language\images\java-thread-활용-1.png)
- Runnable (준비상태) : CPU를 점유하고 있지 않으며, 코딩상에서 start() 메서드 호출로 run() 메소드에 설정된 상태로 진입한다. 보통 "Ready" 상태라고도 한다.



- Running (실행상태) : CPU를 점유하고 있는 상태이며, run() 메서드는 JVM만 호출이 가능하다. Runnable에 있는 여러 쓰레드 중 우선 순위를 가진 쓰레드가 결정되면 JVM이 자동으로 run() 메소드를 호출하여 Running 상태로 진입시킨다.



- Dead (종료상태) : Running 상태에서 쓰레드가 모두 실행되고 난 후 완료 상태이다. 보통 "Done"상태라고도 한다.



- Blocked (지연상태) : CPU 점유권을 상실한 상태이다. 후에 특정 메서드를 실행시켜 Runnable상태로 전환시킨다. wait() 메서드에 의해 Blocked 상태가 된 쓰레드는 notify() 메소드가 호출되면 Runnable상태로 이동한다. 만약 sleep(n) 메소드에 의해 Blocked상태가 된 쓰레드는 지정된 시간이 지나면 Runnable상태로 돌아간다.



### 1-1 Single Thread (Thread Class 상속)

```java
public class SingleThreadEx extends Thread{
    private int[] temp;
    
    public SingleThreadEx(String threadname){
		super(threadname);
		temp = new int[10];
		
        for(int start=0;start<temp.length;start++){
            temp[start]=start;
        }
    }
	
    public void run(){
	    for(int start:temp){
            try {
                Thread.sleep(1000);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
                // TODO: handle exception
            }
			System.out.println("스레드이름:"+currentThread().getName());
			System.out.println("temp value :"+start);
		}
    }
	
    public static void main(String[] args) {
        SingleThreadEx st = new SingleThreadEx("첫번째");
        st.start();
    }
}
```



### 1-2 Single Thread (Runnable Interface 상속)

- 위 방법보다 많이 쓰인다.

```java
public class SingleThreadEx2 implements Runnable{

    private int[] temp;
	
    public SingleThreadEx2(){
		temp = new int[10];
		
        for(int start=0;start<temp.length;start++){
            temp[start]=start;
        }
    }
	
    @Override
    public void run() {
	// TODO Auto-generated method stub
        for(int start:temp){
            try {
                Thread.sleep(1000);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
                // TODO: handle exception
            }
            System.out.println("스레드이름:"+Thread.currentThread().getName());
            System.out.println("temp value :"+start);
        }
    }
	
    public static void main(String[] args) {
        SingleThreadEx2 st2 = new SingleThreadEx2();
        Thread t = new Thread(st2,"첫번째");
        t.start();
    }
}
```



### Class Thread 상속 vs Interface Runnable  상속

- 둘 다 run() 메소드를 오버라이딩하는 방식이라는 공통점이 있다.

- 하지만 쓰레드를 생성하는 방식에서 차이점을 보인다.

  1. Interface Runnable의 경우
     - 해당 클래스를 인스턴스화하여 Thread 생성자에 매개변수로 넘겨줘야 한다.
     - Class Thread를 상속하는 것과 달리 run() 메소드가 오버라이딩되어 따로 작성하지 않아도 된다.
  2. Class Thread의 경우
     - 상속받은 클래스 자체를 쓰레드로 사용할 수 있다.
     - 쓰레드 클래스의 메소드 (getName())을 바로 사용할 수 있다.
     - Interface Runnable 상속의 경우엔 Thread 클래스의 static 메소드인 currentThread()를 호출하여 현재 쓰레드의 대한 정보를 참조하여야 한다.

- main 메소드 안에서 start() 를 통해 쓰레드를 실행한다. 하지만 start() 메소드가 아닌 run() 메소드가 있다. ?

  - 직접 run() 메소드를 작성하여 작업지시를 해도 start() 메소드와 같은 결과가 나오지만 결과적으로는 **쓰레드를 사용하는 것이 아니다.**

  - Java에는 콜 스택이 있다. 이 영역은 실직적인 명령어들을 담고 있는 메모리로, 하나씩 꺼내서 실행시키는 역할을 한다. 만약 동시에 두 가지 작업을 한다면, 두 개의 콜 스택이 필요하다.

  - 쓰레드를 사용한다는 것은 **JVM이 다수의 콜 스택을 번갈아가며 일처리를 하고, 사용자는 동시에 작업하는 것처럼 보여주는 것이다.**

  - run() 메소드를 이용하는 것은 main() 메소드의 콜 스택 하나만 이용하는 것으로 쓰레드 활용이 아니다.

    (쓰레드 객체안에 있는 run() 메소드를 호출하는 것 뿐)

  - 결국 start() 메소드는 쓰레드가 작업을 실행하는데에 필요한 콜 스택을 생성한 다음 run() 메소드를 호출해서 그 스택 안에 run() 메소드를 저장할 수 있도록 해주는 것이다.



### 쓰레드 동기화

- 쓰레드의 실행 순서는 예측할 수 없다.

- 이를 해결해기 위한 방법 **Join** !

- Join

  - 쓰레드를 생성한 쓰레드는 그 지점에서 기다려야 하기에 사용한다.

  - ```java
    class MyThread implements Runnable{
    	private String threadName;
    	public MyThread(String threadName){
    		this.threadName=threadName;
    	}
    	public void run(){
    		for(int i=0;i<100;i++){
    			System.out.println(threadName+":"+i);
    		}
    	}
    }
    
    public class ThreadTest {
    	public static void main(String[] ar) throws InterruptedException{
    		System.out.println("MainThread Start");
    		Thread[] thread=new Thread[4];
    		for(int i=1;i<=3;i++){
    			thread[i]=new Thread(new MyThread("Thread"+i));
    			thread[i].start();
                // thread[i].join(); // 아래 방법과 동일
    		}
    		
    		for(int i=1;i<=3;i++)
    			thread[i].join();
    		
    		System.out.println("MainThread End");	
    	}
    }
    
    /*
    	MainThread Start 
        Thread1:0 
        Thread1:1
        ...
        Thread3:99
        MainThread End
    */
    ```



- 그리고 **synchronized** !

  - ```java
    class ATM implements Runnable {
    	private long depositeMoney = 10000;
    
    	public void run() {
    		synchronized (this) {
    			for (int i = 0; i < 10; i++) {
    				notify();
    				try {
    					wait();
    					Thread.sleep(1000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    				if (getDepositeMoney() <= 0)
    					break;
    				withDraw(1000);
    			}
    		}
    	}
    
    	public void withDraw(long howMuch) {
    		if (getDepositeMoney() > 0) {
    			depositeMoney -= howMuch;
    			System.out.print(Thread.currentThread().getName() + " , ");
    			System.out.printf("잔액 : %,d 원 %n", getDepositeMoney());
    			System.out.println(depositeMoney);
    		} else {
    			System.out.print(Thread.currentThread().getName() + " , ");
    			System.out.println("잔액이 부족합니다.");
    		}
    	}
    
    	public long getDepositeMoney() {
    		return depositeMoney;
    	}
    }
    
    public class test {
    	public static void main(String[] args) {
    		ATM atm = new ATM();
    		Thread mother = new Thread(atm, "mother");
    		Thread son = new Thread(atm, "son");
    		mother.start();
    		son.start();
    	}
    }
    ```

    > - wait() : 스레드가 lock을 가지고 있으면, lock 권한을 반납하고 대기하게 만듦
    > - notify() : 대기 상태인 스레드에게 다시 lock 권한을 부여하고 수행하게 만듦
    >
    > 이 두 메소드는 동기화 된 영역 (synchronized) 내에서 사용되어야 한다.
    >
    >
    > 동기화 처리한 메소드들이 반복문에서 활용된다면, 의도한대로 결과가 나오지 않는다. 이러할 때
    >
    > wait() 과 notify() 를 try-catch 문에서 적절히 활용해 해결할 수 있다.

