## Javascript Event loop

자바스크립트는 `싱글 스레드` 기반의 언어이다. 즉, 자바스크립트는 하나의 호출 스택을 가진다. 하나의 호출 스택을 가진 단일 스레드로 동작하는 자바스크립트에서 어떻게 동시성을 지원할까? 답은 이벤트 루프이다. 자바스크립트는 이벤트 루프 기반의 비동기 방식으로 Non-Blocking IO를 지원한다.



> Node.js는 확장성 있는 네트워크 애플리케이션(특히 서버 사이드) 개발에 사용되는 소프트웨어 플랫폼이다. 작성 언어로 자바스크립트를 활용하며 Non-blocking I/O와 단일 스레드 이벤트 루프를 통한 높은 처리 성능을 가지고 있다.

> Non-blocking I/O(Asynchronous I/O 혹은 Non-sequential I/O): Non-blocking I/O란, 입출력 처리는 시작만 해둔 채 완료되지 않은 상태에서 다른 처리 작업을 계속 진행할 수 있도록 멈추지 않고 입출력 처리를 기다리는 방법을 말한다

### 1. 자바스크립트 엔진의 구성요소

아래는 자바스크립트 엔진의 모습입니다.

![Alt Javascript Engine](https://iamsjy17.github.io/assets/img/howtoworksjs/engine.png)

- 자바스크립트 엔진
  - Heap : 메모리 할당이 일어나는 영역
  - Call Stack : 코드 실행에 따라 호출 스택이 쌓이는 영역

### 2. 런타임

위 그림에서도 알 수 있지만 중요한 사실은 자바스크립트에는 이벤트 루프가 없습니다. V8과 같은 자바스크립트 엔진은 단일 호출 스택을 사용하고, 요청이 들어오면 그 순서에 따라 순차적으로 처리할 뿐입니다.

그러면 비동기 요청은 어떻게 처리할까요?

자바스크립트 엔진을 구동하는 런타임 환경(브라우저나 Node.js)이 담당합니다.

- 런타임 환경이 제공하는 것
  - Web APIs
    - DOM(document)
    - AJAX(XMLHttpRequest)
    - Timeout(setTimeout)
  - Event Loop

![Alt Javascript EventLoop](https://iamsjy17.github.io/assets/img/howtoworksjs/eventloop.png)

위 그림과 같이 우리가 비동기 호출을 위해 사용하는 Web API과 Event Loop, Task Queue는 자바스크립트 엔진 외부에 런타임 환경에 구현이 되어있습니다.



### 3. 단일 호출 스택과 Run-to-Completion

이벤트 루프에 대해 좀더 알아보기 전에, 먼저 자바스크립트 언어의 특징을 하나 살펴보자. 자바스크립트의 함수가 실행되는 방식을 보통 **Run to Completion** 이라고 말한다.

이것의 의미는 하나의 함수가 실행되면 이 함수의 실행이 끝날 때까지 다른 작업이 중간에 끼어들지 못한다는 의미입니다.

다음의 예제를 보면

```javascript
function delay() {
    for (var i = 0; i < 100000; i++);
}
function foo() {
    delay();
    bar();
    console.log('foo!'); // (3)
}
function bar() {
    delay();
    console.log('bar!'); // (2)
}
function baz() {
    console.log('baz!'); // (4)
}

setTimeout(baz, 10); // (1)
foo();
```

자바스크립트를 경험해본 사람이라면, 아무리 `delay` 함수가 10ms 보다 오래 걸린다고 해도 'baz!'가 'foo!' 보다 먼저 콘솔에 찍히는 일은 없을 거라는 것을 알 것이다. 즉, `foo` 내부에서 `bar`를 호출하기 전에 10ms이 지났다고 해도 `baz`가 먼저 호출되지는 않는다는 말이다. 

그러므로 위의 예제를 실행하면 콘솔에는 ``'bar!' -> 'foo!' -> 'baz!'`` 의 순서로 찍히게 된다.

위의 코드가 전역 환경에서 실행된다고 가정하고 코드내 주석으로 숫자가 적힌 각 시점의 호출 스택을 그림으로 그려보면 다음과 같을 것이다.



`setTimeout` 함수는 브라우저에게 타이머 이벤트를 요청한 후에 바로 스택에서 제거된다. 그 후에 `foo` 함수가 스택에 추가되고, `foo` 함수가 내부적으로 실행하는 함수들이 차례로 스택에 추가되었다가 제거된다. 마지막으로 `foo` 함수가 실행을 마치면서 호출 스택이 비워지게 되고, 그 이후에 `baz` 함수가 스택에 추가되어 콘솔에 'baz!'가 찍히게 된다.

*(결과적으로 `baz`는 10ms보다 더 늦게 실행되게 될 것이다. 즉, 자바스크립트의 타이머는 정확한 타이밍을 보장해주지 않는다)*



### 4. 태스크 큐와 이벤트 루프

여기서 하나의 궁금증이 생긴다. `setTimeout` 함수를 통해 넘긴 `baz` 함수는 어떻게 `foo` 함수가 끝나자 마자 실행될 수 있을까? 어디서 대기하고 있다가 누구를 통해 실행될까? 

바로 이 역할을 하는 것이 Task Queue와 이벤트 루프이다. 

Task Queue는 말 그대로 콜백 함수들이 대기하는 큐(FIFO) 형태의 배열이라 할 수 있고, 이벤트 루프는 호출 스택이 비워질 때마다 큐에서 콜백 함수를 꺼내와서 실행하는 역할을 해 준다.

#### 이벤트 루프

이벤트 루프는 하나의 단순한 동작만을 수행한다. 호출 스택과 Task Queue를 감시하면서, 만약 호출 스택이 비어있다면 이벤트 루프는 큐에서 첫 번째 Task를 호출 스택에 넣고 해당 Task가 수행된다.

![Alt Event Loop](https://iamsjy17.github.io/assets/img/howtoworksjs/eventloop2.png)

이러한 반복을 이벤트 루프에서는 `tick`이라고 한다.

MDN에서 Event Loop을 보면 다음과 같이 간이 코드가 나온다. task queue는 message를 기다리고 message가 들어오면 task queue에 추가한다.

```javascript
while (queue.waitForMessage()) {
  queue.processNextMessage();
}
```

위 코드의 `waitForMessage()` 메소드는 현재 실행중인 태스크가 없을 때 다음 태스크가 큐에 추가될 때까지 대기하는 역할을 한다. 이런 식으로 이벤트 루프는 '**현재 실행중인 태스크가 없는지**'와 '**태스크 큐에 태스크가 있는지**'를 반복적으로 확인하는 것이다. 간단하게 정리하면 다음과 같을 것이다.

- 모든 비동기 API들은 작업이 완료되면 콜백 함수를 태스크 큐에 추가한다.
- 이벤트 루프는 '현재 실행중인 태스크가 없을 때'(주로 호출 스택이 비워졌을 때) 태스크 큐의 첫 번째 태스크를 꺼내와 실행한다.

```javascript
while (eventLoop.waitForTask()) {
  const taskQueue = eventLoop.selectTaskQueue();
  if (taskQueue.hasNextTask()) {
    taskQueue.processNextTask();
  }
}
```

그런데 이벤트 루프가 다발적으로 발생한 메시지들을 큐에 쌓고 실행을 해주면서 동시성을 확보하는 것이지 실제로 동시에 동작이 수행되는 것은 아닙니다.

실제 실행 자체는 호출 스택에 올라가서 수행이 되므로 Run-to-completion 으로 동작합니다.

> Run-to-completion : Each message is processed completely before any other message is processed.





## 참고 링크

- [자바스크립트와 이벤트 루프](https://meetup.toast.com/posts/89) **(자세하게 설명되어 있으니 꼭 한번 읽어볼 것!)**
- [자바스크립트의 호출 스택과 이벤트 루프](https://iamsjy17.github.io/javascript/2019/07/20/how-to-works-js.html)

- [자바스크립트 비동기 처리 과정과 RxJS Scheduler](http://sculove.github.io/blog/2018/01/18/javascriptflow/)