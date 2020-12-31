# Java 컴파일 과정

#### 들어가기전

> Java는 OS에 독립적입니다. 그 이유는 JVM(Java Virtual Machine)이 OS와 프로그램의 사이에서 기계어로 해석해주는 역할을 하기 때문입니다. 어떠한 OS든 Java가 설치 되어 있다면 JVM에 의해서 .java 코드가 기계어로 해석될 수 있습니다. 다음은 그 과정에 대한 내용입니다.

![java-compile-1](https://github.com/Songwonseok/CS-Study/blob/main/Language/images/java-compile-1.PNG?raw=true)

Sample.java 파일을 실행하기 위해 Run 버튼을 눌렀을 때 진행되는 과정은 다음과 같다.

1. Sample.java가 자바 컴파일러(javac.exe)를 통해 컴파일 진행

2. Sample.class가 생성됨 (byte code)

   - byte code는 반기계어 상태로 컴퓨터가 읽을 수 없다. 따라서 변환과정이 필요하다.

   - byte code의 각 명령어는 1바이트 크기의 Opcode와 추가 피연산자로 이루어져 있다.

3. Sample.class를 java.exe로 실행

4. JVM의 클래스로더(Class Loader)를 통해 Sample.class를 JVM으로 가져온다. 

   - JVM은 현재 진행을 시도하는 OS에 맞게 변환시켜줌

5. Byte Code Verifier에서 byde code를 검증

6. 실행엔진에 의해 기계어로 해석 (byte code -> binary code)

   - 이때 변환된 binary code는 JVM의 클래스 영역에 저장됨

7. Runtime 실행

