# HTTP Method

### HTTP란?

- **요청 메서드** 를 정의하여, 주어진 리소스에 수행하길 원하는 행동을 나타내는 것

- 일부 기능으로는 Method 집합 간에 서로 공유하여 보안성과, **멱등성** , 캐시를 가능케 한다.

  **멱등성** : 연산을 여러 번 적용하더라도 결과가 달라지지 않는 현상



### HTTP Method의 종류

- **GET** 

  - 특정 리소스의 표시를 요청할 때 사용, 오직 데이터를 받기만 한다.

    (SELECT 문을 이용한 데이터를 수신)

- **HEAD**

  - GET 메서드의 요청과 동일한 응답을 요구하지만, 응답 본문(body)을 포함하지 않는다.

    (Resource를 찾기만 할 때, Object가 존재할 경우 상태코드 확인할 때 사용)

- **POST** / **PUT**

  - **POST**
    - 특정 리소스에 엔티티를 제출할 때 사용. 종종 서버 상태의 변화와 부작용을 일으킴
    - 서버에 Data를 보내기 위한 용도
  - **PUT**
    - 서버가 Client 요청의 Body를 확인하여 요청 URL에 새로운 Resouce를 생성
    - 서버의 Resource에 Data를 저장하기 위한 용도

- **DELETE**

  - 요청 Resource를 삭제하도록 요청
  - BUT HTTP 규격에는 Client 요청에도 서버가 무효화 시킬 수 있다고 정의됨
  - DELETE Method는 항상 보장되지 않는다.

- **CONNECT**

- **OPTIONS**

  - Target Server의 지원 가능한 Method(ex) GET, POST, PUT etc..)를 확인

- **TRACE**

  - Original Data와 서버에 도달 했을 때의 비교본 Data를 서버 응답 Body를 통해 확인
  - 최종 수신자는 송신자에게 200(OK) 응답의 내용을 Body로 담은 메세지를 보내야한다.

- **PATCH**

  - Resource 부분만을 수정하는데 사용
    

![HTTP-Mehtod-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main\Web\images\HTTP-Mehtod-1.JPG)





### Status Code

- **1xx** 
  - 100 - continue
    - HTTP Client Application에서 서버에 Entiti Body를 보내기 전에 해당 Body를 받을 수 있는지 서버에 check 해볼 때 사용
    - 즉 웹서버가 해당 응답을 할수 있도록 구현 했다면 100 continue로 응답한다.
- **2xx** 
  - 200 - OK
  - 201 - Created ( PUT 메서드로 서버에 파일 생성)
  - 202 - Accepted (서버 명령 수신)
  - 203 - 서버가 Client 요구 중 일부만 전송
  - 204 - OK **but** 전송할 데이터 없음
- **3xx**
  - 301 - 요구한 데이터를 변경된 타 URL에 요청
  - 302 - Not temporarily (번역으로는 "일시적이지 않음")
  - 304 - 로컬의 캐시 정보를 이용함
- **4xx**
  - 400 - Bad Requst / 사용자의 잘못된 요청
  - 401 - Unauthorized / 인증이 필요한 페이지 요청
  - 402 - Payment required / 예약됨
  - 403 - Foibidden / 접근금지, 관리자가 차단
  - 404 - Not Found / 페이지 없음
  - 405 - Method not allowed / 허용되지 않은 HTTP Method 사용
  - 407 - Proxy authentication required / 프록시 인증 요구
  - 408 - Request timeout / 요청 시간 초과
  - 410 - Gone / 영구 사용 금지
- **5xx**
  - 500 - Internal server error / 내부 서버 오류
  - 501 - Not implemented / 웹 서버가 처리할 수 없음
  - 503 - Service unnailable / 서비스 제공 불가
  - 504 - Gateway timeout / 게이트웨이 시간 초과
  - 505 - HTTP version not supported / 해당 http 버전 지원 X





