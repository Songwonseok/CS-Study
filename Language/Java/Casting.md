# Casting(업캐스팅 & 다운캐스팅)


## 캐스팅이란 무엇일까?

**캐스팅**(casting)이란 타입을 변환하는 것을 말하며 **형변환**이라고도 한다. 자바의 상속 관계에 있는 부모와 자식 클래스 간에는 서로 간의 형변환이 가능하다.

이번 글에서는 자식 클래스가 부모 클래스의 타입으로 캐스팅되는 **업캐스팅**과 반대로 부모 클래스가 자식 클래스의 타입으로 캐스팅되는 **다운캐스팅**에 대해서 알아본다. 시작하기에 앞서 부모 클래스인 상속 관계의 상위 클래스를 **수퍼 클래스**, 그리고 자식 클래스인 하위 클래스를 **서브 클래스**라고 정의한다.



## 1. 자바 데이터형과 캐스팅(Casting)

캐스팅(Casting)은 형변환이라고 부르기도 하며, 객체지향(OOP)에서의 다향성(Polymorphism)에 있어 중요합니다. 데이터 형태에 따른 캐스팅에 대해 알아보기에 앞서 자바의 데이터형은 크게 2가지로 나눌 수 있습니다.

- 기본형(primitive type)
  \- Boolean Type(boolean)
  \- Numeric Type(short, int, long, float, double, char)
- 참조형(reference type)
  \- Class Type
  \- Interface Type
  \- Array Type
  \- Enum Type
  \- 그 외 다른 것들

기본형(primitive type)의 캐스팅은 보통 **“데이터 손실”** 을 막기 위해서 동작합니다.

```java
int a = 1.2345; // 컴파일 에러
int newA = (int)1.2345; // 캐스팅
```

위 첫번째 줄에서 에러가 나는 이유는, int형 데이터를 담는 a라는 그릇에 소수점이 포함된 1.2345라는 수를 넣을려고 할 때 소수점 아래 0.2345라는 데이터가 손실되기 때문입니다. 이러한 코드는 실제로 동작할 때 개발자가 의도하는 대로 동작하지 않을 가능성이 높아지고 코드의 직관성을 깨트립니다. 하지만, 개발자가 이 데이터의 형태에 대해 이해하고 있으며 데이터 손실이 일어나도 상관이 없다면, 2번째 줄과 같이 캐스팅 해줄수 있습니다.

## 2. 참조형(reference type)의 캐스팅

그러면 참조형(reference type)에서는 어떤 식으로 캐스팅이 일어날까요? 기본적으로 캐스팅은 서로 관련이 있는 데이터끼리의 변환을 목표로 합니다. 즉 레퍼런스 타입에서는 서로 상속(extends)나 구현(implements) 관계 등에 있지 않은 전혀 다른 두 객체라면, 캐스팅이 일어날 수 없습니다.

```java
Class Candy {
  String flavor;
  int price;
}Class Cup {
  String shape;
  boolean isCover;
}
```

위 코드를 보면, Candy 클래스와 Cup이라는 클래스는 실제 세상에서 큰 연관이 없을 뿐더라 코드에서도 서로 어떠한 연관 관계를 가지고 있지 않습니다. 따라서 두 클래스간 캐스팅은 불가능하고, 할 필요도 없는 것이죠!

또한 위에서 언급했듯이, 클래스-상속받은 클래스(extends)간 캐스팅 뿐만 아니라 추상 클래스-상속받은 클래스간(extends), 인터페이스-구현 클래스(implements)간의 캐스팅도 가능합니다.

## 3. 업캐스팅 / 다운캐스팅

참조형의 캐스팅은 업캐스팅과 다운캐스팅으로 나뉩니다.클래스는 크게 부모 클래스(슈퍼 클래스)와 자식 클래스(서브 클래스)로 구분할 수 있습니다. 자식 클래스의 객체는 부모 클래스의 멤버를 모두 가지고 있습니다. 반면 부모 클래스의 객체는 자식 클래스의 멤버를 모두 가지고 있지는 않습니다.

```java
class Animal {
  String name;
  int age;  void bark() {
    System.out.println("동물이 짖는 소리");
  }
}class Dog extends Animal {
  String breed;  @Override
  void bark() {
    System.out.println("왈왈");
  }  void giveHand() {
    System.out.println("손");
  }
}public class Main {
  public static void main(String args[])
  {
    Animal animal_a = new Animal(); // 부모클래스 타입에 부모클래스 대입
    Animal animal_b = new Dog(); // 업캐스팅
    Dog dog_a = new Dog(); // 자식클래스 타입에 자식클래스 대입
    Dog dog_b = new Animal(); // 다운캐스팅으로 보이지만 컴파일 에러    animal_a.bark(); // Animal 클래스에서 동작합니다
    animal_b.bark(); // 왈왈
    dog_a.bark(); // 왈왈
    dog_b.bark(); // 다운캐스팅으로 보이지만 컴파일 에러
  }
}
```

위 코드에서 **Animal은 부모 클래스**, **Dog은 Animal클래스를 상속받은 자식 클래스**에서 해당됩니다. 따라서 객체(Instance)가 가지고 있는 멤버는 다음과 같습니다.

- Animal 클래스로 만든 객체 : Animal 클래스 멤버(name, age, bark())
- Dog 클래스로 만든 객체: Animal 클래스 멤버(name, age)+ Dog 클래스 멤버(breed, 오버라이딩된 bark() )

### 3.1 업캐스팅부터 살펴보기

아래의 그림과 코드를 가지고 업캐스팅의 3가지 핵심 포인트를 살펴보도록 합시다.

![Casting-1](https://github.com/Songwonseok/CS-Study/blob/feature/java-Casting-dh/Language/images/Casting-1.png)

위 코드에서 업캐스팅이 일어나는 과정

```java
// main 메소드 내부
Animal animal_b = new Dog(); // Animal 타입에 Dog타입 대입
animal_b.bark(); // 왈왈
animal_b.breed = "보더콜리" // 컴파일 에러
animal_b.giveHand(); // 컴파일 에러
```

1. 이 부분이 업캐스팅으로, 자식 클래스의 객체가 부모 클래스의 객체로 캐스팅되는것을 말함. Dog으로 만든 객체는 Animal로 만든 객체가 가져야 할 name, age, bark()를 모두 가지고 있기 때문에 문제없이 캐스팅이 가능함
2. animal_b.bark()를 실행시켰을때 “동물이 짖는 소리” 가 출력된 것이 아닌 “왈왈” 이 출력된 것은 **Dog클래스 안에서 오버라이딩시켰던 메소드가 실행**되었다는 증거.**업캐스팅된 객체가 자식 객체의 성질을 가지고 있음**
3. Dog클래스의 필드 breed와 메소드 giveHand()에는 접근이 불가능함. 즉 **업캐스팅된 객체는 자식 객체만 가지고 있는 멤버에는 접근이 불가능**

### 3.2 그럼 다운캐스팅은?

![Casting-2](https://github.com/Songwonseok/CS-Study/blob/feature/java-Casting-dh/Language/images/Casting-2.png)

뭔가 이상한 다운캐스팅

아까 자식 클래스의 객체가 부모 클래스의 객체로 캐스팅되는것을 업캐스팅이라 했으니, 다운캐스팅은 반대로 **부모 클래스의 객체가 자식 클래스의 객체로 캐스팅되는것**일까요?

사실, 잘 생각해보면 이는 굉장히 어색합니다. **Animal으로 만든 객체**는 breed, hand()멤버를 가지고 있지 않을텐데, **이 멤버들을 필요로 하는 Dog으로 만는 객체**를 만들 수 있을까요? 아까 업캐스팅할때는 breed, hand()멤버를 허공에(?) 던져버린다 쳐도, 허공에서 breed, hand()를 가져올수는 없지 않을까요?

```java
Animal animal = new Animal();
animal.name = "Lulu";
animal.age = 3;Dog dog = animal; // 컴파일 에러
System.out.println(dog.breed); // 컴파일 에러
```

실제로, 이렇게 코드를 만들면 에러가 발생합니다. 따라서 다운캐스팅은 단순히 업캐스팅의 반대가 아닌, **업캐스팅되어 고유의 특성을 잃은 자식 클래스의 객체를 다시 복구시키는것**을 말합니다.

```java
Animal animal = new Dog();
animal.name = "Lulu";Dog dog = (Dog)animal; // (캐스팅할 객체타입)캐스팅할 객체
dog.breed = "보더콜리"; // 가능
```

위 코드를 보면 animal은 Dog으로 만든 객체가 업캐스팅된 객체입니다. 이를 다시 dog이라는 객체로 다운캐스팅 시킴으로서 이 객체가 가지고 있는 특성(breed)가 복구된 것을 알 수 있습니다. 추가적으로 업캐스팅과는 달리 괄호 안에 캐스팅할 객체 타입을 필수적으로 적어야 합니다.

## 4. Instanceof로 객체의 타입 식별하기

하나의 부모 클래스는 여러 자식 클래스를 가질 수 있고, 자식 클래스는 어떤 클래스의 부모 클래스가 될 수도 있습니다. 상속관계가 나무처럼 복잡하게 얽혀 있는 상황이 발생하는 것이죠! 이는 캐스팅을 할 시 해당 객체의 타입을 파악하기 어렵게 합니다.

```java
Animal animal = new Dog(); // 업캐스팅
Dog dog = new Dog();if(animal instanceof Animal) // True
if(animal instanceof Dog) // True
if(dog instanceof Animal) // Dog은 Animal을 상속받았으므로 항상 True
if(dog instanceof Dog) // True
```

이를 instanceof 를 통해 해결할 수 있습니다.(판별할 객체 instanceof 클래스명) 는 판별할 객체가 해당 클래스 타입인지 여부에 따라true/false의 Boolean을 반환합니다.



### 참고

https://madplay.github.io/post/java-upcasting-and-downcasting

https://medium.com/@plantstoen/%EC%95%8C%EC%95%84%EB%91%90%EB%A9%B4-%EC%93%B8%EB%AA%A8%EC%9E%88%EB%8A%94-%EC%9E%90%EB%B0%94%EC%9D%98-%ED%97%B7%EA%B0%88%EB%A6%AC%EB%8A%94-%EC%A0%90-1-26b1e1a35491