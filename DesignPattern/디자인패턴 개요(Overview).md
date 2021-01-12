# 디자인패턴 개요(Overview)

### 디자인패턴이란?

- 설계적 관점을 중점으로 설계하기 위한 설계 디자인 방법론이다.
- 확장과 수정에 용이하여 설계 이 후 유지보수에 적은 비용이 들어가는 코드를 말한다.
- 공통적으로 발생하는 문제를 해결하기 위한 재사용이 가능한 솔루션이다.



### SOLID 원칙 (객체지향 5대 원칙)

- 객체지향을 사용하기 위해 현재까지도 사용되는 하나로 정리된 객체지향 원칙

  

1.  SRP (Single Responsibility Principle, 단일 책임 원칙)

   - **클래스나 함수는 단 하나의 기능만을 가져야 한다.**
   - 클래스나 함수가 비대해지면 (크기가 커지면) 분리시킬 필요가 있다.

2.  OCP (Open-Closed Principle, 개방-폐쇄 원칙)

   - 기존 코드 변경은 폐쇄하고, 추가 혹은 확장은 개방해야한다.
   - **자주 변경될 수 있는 내용은 수정하기 쉽게 설계** 하고, 자주 변경되지 않을 내용은 수정에 영향을 받지 않게 설계해야한다.

3.  LSP (Liskov Substitution Principle, 리스코프 치환 원칙)

   - 자식 클래스는 부모 클래스에서 가능한 행위를 수행할 수 있어야 한다.
   - 파생 클래스를 만들 때, **올바른 상속의 관계를 갖는지 생각해야 한다.**
   - ex) [Rectangle, Square 클래스](https://nesoy.github.io/articles/2018-03/LSP)

4.  DIP (Dependency Inversion Principle, 의존 역전 원칙)

   - 의존 관계를 맺을 때, 변화하기 쉬운 것 보다 **변화하기 어려운 것에 의존해야한다.**

   - 변화하기 쉬운 것 = 구체적인 것 (클래스, 서브 클래스 인스턴스)
     변화하기 어려운 것 = 추상적인 것 (추상 클래스, 인터페이스)

     > (인터페이스 or 추상클래스) (변수명) = (서브클래스 인스턴스) 꼴이 되어야 함

   - ex) 의존성 주입 (Dependency Injection) 기술

5.  ISP (Interface Segregation Principle, 인터페이스 분리 원칙)

   - 클라이언트가 자신이 이용하지 않는 메서드에 의존하지 않아야 한다.
   - 큰 덩어리의 인터페이스들을 구체적이고 작은 단위들로 분리시킴으로써 **클라이언트들이 꼭 필요한 메서드들만 이용할 수 있게 한다.**
   - 인터페이스를 클라이언트에 특화되도록 분리시키라는 설계 원칙이다.

- 객체지향 3대 특징
  - 캡슐화
    - 객체의 필드(속성), 메소드를 하나로 묶고, 실제 구현 내용을 외부에 감추는 것
    - 정보의 손상과 오용 사전 방지.
    - **다른 객체와의 독립성 유지**로 전체적인 코드 유지보수 및 변경에 유연
  - 상속
    - **기존 클래스를 재사용**하는 것
    - 개발시간 절약, 중복 코드 감소 및 유지보수에 용이해짐
  - 다형성
    - **하나의 타입에 여러 객체를 대입**함으로써 다양한 기능을 이용할 수 있도록 하는 것
    - ex) 부모 클래스 또는 인터페이스의 타입 변환, 오버로딩과 오버라이딩



### 디자인패턴의 종류

현재까지 알려진 디자인 패턴은 다음과 같이 23개로 나누어져 있고 GoF(Gang of Four) 디자인 패턴이라고도 부른다. (4명의 유명한 개발자들에게 고안되었음)

|              생성패턴 **(Creational patterns)**              |              구조패턴 **(Structural patterns)**              |              행동패턴 **(Behavioral patterns)**              |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| [싱글톤 (Singleton)](https://dailyheumsi.tistory.com/149?category=855210) | [어댑터 (Adapter)](https://dailyheumsi.tistory.com/189?category=855210) | [스트레티지 (Strategy)](https://dailyheumsi.tistory.com/209?category=855210) |
| [팩토리 메쏘드 (Factory Methods)](https://dailyheumsi.tistory.com/150?category=855210) |                       브리지 (Bridge)                        | [템플릿 메쏘드 (Template Meothods)](https://dailyheumsi.tistory.com/210?category=855210) |
| [추상 팩토리 메쏘드 (Abstract Factory Methods)](https://dailyheumsi.tistory.com/188?category=855210) | [컴퍼지트 (Composite)](https://dailyheumsi.tistory.com/193?category=855210) | [옵저버 (Observer)](https://dailyheumsi.tistory.com/211?category=855210) |
| [빌더 (Builder)](https://dailyheumsi.tistory.com/187?category=855210) | [데코레이터 (Decorator)](https://dailyheumsi.tistory.com/198?category=855210) | [스테이트 (State)](https://dailyheumsi.tistory.com/212?category=855210) |
|                    프로토타입 (Prototype)                    |                       퍼사드 (Facade)                        | [비지터 (Visitor)](https://dailyheumsi.tistory.com/216?category=855210) |
|                                                              |                   플라이웨이트 (Flyweight)                   | [커맨드 (Command)](https://dailyheumsi.tistory.com/217?category=855210) |
|                                                              | [프록시 (Proxy)](https://dailyheumsi.tistory.com/201?category=855210) |                   인터프리터 (Interpreter)                   |
|                                                              |                                                              |                    이터레이터 (Iterator)                     |
|                                                              |                                                              |                    미디에이터 (Mediator)                     |
|                                                              |                                                              |                       메멘토 (Memento)                       |
|                                                              |                                                              | [책임 연쇄 (Chain of Responsibility)](https://dailyheumsi.tistory.com/213?category=855210) |



### UML (Unified Modeling Language) 표기법

디자인 패턴의 설계는 기본적으로 UML로 표기되기 때문에 UML표기법을 이해하고 있어야 한다.

UML도 종류가 많지만, 디자인 패턴에서는 클래스 다이어그램을 중심으로 이용한다.

![디자인패턴개요-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DesignPattern/images/%EB%94%94%EC%9E%90%EC%9D%B8%ED%8C%A8%ED%84%B4%EA%B0%9C%EC%9A%94-1.png)

​																		

 

​                          <img src="https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DesignPattern/images/%EB%94%94%EC%9E%90%EC%9D%B8%ED%8C%A8%ED%84%B4%EA%B0%9C%EC%9A%94-2.png" alt="디자인패턴개요-2" style="zoom: 50%;" />

​																		       		**일반화**

​	 

<img src="https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DesignPattern/images/%EB%94%94%EC%9E%90%EC%9D%B8%ED%8C%A8%ED%84%B4%EA%B0%9C%EC%9A%94-3.png" alt="디자인패턴개요-3" style="zoom: 33%;" />



​			 								  	**집합**						                 				**합성**



<img src="https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DesignPattern/images/%EB%94%94%EC%9E%90%EC%9D%B8%ED%8C%A8%ED%84%B4%EA%B0%9C%EC%9A%94-4.png" alt="디자인패턴개요-4" style="zoom:33%;" />

​																			**인터페이스**

[UML 표기 참조 블로그 이동하기](https://gmlwjd9405.github.io/2018/07/04/class-diagram.html)

[디자인패턴 참조 블로그 이동하기](https://dailyheumsi.tistory.com/148#3.-%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4%EC%9D%98-%EC%A2%85%EB%A5%98)

<hr>

한 줄 요약

디자인패턴 : 유지보수 등의 목적을 두어 **좋은코드** 를 이용하여 설계하는 방법

UML 표기 : 디자인 패턴 설계를 가시적으로 보기위한 수단 , ex) apache amaterasu

