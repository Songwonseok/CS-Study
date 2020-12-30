# RESTFul API

### REST (Representational State Transfer) 란?

- 자원을 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든 것을 의미한다.
- 웹의 기존 기술과 HTTP 프로토콜을 그대로 활욯하기 때문에 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일이다.
- HTTP URI를 통해 자원을 명시하고, HTTP Method를 통해 해당 자원에 대한 CRUD 작동을 적용한다.

![RESTful-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Web/images/RESTful-1.JPG)

### RESTful 이란?

- REST라는 아키텍처를 구현하기 위한 웹서비스를 나타내기 위한 용어

  ( REST API를 제공하는 웹 서비스를 RESTful 하다고 할 수 있다.)

- 즉 REST의 원리를 따르는 시스템은 RESTful 이란 용어롤 지칭된다.



### REST API란?

- API(Application Programming Interface)
  - 데이터와 기능의 집합을 제공하여 프로그램간 상호작용을 하며, 서로 정보교환이 가능하게 하는 것
- REST API의 정의
  - REST 기반으로 서비스 API를 구현한 것



### REST API 특징

- 확장성과 재사용성을 높여 유지보수 및 운용을 편리하게 할 수 있다.
- HTTP 표준을 기반으로 구현하여, HTTP를 지원하는 프로그램 언어로 Client, Server를 구현할 수 있다.



### REST API 설계 규칙

- 동사보단 **명사** , 대문자보단 **소문자**

- 도큐면트 이름으로 **단수 명사** , 컬렉션 이름으로 **복수 명사** , 스토어 이름으로 **복수 명사 **

  EX) GET /Member/ 1 ------> GET / members/ 1

-  자원의 행위 (CRUD) 에 대해선 HTTP Method(GET, PUT etc)로 표현

  EX) GET / members / delete /1 -----> DELETE / members / 1

  ​	   GET/ members / insert / 1 ------> POST / members / 1

- 슬래시 ( / ) 는 계층 관계를 나타냄
- 하이픈 ( - ) 은 가독성을 높이는데 사용
- 밑 줄( _ ) 사용하지 않음
- URI 경로는 소문자가 적합하다.