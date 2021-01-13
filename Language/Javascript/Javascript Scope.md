# Javascript Scope

김춘수 시인의 "꽃"이라는 시를 보면, 어떤 하나의 몸짓은 이름을 통해 의미를 부여 받고 꽃이 된다.

프로그래밍도 마찬가지로 변수나 함수에 이름을 부여하여 의미를 갖도록 한다. *만약 이름이 없다면, 변수나 함수는 다만 그저 하나의 메모리 주소에 지나지 않는다.* 그래서 프로그램은 "이름:값"의 대응표를 만들어 사용한다. 이 대응표의 이름을 가지고 코드를 보다 쉽게 이해하고, 또 이름을 통해 값을 저장하고, 다시 가져와 수정한다.

초기 프로그래밍 언어는 이 대응표를 프로그램 전체에서 하나로 관리했는데, 여기에는 이름 충돌의 문제가 있었다. 그래서 충돌을 피하기 위해, 각 언어마다 "스코프"라는 규칙을 만들어 정의하였다. **그렇게 스코프 규칙은 언어의 명세(Specification)가 되었다.**

자바스크립트도 마찬가지로 자신의 스코프 규칙이 있다.

자바스크립트(ES6)는 `함수 레벨과 블록 레벨`의 `렉시컬 스코프`규칙을 따른다.

## 스코프 레벨

자바스크립트는 전통적으로 함수 레벨 스코프를 지원해왔고, 얼마 전까지만 해도 블록 레벨 스코프는 지원하지 않았다. 하지만 가장 최신 명세인 ES6(ECMAScript 6)부터 블록 레벨 스코프를 지원하기 시작했다.

### 함수 레벨 스코프

자바스크립트에서 `var`키워드로 선언된 변수나, `함수 선언식`으로 만들어진 함수는 `함수 레벨 스코프`를 갖는다. 즉, 함수 내부 전체에서 유효한 식별자가 된다.

아래 코드는 아무런 문제없이 `blue`를 출력한다.

```js
function foo() {
    if (true) {
        var color = 'blue';
    }
    console.log(color); // blue
}
foo();
```

만약 `var color`가 블록 레벨 스코프였다면, `color`는 `if`문이 끝날 때 파괴되고 `console.log`에서 잘못된 참조로 에러가 발생할 것이다. 그렇지만 `color`는 함수 레벨의 스코프이기 때문에 `foo` 함수 내부 어디에서든 에러 발생 없이 참조할 수 있다.

---



### 블록 레벨 스코프

ES6의 `let`, `const`키워드는 블록 레벨 스코프 변수를 만들어 준다.

```js
function foo() {
    if(true) {
        let color = 'blue';
        console.log(color); // blue
    }
    console.log(color); // ReferenceError: color is not defined
}
foo();
```

`let color`를 `if`블록 내부에서 선언하였다. 때문에 `if`블록 내부에서 참조할 수 있으며, 그 밖의 영역에서 잘못된 참조로 에러가 발생한다.

---



### `var` vs `let`, `const`

ES6가 표준화되면서, 블록 레벨과 함수 레벨을 모두 지원하게 되었다. "You don't know JS" 시리즈의 저자인 Kyle Simpson은 `var`, `let`, `const`가 서로 다르기에 필요한 상황에 알맞게 사용할 줄 알아야 한다고 설명하고 있다.

그렇지만 요즈음 ES6 코드 대부분은 `var`를 사용하지 않는다. `var`는 `let`과 `const`로 모두 대체가 가능하고, `var`자체가 함수 레벨의 스코프를 가지기 때문에 블록 레벨 스코프보다 더 많은 혼란을 야기하기 때문이다.

---



### 렉시컬 스코프

렉시컬 스코프(Lexical scope)는 보통 동적 스코프(Dynamic scope)와 많이 비교한다.

위키피디아를 보면 동적 스코프와 렉시컬 스코프를 다음과 같이 정의하고 있다.

- 동적 스코프

  > The name resolution depends upon the program state when the name is encountered which is determined by the execution context or calling context.

- 렉시컬 스코프 (정적 스코프(Static scope) 또는 수사적 스코프(Rhetorical scope))

  > The name resolution depends on the location in the source code and the lexical context, which is defined by where the named variable or function is defined.

동적 스코프는 프로그램의 런타임 도중의 실행 컨텍스트나 호출 컨텍스트에 의해 결정되고, 렉시컬 스코프에서는 소스코드가 작성된 그 문맥에서 결정된다. 현대 프로그래밍에서 대부분의 언어들은 렉시컬 스코프 규칙을 따르고 있다.

동적 스코프와 렉시컬 스코프는 자바스크립트와 Perl을 비교하여 확인할 수 있다. 아래는 자바스크립트와 Perl로 같은 코드를 작성하였을 때 나오는 결과이다.

![lexical-scope-js.png](C:\Users\dnjst\OneDrive\바탕 화면\STUDY\CS\CS-Study\Language\images\js-scope-1.PNG)

자바스크립트는 렉시컬 스코프 규칙을 통해 `global, global`을 출력하였으며, Perl은 동적 스코프 규칙을 통해 `local, global`을 출력하였다. (참고로 Perl에서 `local`대신 `my`키워드를 사용하면 변수의 유효범위를 제한하여, 자바스크립트와 같은 결과를 얻을 수 있다.)

렉시컬 스코프 규칙을 따르는 자바스크립트의 함수는 **호출 스택과 관계없이 각각의 (`this`를 제외한)대응표를 소스코드 기준으로 정의하고, 런타임에 그 대응표를 변경시키지 않는다.** (사실 런타임에 렉시컬 스코프를 수정할 수 있는 방법들(`eval`, `with`)이 있지만, 권장하지 않는다.)

---



### 중첩 스코프(스코프 체인 또는 스코프 버블)

우리가 말하는 이 자바스크립트의 스코프는 ECMAScript 언어 명세에서 렉시컬 환경(`Lexical environment`)과 환경 레코드(`Environment Record`)라는 개념으로 정의되었다.

> 6.2.5 The Lexical Environment and Environment Record Specification Types
>
> The Lexical Environment and Environment Record types are used to explain the behaviour of name resolution in nested functions and blocks. These types and the operations upon them are defined in 8.1.

간단하게 그림으로 표현해보면 아래와 같은 형태로 볼 수 있다.

![execution-context.png](C:\Users\dnjst\OneDrive\바탕 화면\STUDY\CS\CS-Study\Language\images\js-scope-2.PNG)

앞에서 설명한 "이름:값의 대응표"가 환경 레코드와 같다고 볼 수 있고, 렉시컬 환경은 이 환경 레코드와 상위 렉시켤 환경(Outer lexical environment)에 대한 참조로 이루어진다.

현재-렉시컬 환경의 대응표(환경 레코드)에서 변수를 찾아보고, 없다면 바깥 렉시컬 환경을 참조하여 찾아보는 식으로 중첩 스코프가 가능해진다. 이 중첩 스코프 탐색은 해당하는 이름을 찾거나 바깥 렉시컬 환경 참조가 `null`이 될 때 탐색을 멈춘다.

![scop-chain.png](C:\Users\dnjst\OneDrive\바탕 화면\STUDY\CS\CS-Study\Language\images\js-scope-3.PNG)

참고: ECMA-262 Edition3를 보면 자바스크립트의 스코프적 특징은 `Scope chain`(=list)과 `Activation Object`등의 개념으로 설명하였다. 그리고 이 설명들이 전반적으로 널리 알려졌지만, 이 다음 명세인 ECMA262 Edition5부터는 `Lexical Environment`와 `Environment Record`의 개념으로 스코프를 설명하고 있다.



#### 출처

- [TOAST Meetup! - 자바스크립트의 스코프와 클로저](https://meetup.toast.com/posts/86)