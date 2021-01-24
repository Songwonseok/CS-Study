# Call by  Value VS Call by Reference



### 함수의 호출 방법

- Call by value (값에 의한 호출) : 인자로 받은 값을 복사하여 처리
- Call by reference (참조에 의한 호출) : 인자로 받은 값의 주소를 참조하여 직접 값을 처리
- 즉, 값을 복사해 처리하느냐 (Call by value) 혹은 직접 참조하느냐(Call by reference) 의 차이이다.



### Call by value

- 장점 : 값을 복사하여 처리하기 때문에 안전하고, 원래의 값이 보존된다.

- 단점 : 값을 복사하기 때문에 메모리 사용량이 늘어난다.

- ```java
  Class CallByValue{
  
  	public static void swap(int x, int y) {
  		int temp = x;
  		x = y;
  		y = temp;
  	}
  
  	public static void main(String[] args) {
  		int a = 10;
  		int b = 20;
  
  		System.out.println("swap() 호출 전 : a = " + a + ", b = " + b);
  		swap(a, b);
  		System.out.println("swap() 호출 후 : a = " + a + ", b = " + b);
  	
  	}
  
      /*
      	swap() 호출 전 : a = 10, b = 20
  		swap() 호출 후 : a = 10, b = 20
      */
  }
  ```

- swap() 메서드를 통해 a,b의 값이 바뀌어야 하지 않을까? 라는 생각을 할 수 있다
- 하지만 main문 안에 swap 메서드 호출 할때의 매개변수 a, b와 swap메서드 내에서 사용하는 매개 변수 x, y는 서로 다르기 때문에 출력상에서 바뀌지 않는다.
- ![java-callbyvalue-callbyreference-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Language/images/java-callbyvalue-callbyreference-2.png)
- swap 메서드를 통해 변경된 값을 출력하고 싶다면 swap메서드 내부에서 x,y를 출력해주어야 한다.
- 각 변수마다 저장된 메모리 주소값이 다르기 때문에 swap 메서드를 통해서 바꾼다 한 들 main문의 출력값은 변화가 없다.



### Call by reference

- 장점 : 복사하지 않고 직접 참조를 하기 때문에 빠른 속도를 가진다.

- 단점 : 직접 참조를 하기에 기존 값이 영향을 받는다.

- ```java
  Class CallByReference{
  	int value;
  
  	CallByReference(int value) {
  		this.value = value;
  	}
  
  	public static void swap(CallByReference x, CallByReference y) {
  		int temp = x.value;
  		x.value = y.value;
  		y.value = temp;
  	}
  
  	public static void main(String[] args) {
  		CallByReference a = new CallByReference(10);
  		CallByReference b = new CallByReference(20);
          
  		System.out.println("swap() 호출 전 : a = " + a.value + ", b = " + b.value);
  		swap(a, b);
  		System.out.println("swap() 호출 전 : a = " + a.value + ", b = " + b.value);
  	}
      /*
      	swap() 호출 전 : a = 10, b = 20
  		swap() 호출 후 : a = 20, b = 10
      */
  }
  ```

- Call by value와는 다르게 swap 메서드를 통해 값이 바뀐 것을 발견할 수 있다.

- ![java-callbyvalue-callbyreference-2](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Language/images/java-callbyvalue-callbyreference-1.png)

- main문에서 선언된 CallByReference 타입의 변수 a, b는 각각 객체를 생성해서 각자의 주소로 10과 20을 저장한다.

- 이 후, main문 안에 swap메서드를 호출할 때 매개 변수 a, b는 값이 저장되어있는 주소값을 복사해서 swap메서드에서 사용하는 x, y 메모리에 저장한다.

- 결국 swap메서드는 10과 20이 저장된 주소를 직접 참조하여 처리하기 때문에 원본 데이터가 변화게 된다.



### 참고 블로그

- [Call by Value VS Call by Reference-1](https://re-build.tistory.com/3)
- [Call by Value VS Call by Reference-2](https://codingplus.tistory.com/29)



## 한 줄 요약

call by value : 값을 복사해 처리, 연산하는 방법 (원본데이터 안전)

call by reference : 값의 주소를 복사해 처리, 연산하는 방법 (원본데이터 변경)