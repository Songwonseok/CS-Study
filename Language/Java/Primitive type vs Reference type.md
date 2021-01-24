# Primitive type vs Reference type



### Java Data Type

- Primitive Type (기본형)

  - ``` java
    Boolean Type(boolean)
        
    Numeric Type
    	ㄴIntegral Type
    		ㄴ Integer Type(short, int, long)
        	ㄴ Floating Point Type(float, double)
    	ㄴ Character Type(char)
    ```

- Reference Type (참조형)

  - ```java
    Class Type
    Interface Type
    Array Type
    Enum Type
    etc.
    ```



### Primitive Type (기본형)

- 비객체 타입으로, 절대 null값을 가질 수 없는 형태

- ``` java
  Type        Bits      Range of Values
  ----------------------------------------------------------------------------------------
  byte         8bits    -2^7 ~ 2^7-1 (-128 ~ 127)
  short       16bits    -2^15 ~ 2^15-1 (-32768 ~ 32767)
  int         32bits    -2^31 ~ 2^31-1 (-2147483648 ~ 2147483647)
  long        64bits    -2^63 ~ 2^63-1 (-9223372036854775808 ~ 9223372036854775807)
  float       32bits    0x0.000002P-126f ~ 0x1.fffffeP+127f
  double      64bits    0x0.0000000000001P-1022 ~ 0x1.fffffffffffffP+1023  
  char        16bits    \u0000 ~ \uffff (0 ~ 2^15-1) * 자바에서 unsgined로 동작하는 자료형
  boolean      1bit     true, false
  ```



### Reference Type (참조형)

- 참조형은 기본적으로 Java.lang.Object를 상속받는다.
- 또한, 선언한 자료형이 기본형이 아닌경우 모두 참조형이다.
- 참조형에는 **Class, Interface, Array, Enum** 등이 있다.



### Class Type

- 기본형과 다르게 객체를 참조하는 형태이다.

- ``` java
  class MyObject{
      private int index;
      MyObject(int index) {
          this.index = index;
      }
      public int getIndex() {
          return index;
      }
      public void setIndex(int index) {
          this.index = index;
      }
  }
  
  public class ClassType {
      public static void main(String[] args) {
          MyObject a = new MyObject(2);
          MyObject b = new MyObject(4);
          System.out.println(a.getIndex()); // "a" result is 2.
          a = b;
          System.out.println(a.getIndex()); // "a" result is 4.
          b.setIndex(6);
          System.out.println(a.getIndex()); // "a" result is 6.
      }
  }
  ```

- b 객체의 멤버 변수 값을 바꿨지만, a 객체도 같은 객체를 참조하기 때문에 동일한 값을 출력한다.

- 만약 a와 b의 연결을 끊고 싶다면, 어느 변수에 null이나 객체를 재선언(초기화)를 통해 객체의 주소를 지우거나 새로운 객체를 가리키게 하면 된다.

- Class Type에는 String Class, Wrapper Class가 속해있다.

  1. **String Class**

     - 참조형에 속하지만, 기본형처럼 사용하는 특별한 클래스이다.

     - Immutable Object (불변하는 객체) 이다.

     - 값을 변경해주는 메소드들도 존재하지만, 메소드를 통해 변경한다고 한들 새로운 String 클래스를 만드는 것이다.

       ps) 그렇기 때문에 String 비교를 할때 == 이 아니라 .equals() 를 사용하나봅니다.

  2. Wrapper Class

     - 기본형에는 null이 들어갈 수 없지만, 넣고싶다면 Wrapper Class를 활용해야한다.

     - Wrapper Class는 기본형을 클래스로 감싼 형태이다.

     - ```java
       기본형   대응 래퍼 클래스
       byte     Byte
       short    Short
       int      Integer
       long     Long
       float    Float
       double   Double
       char     Character
       boolean  Boolean
       ```



### Interface Type

- 인터페이스를 만들게 되면 새로운 참조 자료형을 만드는 것과 같다.
- 인터페이스도 자료형이기 때문에 자료형으로써 자신을 구현한 객체의 주소를 가질 수 있다.



### Array Type

- 배열형은 기본형과 참조형 모두 사용하여 만들 수 있다.

- ```java
  public class ArrayType {
      public static void main(String[] args) {
          int [] i = new int[2];
          Long [] l = new Long[2];
          Object[][] o = null;
      }
  }
  ```

- 자료형에 []을 선언하여 배열로 지정할 수 있다.

- 배열형 변수 또한 배열의 주소를 가지고 있기 때문에 Class Type의 특징과 일치한다.



### Enum Type

- 보통 열거형이라고 한다.
- String Class와 마찬가지로 불변 객체이다.
- 상수의 집합을 만들거나, 특정 객체의 상태를 모아서 Enum Type으로 만들면 가독성이 좋아진다.



### Boxing vs UnBoxing

- Boxing : Primitive 자료형을 Wrapper 클래스로 변화시킬 때
- UnBoxing : Wrapper 클래스를 Primitive 자료형으로 변화시킬 때

-  ![java-Primitive Type vs Reference Type-1.png](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Language/images/java-Primitive%20Type%20vs%20Reference%20Type-1.PNG) 



### 참고 블로그

- [Primitive Type vs Reference Type-1](https://beomseok95.tistory.com/220)
- [Primitive Type vs Reference Type-2](https://bangu4.tistory.com/32)

