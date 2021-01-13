# TCP 3 way handshake & 4 way handshake



### 간단한 TCP 복습

TCP는 전송계층(제 4계층)에서 사용하는 프로토콜로 신뢰성을 전송속도는 상대적(UDP)보다 느리지만 보장하는 연결형 서비스이다.



### 3 way handshake와  4 way handshake는 무엇일까?

- 3 way handshake

  - TCP통신을 이용하여 **데이터를 전송하기 위해 네트워크 연결** 을 설정하는 과정이다.

  - 양측 모두 데이터를 전송할 준비가 되어있다는 것을 보장하고, 실제로 데이터 전달이 시작하기 전 한 쪽이 다른 쪽이 준비가 되었다는 것을 알 수 있도록 해야한다.

    (전송하기 전 정확한 전송을 보장하기 위해 상대방 컴퓨터와 사전에 세션을 수립하는 과정)

  - ![TCP-3-way-handshake&4-way-handshake-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Network/images/TCP-3-way-handshake%264-way-handshake-1.png)

  - A프로세스(Client)가 B프로세스(Server)에 연결을 요청 할 때

    1. A  ㅡ> B : SYN
       - 접속을 요청할 프로세스 A가 프로세스 B에게 연결 메시지 전송 
         (SYN, Synchronization, 동기화 비트 and 연결 요청 플래그)
       - 송신자 A가 최초로 데이터를 전송할 때, Sequence Number(Seq)를 임의의 랜덤 숫자를 지정하고, SYN 플래그 비트를 1로 설정한 세크먼트를 전송한다.
       - PORT상태 ㅡ A : CLOSED(or SYN_SENT), B: LISTEN
    2. B ㅡ> A : SYN + ACK
       - 접속 요청을 받은 프로세스 B가 요청을 수락했으며, 접속을 요청한 프로세스 A에게 CLOSED된 포트를 열어달라는 메세지 전송 
         (ACK, Acknowledgement, "OK"응답을 알려주는 패킷)
       - 수신자 (프로세스 B) 는 Acknowledgement Number 필드를 Sequence Number + 1로 지정하고, SYN과 ACK 플래그 비트를 1로 설정한 세그먼트를 전송한다.
       - PORT상태 ㅡ A: CLOSED(or SYN_SENT), B: SYN_RCV or SYN_RCEV (SYN Receive, SYN를 받은 상태)
    3. A ㅡ> B : ACK
       - PORT상태 ㅡ A: ESTABLISHED(포트 연결) , B: SYN_RCV or SYN_RCEV
       - 마지막으로 접속 요청 프로세스 A가 수락 확인을 보내 연결을 맺음 (ACK)
       - 이 때, 전송할 데이터가 있으면, 이 단계에서 데이터를 전송 할 수 있다.
       - PORT상태 ㅡ A: ESTABLISHED , B: ESTABLISHED



- 4 way handshake

  - **TCP의 연결을 해제** 하는 과정

  - ![TCP-3-way-handshake&4-way-handshake-2](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Network/images/TCP-3-way-handshake%264-way-handshake-2.png)

  - A프로세스(Client)가 B프로세스(Server)에 연결 해제를 요청할 때

    1. A -> B: FIN

       - 프로세스 A가 연결을 종료하겠다는 FIN플래그를 전송
         (FIN, Finish, 세션 연결 종료때 사용하며 더 이상 전송할 데이터가 없음을 의미)

       - 프로세스 B가 FIN 플래그로 응답하기 전까지 연결을 계속 유지

    2. B -> A: ACK

       - 프로세스 B는 일단 확인 메시지를 보내고 자신의 통신이 끝날 때까지 기다린다. (이 상태가 TIME_WAIT 상태)
       - 수신자는 Acknowledgement Number 필드를 (Sequence Number + 1)로 지정하고, ACK 플래그 비트를 1로 설정한 세그먼트를 전송한다.
       - 자신이 전송할 데이터가 남아있다면 이어서 계속 전송한다.

    3. B -> A: FIN

       - 프로세스 B가 통신이 끝났으면 연결 종료 요청에 합의한다는 의미로 프로세스 A에게 FIN 플래그를 전송

    4. A -> B: ACK

       - 프로세스 A는 확인했다는 메시지를 전송
         

<hr>

[참고블로그1](https://gmlwjd9405.github.io/2018/09/19/tcp-connection.html)

[참고블로그2](https://mindnet.tistory.com/entry/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EC%89%BD%EA%B2%8C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-22%ED%8E%B8-TCP-3-WayHandshake-4-WayHandshake)

[참고블로그3](https://kychul98.tistory.com/34)

[참고블로그4](https://asfirstalways.tistory.com/356)

<hr>

## 한 줄 요약

3 way handshake : TPC 통신으로 네트워크 연결을 할 때 사용하는 과정

4 way handshake : TPC 연결을 해제하는 과정

