# Generic



### Generic이란?

- 사전적 의미로는 '포괄적인' , '이름이 붙지 않은' 뜻으로 불린다.
- 즉 '일반적인' 이라고 해석할 수 있다.
- 미리 고유한 명칭을 정하지 않고 범용적인 명칭을 만들 수 있고, 타입 변수의 다형성을 보여줄 수 있다.



### 제네릭 타입 (Generic Types)

- 제네릭 타입은 매개변수화 된 클래스나 인터페이스를 말한다. 클래스 이름 뒤에 '<T>' 형태로 표기하는 부분을 말한다.

- ```java
  class Box {
      private Object object;
      public void set(Object object) { this.object = object; }
      public Object get() { return object; }
  }
  
  public class NonGenericTest {
      public static void main(String[] args) {
          // 제네릭 타입을 사용하지 않는 클래스의 객체를 생성한다.
          Box obj = new Box();
          
          // set() 메서드를 이용해서 Integer 객체를 Box 객체의 내부변수 object에 저장한다.
          obj.set(new Integer(10));
          
          // get() 메서드를 이용해서 Box 객체의 내부변수 object에 저장된 값을 가져오라고 한다.
          // 가져올 때 String 자료형의 변수에 저장하기 위해서 캐스트 연산을 한다.
          // 컴파일 과정까지는 오류가 없는 상태이다.
          // 하지만, 실행시 get() 메서드는 Integer 자료형의 자료를 반환하게 되고
          // 이를 String 자료형으로 형변환을 시도하는 과정에서 런타임 오류가 발생하게 된다.
          // * Integer를 String으로 캐스트 연산을 했기 때문에 오류 발생
          String result = (String)obj.get(); // <---- 빨간 밑줄이 없어 오류 확인 불가능
          
          // 결과를 올바르게 가져온 경우 화면에 값을 출력한다.
          System.out.println(result);
      }
  }
  
  이와 같은 방법으로 실행한다면 java.lang.ClassCastException이 발생한다.
  ```

- ```java
  // 제네릭 타입을 사용하는 클래스를 추가한다.
  // <T> 부분이 제네릭 타입이고, T는 Type을 뜻함
  class Box<T> {
      // 내부적인 멤버변수의 자료형을 T로 선언했기 때문에
      // 현재는 자료형이 정확한 상태가 아니다.
      // 객체 생성 과정에서 T에 대한 자료형이 결정될 예정
      private T t;
      
      // set(), get() 메서드에서도 자료형을 T로 선언했기 때문에
      // 현재는 자료형이 정확한 상태가 아니다.
      public void set(T t) { this.t = t; }
      public T get() { return t; }
  }
  
  public class GenericTest {
      public static void main(String[] args) {
          
          // Box 클래스에 대한 객체를 생성하는 과정에서 <Integer> 라는 제네릭 타입을 지정
          // 이로써 Box<T>에서 T는 Integer로 결정
          // 이제 Box 객체의 내부에서 사용된 모든 자료형은 Integer만 사용해야하는 상황
          Box<Integer> obj = new Box<>();
          
          // set() 메서드를 이용해서 받을 수 있는 자료형은 Integer자료형만 허용
          obj.set(new Integer(10));
          
          // get() 메서드의 반환 자료형은 Integer 자료형이다.
          // 따라서 String 자료형으로의 형변호나이 불가능하다.
          // 실행 하기 전에 컵파일 오류를 확인할 수 있다.
          // 이는 '형 안정성 검사 강화' 라는 제네릭 표현의 특징이다.
          String result = (String)obj.get(); // <---- 이미 빨간밑줄이 생겨 오류 확인가능
          System.out.println(result);
      }
  }
  ```



### Generic의 종류

- Generic Class
  - 클래스 내부에서 사용될 자료형을 지정하는 것
- Generic Method
  - 클래스에 제네릭을 선언하지 않고, 메소드에서만 제네릭을 선언하는 방법, 주의해야할 점은 파라미터 타입 또는 리턴타입에 제네릭을 선언했으면 메서드의 리턴타입 앞에도 똑같이 선언해주어야 한다.
- Generic Interface
  - 제네릭 클래스와 비슷하다, 클래스들이 인터페이스를 조금 더 유연하게 구현할 수 있다.



### Generic을 사용할 때에 대문자 알파벳의 뜻

- **E**  : Element
- **K** : Key
- **N** : Number
- **T** : Type
- **V** : Value

