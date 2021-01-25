# Overriding vs Overloading

**오버로딩(Overloading) 오버라이딩(Overriding)**

자바에서 다형성을 지원하는 방법으로 메소드 오버로딩(Overloading) 오버라이딩(Overriding)이 있다.. 

오버로딩(Overloading) : 같은 이름의 메소드를 여러 개 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술

오버라이딩(Overriding) : 상위 클래스가 가지고 있는 메소드를 하위 클래스가 재정의 해서 상요한다.



**1. 오버로딩 (Overloading)**

오버로딩(Overloading)은 메소드 오버로딩과 생성자 오버로딩이 있다. 하지만 둘다 같은 개념이다.

같은 이름의 함수를 여러 개 정의하고, 매개변수의 유형과 개수를 다르게 하여 다양한 유형의 호출에 응답하게 한다.

```java
public class Overloadingtest {
	// test() 호출
    void test(){
        System.out.println("매개변수 없음");
    }

    // test에 매개변수로 int형 2개 호출
    void test(int a, int b){
        System.out.println("매개변수 "+ a + "와 " + b);
    }

    // test에 매개변수 double형 1개 호출
    void test(double d){
        System.out.println("매개변수 " + d);
    }
}
```
```java
public class test {
    public static void main(String[] args) {       
        // Overloadingtest 객체 생성
        Overloadingtest ob = new Overloadingtest();
       
        // test() 호출
        ob.test();
       
        // test(int a, int b) 호출
        ob.test(10, 20);
       
        // test(double d) 호출
        ob.test(50);
       
        // test(double d) 호출
        ob.test(123.4);
    }
}
```

* **실행 결과**



![img](https://t1.daumcdn.net/cfile/tistory/2778454952A3F6B127)



예제에서와 같이 test 라는 같은 이름의 메소드를 여러개 정의하고 매개변수만 변경하여 선언했을 때, 호출 매개변수에 따라 매칭되어 함수를 실행시킨다.



**2. 오버라이딩 (Overriding)**

상위 클래스가 가지고 있는 멤버변수가 하위 클래스로 상속되는 것처럼 상위 클래스가 가지고 있는 메소드도 하위 클래스로 상속되어 하위 클래스에서 사용할 수 있다. 하지만, 하위 클래스에서 메소드를 재정의해서 사용할 수 있다.

상속 관계에 있는 클래스 간에 같은 이름의 메소드를 정의하는 기술을 오버라이딩(Overriding) 이라고 한다.

```java
public class Employee{
   
    public String name;
    public int age;
   
    // print() 메소드
    public void print(){
        System.out.println("사원의 이름은 "+this.name+ "이고, 나이는" + this.age+"입니다.");
    }   
}


// Employee 상속
public class Manager extends Employee{
   
    String jobOfManage;
   
    // print() 메소드 오버라이딩
    public void print(){
        System.out.println("사원의 이름은 "+this.name + "이고, 나이는" + this.age + "입니다.");
        System.out.println("관리자 "+this.name+"은 "+this.jobOfManage+" 담당입니다.");
    }
}
```
```java
public class test {

    public static void main(String[] args) {
        
     // Manager 객체 생성
     Manager lee = new Manager();
     
     // 변수 설정   
     lee.name = "하이언";
     lee.age = 30;
     lee.jobOfManage="프로젝트 매니저";
        
// Overriding된 Manager객체의 print()호출
      lee.print();
    }
}
```


* **실행 결과**



![img](https://t1.daumcdn.net/cfile/tistory/26320A4952A4049B22)



Employee에 print() 함수를 선언하고, Manager에서 Employee를 상속하여 print() 메소드를 재정의 하였다.

main 함수에서 Manager 객체를 생성 후, print() 메소드를 호출하면 오버라이딩된 Manager 객체의 print() 메소드가 호출된다.



**3. 오버로딩(Overloading)과 오버라이딩(Overriding) 성립조건**

| 구분           | 오버로딩 | 오버라이딩 |
| -------------- | -------- | ---------- |
| 메소드 이름    | 동일     | 동일       |
| 매겨변수, 타입 | 다름     | 동일       |
| 리턴 타입      | 상관없음 | 동일       |





### 참고

https://hyeonstorage.tistory.com/185

```

```