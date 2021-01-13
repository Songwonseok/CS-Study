

# TCP/IP 흐름제어 & 혼잡제어



### 흐름제어와 혼잡제어는 언제 사용할까?

- 흐름제어 : 송신측과 수신측의 데이터 처리 속도 차이를 해결하기 위한 기법
- 혼잡제어 : 송신측의 데이터 전달과 네트워크의 데이터 처리 속도 차이를 해결하기 위한 기법



### 흐름제어 (Flow Control)

- 수신측이 송신측보다 빠르면 문제가 없지만, 송신측의 속도가 빠를 경우 문제가 생깁니다.

  (수신측에서 제한된 저장용량을 초과한 이후에 도착하는 데이터는 손실이 될 수 있으며, 만약 손실이 된다면 불필요한 응답과 데이터 전송이 송/수신측 모두에게 발생한다.)

- 따라서 이러한 문제가 발생하지 않기 위해 송신 측의 데이터 전송량을 수신측에 따라 조절해야만 한다.

- 이를 해결하기 위한 방식으로 **Stop and wait** 방식과 **Sliding Window**  방식이 있다.

  1. Stop and wait 방식

     - 매 번 전송한 패킷에 대해 확인응답을 받아야만 그 다음 패킷을 전송하는 방법
     - ![TCPIP-흐름제어&혼잡제어-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Network/images/TCPIP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%26%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4-1.png)

  2. Sliding Window 방식

     - 수신측에서 설정한 윈도우 크기만큼 송신측에서 확인응답없이 세그먼트를 전송 할 수 있게 하여 데이터 흐름을 동적으로 조절하는 제어 기법
     - 윈도우에 포함되는 모든 패킷을 전송하고, 그 패킷들의 전달이 확인되는대로 이 윈도우를 옆으로 옮김(Slide)으로써 그 다음 패킷들을 전송
     - 전송은 되었지만, acked를 받지 못한 byte의 숫자를 파악하기 위해 사용하는 프로토콜
       (LastByteSent) - (LastByteAcked) <= (ReceivecWindowAdvertised)
       (마지막에 보내진 바이트) - (마지막에 확인된 바이트) <= (남아있는 공간)

     - 동작 방식: 윈도우에 포함되는 모든 패킷을 전송하고, 패킷들의 전달이 확인되는대로 윈도우를 옆으로 옮김으로써 다음 패킷들을 전송

       **윈도우(Window)** : TCP/IP를 사용하는 모든 호스트들은 송신과 수신을 위해 2개의 윈도우를 가지고 있다. 호스트들은 실제 데이터를 보내기 전 3 way handshaking을 통해 수신 호스트의 receive window size만큼 자신의 send window size를 맞추어야 한다.

       ![TCPIP-흐름제어&혼잡제어-2](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Network/images/TCPIP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%26%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4-2.png)

       

       - 송신버퍼

         ​	![TCPIP-흐름제어&혼잡제어-3](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Network/images/TCPIP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%26%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4-3.png)

         1. 200이전(200 오른쪽)의 바이트는 이미 전송되었고, 확인응답을 받은 상태

         2. 200~202 바이트는 전송되었으나, ACK(확인응답)을 받지 못한 상태
         3. 203~211 바이트는 아직 전송이 안된 상태

         

       - 수신 윈도우

         ![TCPIP-흐름제어&혼잡제어-4](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Network/images/TCPIP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%26%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4-4.png)

         1.  수신 프로세스가 처리할 바이트는 194바이트부터 이다.
         2. 수신 윈도우는 200의 수신을 기다린다.

         

       - 송신 윈도우

         ![TCPIP-흐름제어&혼잡제어-5](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Network/images/TCPIP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%26%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4-5.png)

         1.  수신 윈도우보다 작거나 같은 크기로 송신 위도우를 지정하게 되면 흐름제어 가능

            

       - 송신 윈도우의 이동

         ![TCPIP-흐름제어&혼잡제어-6](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Network/images/TCPIP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%26%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4-6.png)

         1. Before상태에서 203~204를 전송하면 수신측에서 확인응답으로 203을 보내준다.
         2. 송신측은 이를 확인응답을 받아 After사애와 같이 윈도우를 203~209범위로 이동시킨다.
         3. 그 후 205~209가 전송 가능한 상태가 된다.



### 혼잡제어 (Congestion Control)

- 한 라우터에 데이터가 몰리는 경우 등의 네트워크의 혼잡을 피하기 위해 송신측에서 보내는 데이터의 전송속도를 강제로 줄이는 작업
- 네트워크 내에 패킷의 수가 과도하게 증가하는 현상을 방지하는 현상도 혼잡제어라 부른다.
- 송신측과 수신측 사이의 전송속도를 다루는 흐름제어 와는 혼잡제어는 **호스트와 라우터를 포함한 넓은 관점에서의 전송문제를 다룬다.**
- ![TCPIP-흐름제어&혼잡제어-7](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/Network/images/TCPIP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%26%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4-7.png)



### 혼잡제어 해결방법

1. AIMD(Addtive Increase / Multicative Decrease) (합 증가 / 곱감소)
   - 패킷을 하나씩 보내고 문제없이 도착하면 윈도우크기(단위시간 내에 보내는 패킷의 수)를 1씩 증가시켜가며 전송하는 방법
   - 만약 패킷전송을 실패하거나 일정시간을 넘으면 패킷을 보내는 속도를 절반으로 줄이게 된다.
   - 매우 공평한 방식으로, 여러 호스트가 한 네트워크를 공유하고 있으면 나중에 진입하는 쪽이 불리하지만, **시간이 지날 수록 평형상태로 수렴하는 특징** 이 있다.
   - _문제점_ 으로는 초기 네트워크의 높은 대역폭을 사용못하여 오랜 시간이 걸리고, 혼잡해지는 상황을 미리 감지하지 못해 **네트워크 혼잡을 경험한 후 대역폭을 조정** 하는 방식이다.

2. Slow Start (느린 시작)
   - 합 증가 / 곱 감소 방식과 마찬가지로 패킷을 하나씩 보내는 것부터 시작하고, 패킷이 문제 없이 도착하면 각각의 ACK 패킷마다 윈도우크기를 1씩 늘려준다.
   - 위와 같은 방법으로 한 주기가 지나면 윈도우크기는 2배가 된다. 이러한 전송속도는 지수 함수 꼴로 증가된다.
   - 만약 혼잡제어 현상이 발생하면 윈도우크기를 1로 떨어뜨린다.
   - 초기에 네트워크 수용량을 예상할 수 없는 정보가 없지만, 혼잡제어가 발생한다면 네트워크 수용량을 어느정도 예상할 수 있으므로 **위도우크기의 절반까지는 이전처럼 지수함수 꼴로 크기를 증가시키고 이후부터는 완만하게 1씩 증가시킨다.**
3. Fast Retransmit (빠른 재전송)
   - 패킷을 받는 쪽에서 먼저 도착해야 할 패킷이 도착하지 않고 다음 패킷이 도착한 경우에도 ACK 패킷을 보내게 된다.
   - 순서대로 잘 도착한 마지막 패킷의 ACK패킷보다 다음 패킷이 먼저 도착하여 다음 패킷의 순번을 ACK 패킷을 먼저 실어서 보내게 된다면 중간에 패킷 하나가 손실되는데 이를 해결하는 방법이다
   - 빠른 재전송은 **중복된 순번의 패킷을 3개 받으면 재전송을 하게 된다.** 이런 현상이 일어나는 것은 약간 혼잡한 상황이 일어난 것이므로 혼잡을 감지하고 윈도우크기를 줄이게 된다.
4. Fast Recovery (빠른 회복)
   - 빠른 회복 정책은 혼잡한 상태가 되면 윈도우크기를 1로 줄이지 않고 반으로 줄이고 선형 증가시키는 방법이다.
   - 혼잡상황을 한 번 겪고나서부터는 순수한 합 증가 / 곱 감소 방식으로 동작하게 된다.



[참고블로그1](https://jwprogramming.tistory.com/36)

[참고블로그2](https://gyoogle.dev/blog/computer-science/network/%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%20&%20%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4.html)

[참고블로그3](https://rok93.tistory.com/entry/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-TCP-%ED%9D%90%EB%A6%84%EC%A0%9C%EC%96%B4%ED%98%BC%EC%9E%A1%EC%A0%9C%EC%96%B4)