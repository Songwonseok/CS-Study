# 인터럽트(Interrupt)

### 인터럽트(Interrupt)란?
- CPU외부의 하드웨어적인 요구에 의해서 정상적인 프로그램의 실행 순서를
변경하여 보다 시급한 작업을 먼저 수행한 후에 다시 원래의 프로그램으로
복귀하는 것
- 비동기적으로 발생하는 주변장치의 서비스 요청에 CPU가 가장 빠르게 대응
할 수 있는 방법
- 비동기적으로 동작하는 CPU(고속)와 주변장치(저속) 사이에서 효율적으로
일을 수행
- 인터럽트가 발생하면 나중에 돌아올 복귀주소(return address)가 자동적으
로 스택에 저장되었다가, 인터럽트 서비스루틴의 마지막에서 복귀 명령을
만나면 다시 자동적으로 복귀주소로 돌아온다. 

![Interrupt-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/OS/images/Interrupt-1.PNG)

<br>

### 인터럽트의 종류
**1) 하드웨어 인터럽트**
- 내부 인터럽트
	- 잘못된 명령이나 잘못된 데이터를 사용할때 발생
	- Trap이라고도 함
	- 프로그램 검사 인터럽트(Program check interrupt)
		- Division by zero
		- Overflow/Underflow
		- 기타 프로그램 Exception
- 외부 인터럽트
	- 전원 이상 인터럽트(Power fail interrupt): 정전, 파워 이상 등
	- 기계 착오 인터럽트(Machine check interrupt): CPU의 기능적인 오류
	- 외부 인터럽트(External interrupt)
		- 자원이 할당된 시간이 다 끝난 경우
		- 키보드로 인터럽트 키를 누른 경우(대표적으로 Control + Alt + Delete)
		- 외부장치로부터 인터럽트 요청이 있는 경우
	- 입출력 인터럽트(I/O Interrupt)
		- 입출력장치가 데이터 전송을 요구하거나 전송이 끝나 다음 동작이 수행되어야 할 경우
		- 입출력 데이터에 이상이 있는 경우

**2) 소프트웨어 인터럽트**
- 프로그램 처리 중 명령의 요청에 의해서 발생
- 대표적인 형태는 프로그램에서 감시 프로그램(SVC) 호출
- SVC(SuperVisor Call)
	- 사용자가 프로그램을 실행시키거나 감시프로그램(Supervisor)을 호출하는 동작을 수행하는 경우
	- 복잡한 입출력 처리를 하는 경우
<br>

### 인터럽트 동작 순서

1. **인터럽트 요청**
2. **프로그램 실행 중단**: 현재 실행중이던 Micro operation 까지 수행한다.
3. **현재의 프로그램 상태 보존**: PCB(Process Control Block), PC(Program Counter) 등
4. **인터럽트 처리루틴 실행**: 인터럽트를 요청한 장치를 식별한다.
5. 인터럽트 서비스 루틴 실행
   - 인터럽트 원인을 파악하고 실질적인 작업을 수행한다. 처리기 레지스터 상태를 보존한다.
   - 서비스루틴 수행 중 우선순위가 더 높은 인터럽트가 발생하면 또 재귀적으로 1~5를 수행한다.
   - 인터럽트 서비스 루틴을 실행할 때 인터럽트 플래그(IF)를 0으로 하면 인터럽트 발생을 방지할 수 있다.
6. **상태복구** : 인터럽트 발생 시 저장해둔 PC(Program counter)를 다시 복구한다.
7. **중단된 프로그램 실행 재개**: PC의 값을 이용하여 이전에 수행중이던 프로그램을 재개한다.



### 인터럽트 우선순위

- 여러 장치에서 인터럽트가 동시에 발생하거나 인터럽트 서비스 루틴 수행 중 인터럽트가 발생한 경우 우선순위 판별 필요
	1. 전원 이상(Power fail)
	2. 기계 착오(Machine Check)
	3. 외부 신호(External)
	4. 입출력(I/O)
	5. 명령어 잘못
	6. 프로그램 검사(Program Check)
	7. SVC(SuperVisor Call)
- 일반적으로 하드웨어 인터럽트가 소프트웨어 인터럽트보다 우선 순위가 높고,
- 일반적으로 높고 내부 인터럽트 보다 외부 인터럽트가 우선 순위가 높다.



### 우선순위 판별 방법
- **소프트웨어적인 방법(Polling)**
	- 인터럽트 요청 플래그를 차례로 비교하여 우선순위가 가장 높은 인터럽트 자원을 찾고, 이에 해당하는 인터럽트 서비스 루틴을 수행한다.
	- 속도가 빠른 장치에 높은 등급을 부여한다.
	- 우선순위 변경이 쉽다.
	- 많은 인터럽트가 있을 경우 하드웨어 적인 방법에 비해서 우선순위 판단 속도가 느리다.
	- 회로가 간단하고 융통성이 있으며, 별도의 하드웨어가 필요 없다.
	- Polling의 주기가 짧으면 server 성능에 부담이 생기며, 주기가 길어지면 실시간성이 떨어진다

- **하드웨어적인 방법(Vectored Interrupt)**
	- 인터럽트를 요청할 수 있는 장치와 CPU사이에 장치번호를 식별할 수 있는 버스를 직렬/병렬로 연결한다.
	- 인터럽트 벡터는 인터럽트를 발생한 장치가 분기할 곳에 대한 정보이다.
	- 소프트웨어적인 방법에 비해 비경제적이다.
	- 회로가 복잡하고 융통성이 없으나, 별도의 소프트웨어가 필요없이 하드웨어로 처리되므로 속도가 빠르다.
	- 하드웨어적인 방법은 아래 2가지로 나뉜다.
	- **Daisy Chain**
		- 인터럽트가 발생하는 모든 장치를 하나의 직렬 회선으로 연결한다.
		- 우선순위가 높은 장치를 상위에 두고 우선순위 차례대로 배치한다.
	- **병렬(Parallel) 우선순위 부여 방식**
		- 인터럽트가 발생하는 모든 장치를 하나의 직렬 회선으로 연결한다.
		- 각 장치별 우선순위를 판별하기 위한 Mask register에 bit를 설정한다.
		- Mask register상 우선순위가 높은 서비스 루틴 수행중 우선순위가 낮은 bit들을 비활성화 시킬 수 있다.
		- 반대로 우선순위가 높은 인터럽트는 낮은 인터럽트 수행 중에도 우선 처리된다.

### 관련 용어
- **인터럽트 핸들러**
	- 실제 인터럽트를 처리하기 위한 루틴으로 인터럽트 서비스 루틴이라고도 한다.
	- 운영체제의 코드 영역에는 인터럽트별로 처리해야할 내용이 이미 프로그램되어 있다.
- **인터럽트 벡터**
	- 인터럽드 발생시 처리해야 할 인터럽트 핸들러의 주소를 인터럽트 별로 보관하고 있는 테이블이다.
- **PCB(Process Control Block)**
	- 커널의 데이터 영역에 존재하며 각각의 프로세스마다 고유의 PCB가 있다.
인터럽트 발생 시 프로세스의 어느 부분이 수행중이었는지를 저장한다.
(수행중이던 memory 주소, 레지스터값, 하드웨어 상태 등)


### 참고
- http://iris.kaist.ac.kr/download/mp/chapter_4_interrupt.pdf
- https://namu.wiki/w/%EC%9D%B8%ED%84%B0%EB%9F%BD%ED%8A%B8
- http://itwiki.kr/w/%EC%9D%B8%ED%84%B0%EB%9F%BD%ED%8A%B8
- https://velog.io/@adam2/%EC%9D%B8%ED%84%B0%EB%9F%BD%ED%8A%B8