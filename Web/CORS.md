

## CORS

다른 도메인으로부터 리소스가 요청될 경우 해당 리소스는 **cross-origin HTTP 요청** 에 의해 요청된다. 하지만 대부분의 브라우저들은 보안 상의 이유로 스크립트에서의 cross-origin HTTP 요청을 제한한다. 이것을 `Same-Origin-Policy(동일 근원 정책)`이라고 한다. 요청을 보내기 위해서는 요청을 보내고자 하는 대상과 프로토콜도 같아야 하고, 포트도 같아야 함을 의미한다.*(이 때, 서브 도메인 네임은 상관없다.)*

이러한 문제를 해결하기 위해 과거에는 flash 를 proxy 로 두고 타 도메인간 통신을 했다. 하지만 모바일 운영체제의 등장으로 flash 로는 힘들어졌다. (iOS 는 전혀 플래시를 지원하지 않는다.) 대체제로 나온 기술이 `JSONP(JSON-padding)`이다. jQuery v.1.2 이상부터 `jsonp`형태가 지원되 ajax 를 호출할 때 타 도메인간 호출이 가능해졌다. `JSONP`에는 타 도메인간 자원을 공유할 수 있는 몇 가지 태그가 존재한다. 예를들어 `img`, `iframe`, `anchor`, `script`, `link` 등이 존재한다.

여기서 `CORS`는 타 도메인 간에 자원을 공유할 수 있게 해주는 것이다. `Cross-Origin Resource Sharing` 표준은 웹 브라우저가 사용하는 정보를 읽을 수 있도록 허가된 **출처 집합**을 서버에게 알려주도록 허용하는 특정 HTTP 헤더를 추가함으로써 동작한다.



### JSONP란

**2009년**에 CORS가 나오기 전까지 다른 도메인에 비동기 요청을 하기 위해 사용되던 방법입니다. **자바스크립트 파일 내에서 다른 도메인에 데이터를 요청할 경우 SOP에 위배되어 에러가 나게 됩니다. 예를들어, https://test.com에서 요청을 보내면 https://test.com도메인을 가진 서버에만 요청을 보낼 수 있습니다.**

하지만, html파일내에 있는 **<script src=”https://test.com”></script>**태그를 이용하면 SOP를 피해갈수 있습니다. https://localhost에서 https://test.com**(서로 다른 도메인)**의 데이터를 가져올 수 있는거죠. 다만 조건이 있습니다.

1. 서버에서 Json형태로 데이터를 내려줘야함.
2. script태그로 받아온 Json 데이터를 브라우저 어딘가에 저장해놔야 쓸 수 있음.



#### 받아온 Json데이터를 어디에 저장해야 하는가?

단순히 **var result = <script src=”…”></script>;** 와 같이 변수에 값을 할당하는 방식은 **사용이 불가능**하기 때문에 다른 방법이 필요합니다. 서버의 Json데이터를 어떻게 브라우저 까지 가져오는지 살펴보겠습니다.

```
// 브라우저
<script src="https://test.com"></script>
```

html 하단에 위와 같은 script태그가 있습니다.

```
// 서버에서 내려줌
myCallback({
  title : 'hello world!'
})
```

서버에서는 단순히 Json데이터를 내려주는게 아니라 myCallback()으로 감싸서 내려줍니다. 왜냐면 <script>태그의 결과물 자체를 변수에 저장할 수 없기 때문이죠.

```
// 브라우저<script>
function myCallback(json){
   window.result = json;
}
</script><script src="https://test.com"></script>
-> 다음과 같이 변환됨.
myCallback({
   title : 'hello world!'
})
```

서버에서 내려준 콜백함수가(**myCallback**) 미리 html에서 정의가 되어 있어야합니다.

**이런식으로 서버에서 내려준 json 데이터를 콜백함수를 통해서 브라우저의 전역변수인 window객체에 넣어서 사용할 수 있게 되었습니다.** 이러한 방법은 CORS가 2009년에 나오기전까지 사용되던 방법인데 이제는 보안상의 이슈로 더이상 사용되지 않는다고 합니다.





### CORS 관련 HTTP Response Headers

>  서버에서 CORS 요청을 처리할 때 지정하는 헤더

| HTTP Header                      | Description                    |
| -------------------------------- | ------------------------------ |
| Access-Control-Allow-Origin      | 접근 가능한 `url` 설정         |
| Access-Control-Allow-Credentials | 접근 가능한 `쿠키` 설정        |
| Access-Control-Allow-Headers     | 접근 가능한 `헤더` 설정        |
| Access-Control-Allow-Methods     | 접근 가능한 `http method` 설정 |





## CORS 요청의 종류

CORS 요청은 Simple/Preflight, Credential/Non-Credential의 조합으로 4가지가 존재한다.

브라우저가 요청 내용을 분석하여 4가지 방식 중 해당하는 방식으로 서버에 요청을 날리므로, 프로그래머가 목적에 맞는 방식을 선택하고 그 조건에 맞게 코딩해야 한다.

### 1) Simple Request

아래의 3가지 조건을 모두 만족하면 Simple Request

- GET, HEAD, POST 중의 한 가지 방식을 사용해야 한다.
- POST 방식일 경우 Content-type이 아래 셋 중의 하나여야 한다.
  - application/x-www-form-urlencoded
  - multipart/form-data
  - text/plain
- 커스텀 헤더를 전송하지 말아야 한다.

Simple Request는 서버에 1번 요청하고, 서버도 1번 회신하는 것으로 처리가 종료된다.

---



### 2) Preflight Request

실제 요청을 보내도 안전한지 판단하기 위해 preflight 요청을 먼저 보내는 방법이다.

Simple Request 조건에 해당하지 않으면 브라우저는 Preflight Request 방식으로 요청한다.

따라서, Preflight Request는

- GET, HEAD, POST 외의 다른 방식으로도 요청을 보낼 수 있고,
- application/xml 처럼 다른 Content-type으로 요청을 보낼 수도 있으며,
- 커스텀 헤더도 사용할 수 있다. 
  - ex) `Access-Control-Request-Header: custom`
- 이 요청으로 트래픽이 증가할 수 있는데 서버의 헤더 설정으로 캐쉬가 가능하다.

이름에서 짐작할 수 있듯, Preflight Request는 예비 요청과 본 요청으로 나뉘어 전송된다.

먼저 서버에 예비 요청(Preflight Request)를 보내고 서버는 예비 요청에 대해 응답하고,
그 다음에 본 요청(Actual Request)을 서버에 보내고, 서버도 본 요청에 응답한다.

***하지만, 예비 요청과 본 요청에 대한 서버단의 응답을 프로그래머가 프로그램 내에서 구분하여 처리하는 것은 아니다.***

프로그래머가 **`Access-Control-`** 계열의 Response Header만 적절히 정해주면,
OPTIONS 요청으로 오는 예비 요청과 GET, POST, HEAD, PUT, DELETE 등으로 오는 본 요청의 처리는 서버가 알아서 처리한다.



### 3) Request with Credential

HTTP Cookie와 HTTP Authentication 정보를 인식할 수 있게 해주는 요청

요청 시 **`xhr.withCredentials = true`**를 지정해서 Credential 요청을 보낼 수 있고,
서버는 Response Header에 반드시 **`Access-Control-Allow-Credentials: true`**를 포함해야 하고,
**`Access-Control-Allow-Origin`** 헤더의 값에는 **`\*`**가 오면 안되고 `http://foo.origin`과 같은 구체적인 도메인이 와야 한다.



### 4) Request without Credential

CORS 요청은 기본적으로 Non-Credential 요청이므로, **`xhr.withCredentials = true`**를 지정하지 않으면 Non-Credential 요청이다.



#### Reference

- [MDN - HTTP 접근 제어 CORS](https://developer.mozilla.org/ko/docs/Web/HTTP/Access_control_CORS)
- [Cross-Origin-Resource-Sharing 에 대해서](http://homoefficio.github.io/2015/07/21/Cross-Origin-Resource-Sharing/)
- [구루비 - CORS 에 대해서](http://wiki.gurubee.net/display/SWDEV/CORS+(Cross-Origin+Resource+Sharing))