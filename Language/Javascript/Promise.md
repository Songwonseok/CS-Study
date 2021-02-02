## Promise

**“A promise is an object that may produce a single value some time in the future”**

프로미스는 자바스크립트 비동기 처리에 사용되는 객체입니다. 여기서 자바스크립트의 비동기 처리란 ‘특정 코드의 실행이 완료될 때까지 기다리지 않고 다음 코드를 먼저 수행하는 자바스크립트의 특성’을 의미한다.

---

### Promise가 왜 필요한가요?

프로미스는 주로 서버에서 받아온 데이터를 화면에 표시할 때 사용합니다. 일반적으로 웹 애플리케이션을 구현할 때 서버에서 데이터를 요청하고 받아오기 위해 아래와 같은 API를 사용합니다.

```js
$.get('url 주소/products/1', function(response) {
  // ...
});
JsCopy
```

위 API가 실행되면 서버에다가 ‘데이터 하나 보내주세요’ 라는 요청을 보내죠. 그런데 여기서 데이터를 받아오기도 전에 마치 데이터를 다 받아온 것 마냥 화면에 데이터를 표시하려고 하면 오류가 발생하거나 빈 화면이 뜹니다. 이와 같은 문제점을 해결하기 위한 방법 중 하나가 프로미스입니다.

### 프로미스 코드 - 기초

그럼 프로미스가 어떻게 동작하는지 이해하기 위해 예제 코드를 살펴보겠습니다. 먼저 아래 코드는 간단한 ajax 통신 코드입니다.

```js
function getData(callbackFunc) {
  $.get('url 주소/products/1', function(response) {
    callbackFunc(response); // 서버에서 받은 데이터 response를 callbackFunc() 함수에 넘겨줌
  });
}

getData(function(tableData) {
  console.log(tableData); // $.get()의 response 값이 tableData에 전달됨
});
JsCopy
```

위 코드는 제이쿼리의 [ajax 통신 API](https://api.jquery.com/jquery.get/)를 이용하여 지정된 url에서 1번 상품 데이터를 받아오는 코드입니다. 비동기 처리를 위해 프로미스 대신에 콜백 함수를 사용했습니다.

위 코드에 프로미스를 적용하면 아래와 같은 코드가 됩니다.

```js
function getData(callback) {
  // new Promise() 추가
  return new Promise(function(resolve, reject) {
    $.get('url 주소/products/1', function(response) {
      // 데이터를 받으면 resolve() 호출
      resolve(response);
    });
  });
}

// getData()의 실행이 끝나면 호출되는 then()
getData().then(function(tableData) {
  // resolve()의 결과 값이 여기로 전달됨
  console.log(tableData); // $.get()의 reponse 값이 tableData에 전달됨
});
JsCopy
```

콜백 함수로 처리하던 구조에서 `new Promise()`, `resolve()`, `then()`와 같은 프로미스 API를 사용한 구조로 바뀌었습니다. 여기서 `new Promise()`는 좀 이해가 가겠는데 `resolve()`, `then()`은 뭐 하는 애들일까요? 아래에서 함께 알아보겠습니다.

---

### 프로미스의 3가지 상태(states)

프로미스를 사용할 때 알아야 하는 가장 기본적인 개념이 바로 프로미스의 상태(states)입니다. 여기서 말하는 상태란 프로미스의 처리 과정을 의미합니다. `new Promise()`로 프로미스를 생성하고 종료될 때까지 3가지 상태를 갖습니다.

- Pending(대기) : 비동기 처리 로직이 아직 완료되지 않은 상태
- Fulfilled(이행) : 비동기 처리가 완료되어 프로미스가 결과 값을 반환해준 상태
- Rejected(실패) : 비동기 처리가 실패하거나 오류가 발생한 상태



#### Pending(대기)

먼저 아래와 같이 `new Promise()` 메서드를 호출하면 대기(Pending) 상태가 됩니다.

```js
new Promise();
JsCopy
```

`new Promise()` 메서드를 호출할 때 콜백 함수를 선언할 수 있고, 콜백 함수의 인자는 `resolve`, `reject`입니다.

```js
new Promise(function(resolve, reject) {
  // ...
});
JsCopy
```



#### Fulfilled(이행)

여기서 콜백 함수의 인자 `resolve`를 아래와 같이 실행하면 이행(Fulfilled) 상태가 됩니다.

```js
new Promise(function(resolve, reject) {
  resolve();
});
JsCopy
```

그리고 이행 상태가 되면 아래와 같이 `then()`을 이용하여 처리 결과 값을 받을 수 있습니다.

```js
function getData() {
  return new Promise(function(resolve, reject) {
    var data = 100;
    resolve(data);
  });
}

// resolve()의 결과 값 data를 resolvedData로 받음
getData().then(function(resolvedData) {
  console.log(resolvedData); // 100
});
JsCopy
```

※ 프로미스의 '이행' 상태를 좀 다르게 표현해보면 '완료' 입니다.



#### Rejected(실패)

`new Promise()`로 프로미스 객체를 생성하면 콜백 함수 인자로 `resolve`와 `reject`를 사용할 수 있다고 했습니다. 여기서 `reject`를 아래와 같이 호출하면 실패(Rejected) 상태가 됩니다.

```js
new Promise(function(resolve, reject) {
  reject();
});
JsCopy
```

그리고, 실패 상태가 되면 실패한 이유(실패 처리의 결과 값)를 `catch()`로 받을 수 있습니다.

```js
function getData() {
  return new Promise(function(resolve, reject) {
    reject(new Error("Request is failed"));
  });
}

// reject()의 결과 값 Error를 err에 받음
getData().then().catch(function(err) {
  console.log(err); // Error: Request is failed
});
JsCopy
```

![img](https://joshua1988.github.io/images/posts/web/javascript/promise.svg)





### 프로미스 코드 - 쉬운 예제

그럼 위에서 배운 내용들을 종합하여 간단한 프로미스 코드를 만들어보겠습니다. 이해하기 쉽게 앞에서 살펴본 ajax 통신 예제 코드에 프로미스를 적용해보겠습니다.

```js
function getData() {
  return new Promise(function(resolve, reject) {
    $.get('url 주소/products/1', function(response) {
      if (response) {
        resolve(response);
      }
      reject(new Error("Request is failed"));
    });
  });
}

// 위 $.get() 호출 결과에 따라 'response' 또는 'Error' 출력
getData().then(function(data) {
  console.log(data); // response 값 출력
}).catch(function(err) {
  console.error(err); // Error 출력
});
JsCopy
```

위 코드는 서버에서 제대로 응답을 받아오면 `resolve()` 메서드를 호출하고, 응답이 없으면 `reject()` 메서드를 호출하는 예제입니다. 호출된 메서드에 따라 `then()`이나 `catch()`로 분기하여 응답 결과 또는 오류를 출력합니다.





---



##  promise와 async/await의 차이

### promise

```
console.log('aa');

const promise = new Promise(function(resolve, reject) {
    setTimeout(function() {
        resolve('foo');
    }, 1000);
});

console.log('bb');

promise.then(function(value) {
    console.log(value);
    // expected output: "foo"
});

console.log('cc');

// 출력
// aa
// bb
// cc
// foo
```

promise.then()이 끝나고 난 후 cc를 출력하기를 기대하지만, 그렇지 않다.

promise를 사용하면 promise객체 생성시 콜백 함수를 이용해 동기화할 수 있지만, 밖의 코드는 동기화 할 수 없다.

 

### async await

```
console.log('aa');

const promise = new Promise(function(resolve, reject) {
    setTimeout(function() {
        resolve('foo');
    }, 1000);
});

console.log('bb');

async function asyncCall() {
    try {
        console.log('calling');
        const result = await promise;
        console.log(result);
    }
    catch (err) {
        console.log(err);
    }
    
}
console.log('cc');

asyncCall();

console.log('dd');


// 출력
// aa
// bb
// cc
// calling
// dd
// foo
```

하지만 async await를 사용하면 promise 밖의 코드와 동기화 할 수 있다.



**즉, promise가 resolve하거나 reject할 때 까지 asyncCall내부에서 기다린다. 그 결과, result를 정상적으로 출력한다.**

**만약 result를 출력한 후 dd가 출력되도록 하고 싶다면 또 async함수로 감싸줘야 할 것이다.**

**참고로, async await를 사용하면 promise.then().catch()처럼 reject를 잡아낼 수 없기 때문에, try catch문을 사용해야 한다.**







### 참고자료

- [자바스크립트 Promise 쉽게 이해하기(캡틴판교)](https://joshua1988.github.io/web-development/javascript/promise-for-beginners/#promise%EA%B0%80-%EC%99%9C-%ED%95%84%EC%9A%94%ED%95%9C%EA%B0%80%EC%9A%94)

- [promise와 async await의 차이](https://kjwsx23.tistory.com/294)