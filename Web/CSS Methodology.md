## CSS Methodology

프로젝트가 완성되어 가는 만큼 CSS도 그만큼 증가하고 복잡도는 높아진다. 불필요한 작업을 최소화 하고 작성된 코드를 쉽게 파악하고 유지보수성 까지 고려한다면 명확하고 일관성있는 규칙이 필요하다. 이 글에서는`SMACSS`, `OOCSS`, `BEM`에 대해서 소개한다.

---

### SMACSS(Scalable and Modular Architecture for CSS)

`SMACSS`의 핵심은 범주화이며(`categorization`) 스타일을 다섯 가지 유형으로 분류하고, 각 유형에 맞는 선택자(selector)와 작명법(naming convention)을 제시한다.

**Base : 스타일 초기화 (reset.css)**

```
body, p, table, form, fieldset, legend, input, button ... {
    margin: 0;
    padding: 0;
}
```

**layout : 주요 요소(id), 하위 요소(class)로 구분하고 접두사를 사용**

```
// layout => l-// 주요 요소 ()
#header {
    width: 400px;
}
#aside {
    width: 30px;
}// 하위 요소
.l-width #header {
    width: 600px;
    padding: 10px;
}
.l-width #aside {
    width: 100px
}
```

**module : 재사용 가능한 구성요소**

```
.stick { ... }
.stick-name { ... }
.stick-number { ... }
```

**state : 요소의 상태 변화를 표현하고 접두사 사용**

```
.is-error { ... }
.is-hidden { ... }
.is-disabled { ... }
```

**theme : 사용자가 선택 가능 하도록 스타일을 재선언하여 사용**

```
// base.css
.header {
    background-color: green;
}// theme.css
.header {
    background-color: red;
}
```

---

### OOCSS(Object Oriented CSS)

객체지향 CSS 방법론으로 2 가지 기본원칙을 갖고 있다.

- 원칙 1. 구조와 모양을 분리한다.
  - 반복적인 시각적 기능을 별도의 스킨으로 정의하여 다양한 객체와 혼합해 중복코드를 없앤다.
- 원칙 2. 컨테이너와 컨텐츠를 분리한다.
  - 스타일을 정의할 때 위치에 의존적인 스타일을 사용하지 않는다. 사물의 모양은 어디에 위치하든지 동일하게 보여야 한다.

**구조와 모양을 분리 또는 결합**

```
<div class="btn skin tel">tel</div>
<div class="btn skin">email</div>.btn{공통 스타일 정의}
.skin{공통 스타일 정의}
```

**컨테이너와 컨텐츠를 분리**

```
<div class="header common-width">Header</div>
<div class="footer common-width">Footer</div>
.header{
    position: fixed;
    top: 0;
}.footer{
    position: absolute;
    bottom: 0;
}.common-width{
    width: 700px;
    margin: 0;
}
```

공통된 부분을 찾아 어디서나 재활용 할수 있다는 장점이 있다. 반면에 다중 클래스 사용으로 유지보수의 어려움과 가독성이 떨어질수 있다.

---

### BEM(Block Element Modifier)

블록(block), 요소(element), 상태(modifier)로 구분하여 클래스 작성하며 엄격한 네이밍 규칙을 가진다.

**block : 재사용 가능한 영역(header, footer, navigation…), 하나의 단어를 사용하되 길어질 경우 (-)를 사용**

```
.header { ... }
.block { ... }
```

**element : 블록의 내부 구성을 표현, 두개의 underscores( _ )로 표기**

```
.header { ... }
.header__link { ... }
.header__tap { ... }
.header__tap__item { ... }
```

**modifier : 요소의 상태를 표현, 두개의 hyphen(-)로 표기**

```
.header--hide { ... }
.header__tap--big { ... }
.header__tap--big { ... }
```

코드를 직관적으로 파악할수 있지만 이름이 길고 복잡해 질수 있다.

---

### 공통점

세 방법론 모두 같은 지향점을 갖고 있었습니다.

- 코드의 재사용성을 높이자
- 쉽게 유지보수 하자
- 확장 가능하게 하자
- 클래스명 만으로도 무슨 의미인지 예측 가능하도록 하자



### 참고자료

- [CSS methodology(CSS 방법론)](https://velog.io/@kim-jaemin420/CSS-methodologyCSS-%EB%B0%A9%EB%B2%95%EB%A1%A0)
- [BEM, SMACSS, OOCSS (CSS방법론)](https://jinminkim-50502.medium.com/css-bem-smacss-oocss-9e4d6beb0a38)