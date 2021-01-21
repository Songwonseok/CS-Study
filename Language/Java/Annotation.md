# Annotation(어노테이션) 이란?
### Java에서 Annotation(어노테이션) 이란?
- JEE5(Java Platform, Enterprise Edition 5)부터 새롭게 추가된 요소이다.
- 본래 주석이란 뜻으로, 인터페이스를 기반으로 한 문법이다.
- 주석과는 그 역할이 다르지만 주석처럼 코드에 달아 클래스에 특별한 의미를 부여하거나 기능을 주입할 수 있다.
- 이 어노테이션으로 인해 데이터의 유효성 검사 등을 쉽게 알 수 있고, 이와 관련한 코드가 깔끔해지게 된다.
- 일단 어노테이션의 용도는 다양한 목적이 있지만 **메타 데이터**의 비중이 가장 크다 할 수 있다.
- **메타-테이터(Meta-Data)** : 데이터를 위한 데이터를 의미하며, 풀어 이야기하면 한 데이터에 대한 설명을 의미하는 데이터. (자신의 정보를 담고 있는 데이터)

### Annotation의 종류
- 어노테이션은 크게 세가지 종류가 존재한다.
  1. Java Built-in Annotation, 2. Meta Annotation, 3. Custom Annotation

#### 1. Java Built-in Annotation
1) **@Override**

- 선언한 메서드가 오버라이드 되었다는 것을 나타냅니다.
- 만약 상위(부모) 클래스(또는 인터페이스)에서 해당 메서드를 찾을 수 없다면 컴파일 에러를 발생 시킵니다.

2) **@Deprecated**
- 차후 버전에 지원되지 않을 수 있기 때문에 더 이상 사용되지 말아야 할 메소드를 나타낸다.
- 만약 사용할 경우 컴파일 경고를 발생 키십니다.

3) **@SuppressWarnings**
- 선언한 곳의 컴파일 경고를 무시하도록 합니다.

4) **@SafeVarargs**

- Java7 부터 지원하며, 제너릭 같은 가변인자의 매개변수를 사용할 때의 경고를 무시합니다.

5) **@FunctionalInterface**
- Java8 부터 지원하며, 함수형 인터페이스를 지정하는 어노테이션입니다.
- 만약 메서드가 존재하지 않거나, 1개 이상의 메서드(default 메서드 제외)가 존재할 경우 컴파일 오류를 발생 시킵니다.

#### 2. Meta Annotation
먼저 어노테이션의 구조를 보기 위해서 아래의 코드를 참고해 봅니다. (예를 위해 작성된 커스텀 어노테이션입니다.)
``` java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
	boolean isCheck() default true;
}
```
먼저 1번, 2번째 줄의 어노테이션 선언에 쓰인 어노테이션은 메타 어노테이션(Meta Annotation)이라 하며 이를 이용해 커스텀 어노테이션을 작성할 수 있게 됩니다.

1) **@Retention**
- 자바 컴파일러가 어노테이션을 다루는 방법을 기술하며, 특정 시점까지 영향을 미치는지를 결정합니다.
- 종류는 다음과 같습니다.
	- RetentionPolicy.SOURCE : 컴파일 전까지만 유효. (컴파일 이후에는 사라짐)
	- RetentionPolicy.CLASS : 컴파일러가 클래스를 참조할 때까지 유효.
	- RetentionPolicy.RUNTIME : 컴파일 이후에도 JVM에 의해 계속 참조가 가능. (리플렉션 사용)

2) **@Target**
- 어노테이션이 적용할 위치를 선택합니다.
- 종류는 다음과 같습니다.
	- ElementType.PACKAGE : 패키지 선언
	- Eleme ntType.TYPE : 타입 선언
	- ElementType.ANNOTATION_TYPE : 어노테이션 타입 선언
	- ElementType.CONSTRUCTOR : 생성자 선언
	- ElementType.FIELD : 멤버 변수 선언
	- ElementType.LOCAL_VARIABLE : 지역 변수 선언
	- ElementType.METHOD : 메서드 선언
	- ElementType.PARAMETER : 전달인자 선언
	- ElementType.TYPE_PARAMETER : 전달인자 타입 선언
	- ElementType.TYPE_USE : 타입 선언

3) **@Documented**
- 해당 어노테이션을 Javadoc에 포함시킵니다.

4) **@Inherited**

- 어노테이션의 상속을 가능하게 합니다.

5) **@Repeatable**
- Java8 부터 지원하며, 연속적으로 어노테이션을 선언할 수 있게 해줍니다.

어노테이션은 기본적으로 인터페이스 형태를 취하고 있으며, 단지 interface 앞에 **@** 표시를 해줍니다.
어노테이션의 필드에서는 **enum**, String이나 기본 자료형, 기본 자료형의 배열을 사용할 수 있습니다.

#### 3. Custom Annotation
직접 커스텀 어노테이션을 작성하는 방법에 대하여 알아보도록 하겠습니다.

두 가지의 예제를 통해 알아보도록 하겠습니다.

#### 1. 정수 값 주입 예제
처음 주제는 어노테이션을 선언한 정수형 변수에 값을 넣는 예제를 진행해보겠습니다.

	간단한 예제 이므로 주석은 달지 않거나 간단한 설명으로 대체하겠습니다.

**1) 어노테이션 인터페이스 작성**
```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InsertIntData {
    int data() default 0;
}
```
인터페이스를 만들어주는데 앞에 @ 표시를 붙이면 됩니다.
1번과 2번에 대한 설명은 Meta Annotation에서 정리하였습니다.
일단 멤버 변수에 **data**라는 주입을 받을 값을 만들어 줍니다.

**2) 어노테이션을 사용할 예제 클래스 작성**
```java
public class AnnotationExam01 {
    @InsertIntData(data = 30)
    private int myAge;

    @InsertIntData
    private int defaultAge;

    public AnnotationExam01() {
        this.myAge = -1;
        this.defaultAge = -1;
    }

    public int getMyAge() {
        return myAge;
    }

    public int getDefaultAge() {
        return defaultAge;
    }
}
}
```
변수는 다음과 같이 **myAge**와 **defaultAge** 두 가지인데 **myAge**에 어노테이션에서는 30으로 값을 주입합니다.
하지만 **defaultAge** 에서는 값이 없는데 이 경우 어노테이션에서 정한 기본 값인 0으로 값이 주입이 됩니다.
생성자의 경우 값이 없을 경우 -1을 기본으로 저장합니다.

다음은 두 번째 예제인 문자열 값 주입을 보도록 하겠습니다.
두 번째 예제에서는 수행 클래스 및 실행 클래스까지 알아보겠습니다.


#### 2. 문자열 값 주입 예제
두 번째 주제는 어노테이션을 선언한 정수형 변수에 값을 넣는 예제를 진행해보겠습니다.

	간단한 예제 이므로 주석은 달지 않거나 간단한 설명으로 대체하겠습니다.

**1) 어노테이션 인터페이스 작성**
```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InsertStringData {
    String data() default "default";
}
```

위의 1-1와 비슷합니다.
기본 값으로는 **default** 문자열을 가집니다.


**2) 어노테이션을 사용할 예제 클래스 작성**
```java
public class AnnotationExam02 {

    @InsertStringData(data = "MHLab")
    private String myData;

    @InsertStringData
    private String defaultData;

    public AnnotationExam02() {
        myData = "No data";
        defaultData = "No data";
    }

    public String getMyData() {
        return myData;
    }

    public String getDefaultData() {
        return defaultData;
    }
}
```

변수는 다음과 같이 **myData**와 **defaultData** 두 가지인데 **myData**에 어노테이션에서는 “MHLab”으로 값을 주입합니다.
하지만 **defaultData** 에서는 값이 없는데 이 경우 어노테이션에서 정한 기본 값인 “default”로 값이 주입이 됩니다.
생성자의 경우 값이 없을 경우 “No data” 문자열을 기본으로 저장합니다.

**3) 어노테이션을 수행하는 클래스 작성**

```java
public class AnnotationHandler {
    private <T> T checkAnnotation(T targetObj, Class annotationObj) {
        Field[] fields = targetObj.getClass().getDeclaredFields();
        for (Field f : fields) {
            if(annotationObj == InsertIntData.class) {
                return checkAnnotation4InsertInt(targetObj, f);
            }
            else if(annotationObj == InsertStringData.class) {
                return checkAnnotation4InsertString(targetObj, f);
            }
        }
        return targetObj;
    }

    private <T> T checkAnnotation4InsertInt(T targetObj, Field field) {
        InsertIntData annotation = field.getAnnotation(InsertIntData.class);
        if(annotation != null && field.getType() == int.class) {
            field.setAccessible(true);
            try {  field.set(targetObj, annotation.data()); }
            catch (IllegalAccessException e) { System.out.println(e.getMessage()); }
        }
        return targetObj;
    }
   
    private <T> T checkAnnotation4InsertString(T targetObj, Field field) {
        InsertStringData annotation = field.getAnnotation(InsertStringData.class);
        if(annotation != null && field.getType() == String.class) {
            field.setAccessible(true);
            try { field.set(targetObj, annotation.data()); }
            catch (IllegalAccessException e) { System.out.println(e.getMessage()); }
        }
        return targetObj;
    }
   
    public <T> Optional<T> getInstance(Class targetClass, Class annotationClass) {
        Optional optional = Optional.empty();
        Object object;
        try {
            object = targetClass.newInstance();
            object = checkAnnotation(object, annotationClass);
            optional = Optional.of(object);
        }catch (InstantiationException | IllegalAccessException e) { System.out.println(e.getMessage()); }
        return optional;
    }
}
```
약간 코드가 복잡한데 하나씩 설명드리겠습니다.
(코드 리펙토링이 필요하지만 예제를 위한 코드이기에 그냥 진행하겠습니다.)

- **getInstance 메서드**
이 메서드는 두 가지의 전달인자를 받습니다.
첫 번째는 어노테이션이 적용되어 있는 2번에서 작성한 클래스, 두 번째는 체크할 어노테이션 클래스입니다.
반환 값은 **Optional**을 사용하여 반환하게 됩니다.
먼저 타겟 클래스의 인스턴스를 생성하고, **checkAnnotation** 메서드를 호출합니다.
여기서 전달인자에 어노테이션 클래스를 넣은 것은 향후 확장성을 고려 하였는데, 이 부분은 기호에 알맞게 메서드를 나눠서 구현을 해도 무방합니다.

- **checkAnnotation 메서드**
이 메서드는 앞선 **getInstance** 메서드의 전달인자를 그대로 받습니다.
**fields** 변수는 타겟 객체에 선언된 것들을 모두 가져옵니다. (**Field**는 리플렉션과 관련되어 있고, 이는 다음 포스팅에서 다루겠습니다.)
그 다음 전달인자 **annotationObj** 값에 따라 분기를 나눠 메서드를 호출하게 됩니다.

- **checkAnnotation4InsertInt 메서드 (checkAnnotation4InsertString 메서드도 동작이 비슷하게 여기 설명으로 대체합니다.)**
  해당 메서드는 한 라인씩 간략하게 짚고 넘어가겠습니다
  - InsertIntData annotation = field.getAnnotation(InsertIntData.class);
  이 부분은 전달인자로 받은 Field에서 선언된 어노테이션을 가져옵니다.

  - if(annotation != null && field.getType() == int.class)
  이 부분은 어노테이션이 **null**이 아니거나 선언된 변수의 타입이 int형일 경우에만 수행을 하게 됩니다.

  - field.setAccessible(true);
  일반적으로 private로 선언된 변수(필드)의 경우 접근이 불가능하지만, 리플렉트를 통한 접근에 한하여 가능하게끔 해준다.

  - try { field.set(targetObj, annotation.data()); }
  해당 변수의 값을 어노테이션의 값으로 치환하게 됩니다.

위와 같은 작업을 거치고 난 후 전달인자로 넘어온 어노테이션이 선언된 클래스 객체를 반환하게 됩니다.



**4) 실행 클래스 작성**
아래는 위의 두 가지 예제의 실행코드를 작성하였습니다.

```java
public static void main(String[] args) {
        AnnotationHandler handler = new AnnotationHandler();
        AnnotationExam01 exam01 = handler.getInstance(AnnotationExam01.class, InsertIntData.class)
                .map(o -> (AnnotationExam01)o)
                .orElse(new AnnotationExam01());

        AnnotationExam02 exam02 = handler.getInstance(AnnotationExam02.class, InsertStringData.class)
                .map(o -> (AnnotationExam02)o)
                .orElse(new AnnotationExam02());
    
        System.out.println("myAge = " + exam01.getMyAge());
        System.out.println("defaultAge = " + exam01.getDefaultAge());
    
        System.out.println("myData = " + exam02.getMyData());
        System.out.println("defaultData = " + exam02.getDefaultData());
    }
```
실행결과는 다음과 같이 출력됩니다.

    myAge = 30
    defaultAge = -1
    myData = MHLab
    defaultData = No data
    Process finished with exit code 0



### 참고

- https://elfinlas.github.io/2017/12/14/java-annotation/ - 참고블로그
- https://sjh836.tistory.com/8 - 참고 블로그
- https://asfirstalways.tistory.com/309 - 참고 블로그