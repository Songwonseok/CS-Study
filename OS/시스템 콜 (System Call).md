# 시스템 콜 (System Call)



### 시스템 콜이란?

- 시스템 호출이라고도 부르며, 부르는 명칭은 크게 상관이 없다.
- 커널 모드의 기능을 사용자 모드가 사용가능하게 하는 것. (사용자 모드 ㅡ> 커널 모드 로 전환)

- 즉, **프로세스가 하드웨어에 직접 접근해서 필요한 기능을 사용할 수 있게 해주는 것** 이다

  > **운영체제의 커널 ** : 자원을 효율적으로 관리해주는 녀석
  >
  > **사용자 모드** : 유저가 접근 할 수 있는 영역을 나누고, 프로그램 자원에 침범하지 못하게 하는 모드
  >
  > **커널모드** : 모든 자원(CPU, 메모리 등)에 접근, 명령을 할 수 있는 모드
  >
  > 
  >
  > 커널 모드 ㅡ> 사용자 모드 는 시스템콜 요청을 다 끝마치고 시스템 콜 리턴값으로 전해준다.

- 윈도우 커널 (응용프로그램 : 사용자 모드 / 나머지 : 커널 모드)
- ![system-call-3](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/OS/images/system-call-3.png)
- HAL (Hardware Abstraction Layer) : 하드웨어와 소프트웨어 간의 원활한 통신을 위한 역할
- 고급 언어 (C++, Java)로 작성된 프로그램들은 직접 시스템 호출을 사용할 수 없기 때문에 고급 API를 통해 시스템 호출에 접근하게 하는 방법이다.



### 시스템 콜은 왜 필요할까?

- ![system-call-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/OS/images/system-call-1.png)
- 우리가 일반적으로 사용하는 프로그램은 **응용 프로그램** 이다. 유저레벨의 프로그램은 유저레벨의 함수들만으로는 많은 기능을 구현하기 힘들기 때문에, 무조건 커널의 도움을 받아야만 한다.
- 반드시 커널에 관련한 것들은 커널모드로 전환하여 해당 작업을 수행해야한다.
- 이러한 커널 모드로 통한 작업을 할때의 전환을 **시스템 콜**이라고 한다.

- 기능이나 시스템 환경에 따라 시스템 콜이 발생할 때 더 많은 정보(매개 변수)가 필요할 때가 있는데,  3가지 방법으로 해결을 해낸다.
  1. 매개 변수를 CPU 레지스터 내에 전달한다. 
     - 하지만 레지스터는 크기와 개수가 정해져 있다는 한계가 있음
     - 속도는 가장 빠름
  2. 위와 같은 경우 매개 변수를 메모리에 저장하고, **메모리의 주소가 레지스터에 전달** 된다.
     - C언어에서 포인터를 매개변수로 전달하는 방법과 동일하다.
     - 리눅스와 솔라리스에서 사용된다.
  3. 매개 변수는 프로그램에 의해 **스택으로 전달** 되거나 push된 매개 변수가 운영체제에 의해서 pop된다.
- 보통 시스템 콜의 번호와 반환값은 레지스터를 사용하는 경우가 많다.
- ![system-call-2](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/OS/images/system-call-2.png)
- ps) 자바에서는 시스템 콜을 직접 사용할 수 없어서 예제가 딱히 없음다 ㅠㅠ



### 시스템 콜의 유형

- 시스템 콜은 다섯 가지의 중요한 범주로 나눌 수 있다.

  1. 프로세스 제어

  2. 파일 조작

  3. 장치 조작

  4. 정보 유지보수

  5. 통신

     

- **프로세스 제어 (Process Control)**

  - 끝내기(end), 중지(abort)
  - 적재(load), 실행(execute)
  - 프로세스 생성(create process)
  - 프로세스 속성 획득과 설정(get process attribute and set process attribute)
  - 시간 대기(wait time)
  - 사건 대기(wait event)
  - 사건을 알림(signal event)
  - 메모리 할당 및 해제 : malloc, free

  

- **파일 조작 (File Manipulation)**

  - 파일 생성(create file), 파일 삭제(delete file)
  - 열기(open), 닫기(close)
  - 읽기(read), 쓰기(write), 위치 변경(reposition)
  - 파일 속성 획득 및 설정(get file attribute and set file attribute)

  

- **장치 관리(Devide Management)**

  - 장치를 요구(request devices), 장치를 방출release device)
  - 읽기, 쓰기, 위치 변경
  - 장치 속성 획득, 장치 속성 설정
  - 장치의 논리적 부착(attach) 또는 분리(detach)



- **정보 유지(Information Maintenance)**

  - 시간과 날짜의 설정과 획득(time)
  - 시스템 데이터의 설정과 획득(date)
  - 프로세스 파일, 장치 속성의 획득 및 설정

  

- **통신(Communication)**

  - 통신 연결의 생성, 제거
  - 메시지의 송신, 수신
  - 상태 정보 전달
  - 원격 장치의 부착 및 분리
  - 메시지 전달 - 두 프로세스의 통신에 정보 교환을 위한 메시지
  - 공유 메모리 - 다른 프로세스가 소유한 메모리에 접근을 위해 특정 시스템 콜 호출

  ps) 일반적인 운영체제는 서로 다른 프로세스간의 메모리 접근을 차단한다. 공유 메모리 기법을 사용하기 위해서는 통신하려는 프로세스들이 차단한 것을 풀어주는 것에 동의를 해야 차단이 풀어진다.



### 참고블로그

- [시스템 콜](https://luckyyowu.tistory.com/133)

- [시스템 콜 레퍼런스 모음 블로그](https://whitesnake1004.tistory.com/2)
- [커널 모드,사용자 모드](https://blockdmask.tistory.com/69)



## 한 줄 요약

**시스템 콜 : 프로세스가 하드웨어(로컬)에 직접 접근해서 필요한 기능을 사용할 수 있게 해주는 것**