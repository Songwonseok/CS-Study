# CSS 선택자 우선순위

웹사이트 제작하다보면 하나의 태그에 여러 가지의 CSS가 적용될 때가 있습니다. 이 때 특정한 규칙에 따라 CSS에 우선 순위가 부여되어 적용됩니다. 이 규칙을 CSS 우선 순위라고 합니다.

외울 규칙은 다음과 같습니다.

- 기본적으로 뒤에 나오는 css가 우선순위가 높습니다. 
- !important > inline style attribute > id > class, 다른 attribute, 수도클래스(:first-child같은 것) > tag element, 수도엘레먼트(::before같은 것) 순으로 우선순위가 높습니다.
- 우선순위가 같다면 개수가 많은 css가 우선순위가 높습니다.

!important와 inline style attribute은 실무에서 사용을 제한하는 경우가 많습니다. !important는 css 값 뒤에 붙여진 키워드를 의미하고, 인라인 스타일 속성은 태그에 주어진 style 속성 내용을 가리킵니다. 이 두 가지는 최후의 수단이라고 생각하시면 좋습니다. 따라서 나머지 id, class, tag만 살펴보도록 하겠습니다.



## 선택자 우선순위 계산 (specificity 계산)

더 특정적인 선택자가 더 일반적인 선택자보다 우선합니다. 가상 엘리먼트와 가장클래스들은 각각 일반적인 엘리먼트와 클래스와 같이 간주됩니다.

- a = 선택자중 ID의 수를 세어 100자리에 놓는다,
- b = 선택자중 가상 클래스와 클래스의 수를 세어 10자리에 놓는다.
- c = 선택자중 엘리먼트의 수를 세어 1의 자리에 놓는다.
- d = 가상 엘리먼트는 무시한다.

여섯 개의 선택자 그룹을 우선순위에 따라 내림차순으로 정리하면 다음과 같습니다.



|                | a (100자리) | b (10자리) | c (1자리) | 선택자 우선순위 계산 |
| :------------- | ----------- | ---------- | --------- | -------------------- |
| *{}            | 0           | 0          | 0         | 0                    |
| li{}           | 0           | 0          | 1         | 1                    |
| ul li{}        | 0           | 0          | 2         | 2                    |
| ul ol+li{}     | 0           | 0          | 3         | 3                    |
| li.num{}       | 0           | 1          | 1         | 11                   |
| ul+ol li.num{} | 0           | 1          | 3         | 13                   |
| li.num.last{}  | 0           | 2          | 1         | 21                   |
| #wrap{}        | 1           | 0          | 0         | 100                  |
| p#wrap{}       | 1           | 0          | 1         | 101                  |

예를들어 다음과 같은 경우를 살펴보면

```html
<style type="text/css">
p { color: gray;}
p.wrap { color: black;}
p#wrap { color: red;}
</style>
 
<p class="wrap" id="wrap">CSS Dictionary </p>
```

이 경우 위 세가지 스타일중 선택자 우선순위가 가장 높은 p#wrap 가 적용됩니다.
(p=1 , p.wrap=11 , p#wrap=101)

다음과 같은 경우는 어떨까요?

```html
<style type="text/css">
#wrap { color:black;}
</style>
 
<p id="wrap" style="color:red;"> CSS Dictionary </p>
```



이 경우에는 #wrap와 style속성이 100으로 같은 선택자 우선순위에 놓이게 됩니다. 이럴때는 가장 마지막에 지정된 스타일이 적용되므로 텍스트가 빨간색으로 출력됩니다.

 

## 가장 마지막에 지정된 스타일 우선 적용

만약 충돌하는 두 스타일들이 같은 원천 소스를 가지거나 선택자 우선순위가 같다면 가장 마지막에 지정된 스타일이 우선 적용됩니다.

예를 들어 다음과 같은 경우라면...

```html
<head>
<style type "text/css">
p.test {
    color: black;
}
</style>
</head>
 
<body>
    <p class="test" style="color: red;"> 경고문 </p>
</body>
```

이 경우 "경고문"이라는 텍스트는 가장 마지막에 지정된 스타일이 적용되어 빨간색으로 출력됩니다.

다음의 경우도 마찬가지로 빨간색의 "알림"이라는 텍스트가 출력됩니다.

 ```html
<head>
<style type "text/css">
.wrap {
    color: black;
}
.notice{
    color: red;
}
</style>
</head>
 
<body>
    <p class="wrap notice"> 알림</p>
</body>
 ```





#### 출처

- [오픈튜토리얼스](https://opentutorials.org/module/484/4149)