# Closure

Closure(클로저)는 **두 개의 함수로 만들어진 환경** 으로 이루어진 특별한 객체의 한 종류이다. 여기서 **환경** 이라 함은 클로저가 생성될 때 그 **범위** 에 있던 여러 지역 변수들이 포함된 `context`를 말한다. 이 클로저를 통해서 자바스크립트에는 없는 비공개(private) 속성/메소드, 공개 속성/메소드를 구현할 수 있는 방안을 마련할 수 있다.



### 클로저 생성하기

> **생성조건**
>
> 1. 내부 함수가 익명 함수로 되어 외부 함수의 반환값으로 사용된다.
> 2. 내부 함수는 외부 함수의 실행 환경(execution environment)에서 실행된다.
> 3. 내부 함수에서 사용되는 변수 x 는 외부 함수의 변수 스코프에 있다.



- 자바스크립트에서 클로저는 함수가 생성되는 시점에 생성된다.
  = 함수가 생성될 때 그 함수의 렉시컬 환경을 포섭(closure)하여 실행될 때 이용한다.

따라서 개념적으로 자바스크립트의 모든 함수는 클로저이지만, 실제로 우리는 **자바스크립트의 모든 함수를 전부 클로저라고 부르지는 않는다.**

다음 예시들을 통해서 클로저를 조금 더 정확하게 파악할 수 있다.

```js
function foo() {
    var color = 'blue';
    function bar() {
        console.log(color);
    }
    bar();
}
foo();
```

`bar`함수는 `우리가 부르는 클로저`일까 아닐까?

일단 `bar`는 `foo`안에 속하기 때문에 `foo`스코프를 외부 스코프(outer lexical environment) 참조로 저장한다. 그리고 `bar`는 자신의 렉시컬 스코프 체인을 통해 `foo`의 `color`를 정확히 참조할 것이다.

그럼 클로저라 볼 수 있지 않을까?

*아니다. 우리가 부르는 클로저라고 하기에는 약간 거리가 있다.* `bar`는 `foo`안에서 정의되고 실행되었을 뿐, `foo`밖으로 나오지 않았기 때문에 클로저라고 부르지 않는다.

대신, 다음 코드는 우리가 실제로 부르는 클로저를 나타내고 있다.

```js
var color = 'red';
function foo() {
    var color = 'blue'; // 2
    function bar() {
        console.log(color); // 1
    }
    return bar;
}
var baz = foo(); // 3
baz(); // 4
```

1. `bar`는 `color`를 찾아 출력하는 함수로 정의되었다.
2. 그리고 `bar`는 outer environment 참조로 foo의 environment를 저장하였다.
3. `bar`를 `global`의 `baz`란 이름으로 데려왔다.
4. `global`에서 `baz(=bar)`를 호출했다.
5. `bar`는 자신의 스코프에서 `color`를 찾는다.
6. 없다. 자신의 outer environment 참조를 찾아간다.
7. outer environment인 foo의 스코프를 뒤진다. `color`를 찾았다. 값은 `blue`이다.
8. 때문에 당연히 `blue`가 출력된다.

이게 바로 클로저다. 그냥 단순하게 보면 "이 당연하게 왜?"라고 생각할 수 있지만, 조금 더 자세히 따져보도록 하자.

일단 중요한 부분은 2~4번, 그리고 7번이다. **`bar`는 자신이 생성된 렉시컬 스코프에서 벗어나 global에서 `baz`라는 이름으로 호출이 되었고, 스코프 탐색은 현재 실행 스택과 관련 없는 `foo`를 거쳐 갔다.** `baz`를 `bar`로 초기화할 때는 이미 `bar`의 `outer lexical environment`를 `foo`로 결정한 이후이다. 때문에, `bar`의 생성과 직접적인 관련이 없는 `global`에서 아무리 호출하더라도 여전히 `foo`에서 `color`를 찾는 것이다. 이런 `bar(또는 baz)`와 같은 함수를 우리는 클로저라고 부른다.

![closure2.png](C:\Users\dnjst\OneDrive\바탕 화면\STUDY\CS\CS-Study\Language\images\js-closure-1.PNG)

여기에서 다시 한번 강조하지만 JS의 스코프는 렉시컬 스코프, 즉 이름의 범위는 소스코드가 작성된 그 문맥에서 바로 결정되는 것이다.

추가로, `foo`의 렉시컬환경 인스턴스는 `foo();`수행이 끝난 이후 GC가 회수해야 하는데 사실을 그렇지 않다. 앞에 설명했듯 `bar`는 여전히 바깥 렉시컬 환경인 `foo`의 렉시컬 환경을 계속 참조하고 있고, 이 `bar`는 `baz`가 여전히 참조하고 있기 때문이다.(`baz(=bar) -> foo`)

![gc-closure.png](C:\Users\dnjst\OneDrive\바탕 화면\STUDY\CS\CS-Study\Language\images\js-closure-2.PNG)

### 유명하고 또 유명한 반복문 클로저

```js
function count() {
    var i;
    for (i = 1; i < 10; i += 1) {
        setTimeout(function timer() {
            console.log(i);
        }, i*100);
    }
}
count();
```

이 코드는 1, 2, 3, ... 9를 0.1초마다 출력하는 것이 목표였는데, 결과로는 `10`이 9번 출력되었다. 왜일까?

`timer`는 클로저로 언제 어디서 어떻게 호출되던지 항상 상위 스코프인 `count`에게 `i`를 알려달라고 요청할 것이다. 그리고 `timer`는 0.1초 후 호출된다. 그런데 첫 0.1초가 지날 동안 이미 `i`는 `10`이 되었다. 그리고 `timer`는 0.1초 주기로 호출될 때마다 항상 `count`에서 `i`를 찾는다. 결국, `timer`는 이미 `10`이 되어버린 `i`만 출력하게 된다.

그럼 의도대로 1~9까지 차례대로 출력하고 싶으면 어떻게 해야 할까?

1. 새로운 스코프를 추가하여 반복 시마다 그곳에 각각 따로 값을 저장하는 방식
2. ES6에서 추가된 블록 스코프를 이용하는 방식

이렇게 두 가지가 있을 것이다.

다음 코드는 원래 의도대로 동작한다.

1. 새로운 스코프를 추가하여 반복 시마다 그곳에 각각 따로 값을 저장하는 방식

   ```js
   function count() {
       var i;
       for (i = 1; i < 10; i += 1) {
           (function(countingNumber) {
               setTimeout(function timer() {
                   console.log(countingNumber);
               }, i * 100);
           })(i);
       }
   }
   count();
   ```

2. ES6에서 추가된 블록 스코프를 이용하는 방식

   ```js
    function count() {
        'use strict';
        for (let i = 1; i < 10; i += 1) {
            setTimeout(function timer() {
                console.log(i);
            }, i * 100);
        }
    }
    count();
   ```



### **클로저 private variable**

```javascript
const person = function(name){
  return {
      getName: function (){
          return name
      },
      setName(newName){
          name = newName;
      }
  }
}

const p1 = person('홍길동');
console.log(p1.getName());// 홍길동

p1.setName('김철수')
console.log(p1.getName()); // 김철수
```



#### 출처

- [TOAST meetup - 자바스크립트의 스코프와 클로저](http://meetup.toast.com/posts/86) **(읽어볼 것!)**