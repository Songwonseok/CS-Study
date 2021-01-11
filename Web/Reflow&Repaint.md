# Reflow or Repaint(or ReDraw) 과정 및 최적화

리플로우와 리페인팅에 대해 알아봅니다.



## Reflow 발생

생성된 DOM 노드의 레이아웃 수치(너비, 높이, 위치 등) 변경 시 영향 받은 모든 노드의(자신, 자식, 부모, 조상(결국 모든 노드) ) 수치를 다시 계산하여(Recalculate), 렌더 트리를 재생성하는 과정이며 또한, `Reflow` 과정이 끝난 후 재 생성된 렌더 트리를 다시 그리게 되는데 이 과정을 `Repaint` 라 합니다.



#### Reflow 발생 코드

```javascript
function reFlow() {
    document.getElementById('container').style.width = '600px';
    return false;
}
```



#### Reflow 발생 그래프

![img](https://t1.daumcdn.net/cfile/tistory/256A384356ECCDFB3E)



#### 그래프 단계별 설명

1. Click 이벤트 handler 
2. Recalcurate(변경된 스타일 수치 계산 수행) 
3. Layout(Reflow 과정 수행) 
4. Paint(Repaint 과정 수행)





## Repaint 발생

Reflow 발생 이유와 같이 스타일의 모든 변경이 레이아웃 수치에 영향을 받는것은 아닙니다. 

즉, 아래 그래프 처럼 노드의 background-color, visibillty, outline 등의 스타일 변경 시에는 레이아웃 수치가 변경되지 않으므로 Reflow 과정이 생략된 Repaint 과정만 일어나게 됩니다.



#### Repaint 발생 코드

```javascript
function rePaint() {
    document.getElementById('container').style.backgroundColor = 'red';
    return false;
}
```



#### Repaint 발생 그래프

![img](https://t1.daumcdn.net/cfile/tistory/21299F4256ECCF2C36)



#### 그래프 단계별 설명

1. Click 이벤트 handler 
2. Recalcurate(변경된 스타일 수치 계산 수행) 
3. Paint(Repaint 과정 수행)



## Reflow 과정이 일어나는 상황

- 노드의 추가 또는 제거시. 
- 요소의 위치 변경 시. 
- 요소의 크기 변경 시.(margin, padding, border, width, height, 등..) 
- 폰트 변경 과(텍스트 내용) 이미지 크기 변경 시.(크기가 다른 이미지로 변경 시) 
- 페이지 초기 랜더링 시.(최초 Layout 과정) 
- 윈도우 리사이징 시.



## Reflow 최적화 방법

#### **1) 클래스 변화에 따른 스타일 변경 시, 최대한 DOM 구조 상 끝단에 위치한 노드에 주어야 합니다.** 

- 가급적 말단에 위치한 노드 수치 변경 시 리플로우 수행 반경을 전체 노드가 아닌 일부 노드로 제한 시킬 수 있습니다. 

- 즉, Reflow 수행 비용을 줄일 수 있다는 말과 같습니다.(하지만 실무 작업 시 적용 가능한 범위가 크지 않다) 



#### **2) 인라인 스타일을 최대한 배제하라.** 

- 적용 시 코드 가독성과 Reflow 비용을 줄일 수 있습니다. 



#### **3) 애니메이션이 들어간 노드는 가급적 position:fixed 또는 position:absolute로 지정하여 전체 노드에서 분리 시키도록 합니다.** 

- 보통 (JS(Javascript) + CSS)를 활용한 에니메이션 효과는 해당 프레임에 따라 무수히 많은 Reflow 비용이 발생하게 됩니다. 

- 하지만 position 속성을 "fixed" 또는 "absoute"로 값을 주면 지정된 노드는 전체 노드에서 분리됩니다. 

- 즉, 전체 노드에 걸쳐 Reflow 비용이 들지 않으며, 해당 노드의 Repaint 비용만 들어가게 됩니다. 

- 또한, 노드의 position 값을 초기에 적용하지 않았더라도 에니메이션 시작 시 값을 변경(fixed, absolute)하고 종료 시 다시 원복 시키는 방법을 사용해도 무관합니다.



##### 테스트 코드

```html
<script>
function animation() {
    document.getElementById('container_animation').style.left = '100px';
    document.getElementById('container_animation').style.top = '100px';
    return false;
}
</script> 

<div id="container_animation" style="background:blue;position:absolute;top:0px;left:0px;width:100px;height:100px;border:red 1px solid;"></div>
```



##### 테스트 결과

![img](https://t1.daumcdn.net/cfile/tistory/24152B3C56ECD1872F)



#### 4) 퀄리티와 퍼포먼스 사이에서 타협하라.

- 애니메이션 효과는 보통 무수히 많은 Reflow 비용이 들어가게 됩니다. 

- 물론, 디바이스 환경에 따라 큰 성능 차이를 보일 수 있겠지만, 스마트폰 기기와 같은 경우 그리 좋은 성능을 보이지 못합니다. 

- 따라서 에니메이션 효과와 같은 CPU 퍼포먼스 비용이 큰 작업은 언제나 퀼리티와 퍼포먼스 사이에 적당한 타협이 필요합니다.



#### 5) 테이블 레이아웃을 피하라.

- 테이블로 구성된 페이지 레이아웃은 점진적(progressive) 페이지 렌더링이 적용되지 않으며, 모두 로드되고 계산(Recalculate)된 후에야 화면에 뿌려지게 됩니다. 

- 하지만 해당 테이블에 table-layout:fixed 속성을 주는 것이 디폴트값인 auto에 비해 성능면에서 더 좋다고 한다. 



#### 6) IE의 경우, CSS에서의 JS표현식을 피하라.

- 이미 오래된 규칙이지만 매우 효과적인 규칙입니다. 

- CSS 표현식(expression)의 비용이 매우 높은 이유는, 문서 전체 또는 문서 중 일부가 Reflow될 때마다 표현식이 다시 계산되기 때문입니다. 

- 결국 애니메이션과 같은 변화에 의해 리플로우가 발생했을 때, 경우에 따라 초당 수천, 수만번의 표현식 계산이 진행될 수 있다는 것을 의미합니다.

##### CSS expression 적용 코드

```css
.expression { 
    width: expression(document.documentElement.clientWidth > 0 ? '1000px' : 'auto'); 
} 
```



#### 7) CSS 하위선택자는 필요한 만큼만 정리하라



#### 8) position:relative 사용 시 주의하자.



#### 9) cssText 및 클래스를 활용해 Reflow or Repaint 최소화하라.

- DOM과 스타일 변경을 하나로 묶어 리플로우 수행을 최소화 한다.



##### 해당 노드의 style 객체를 여러번 호출해 적용된 코드

```javascript
function collect() {
    var elem = document.getElementById('container');
   
    elem.style.backgroundColor = 'red';
    elem.style.width = '200px';
    elem.style.height = '200px';
 
    return false;
}
```

##### style 객체 속성인 cssText를 통해 한번에 적용된 코드

```javascript
function collect() {
    var elem = document.getElementById('container');
   
    elem.style.cssText = 'background:red;width:200px;height:200px;';
 
    return false;
}
```

##### CSS에 정의된 class를 통해 한번에 적용된 코드

```javascript
function collect() {
    var elem = document.getElementById('container');
 
    elem.className = 'collect';
 
    return false;
}
```



##### 테스트 결과

![img](https://t1.daumcdn.net/cfile/tistory/235EC34056ECD3CC17)



##### 상황별 Reflow 비용에 드는 시간

> 첫 번째 상황: 112ms 
>
> 두 번째 상황: 104ms 
>
> 세 번째 상황: 104ms





#### 10) 캐쉬를 활용한 Reflow 최소화하라.
- 브라우저는 레이아웃 변경을 큐에 저장했다가 한번에 실행하는 방법으로 Reflow 수를 줄입니다. 

- 하지만 offset, scrollTop, scrollLeft, 값과 같은 계산된 스타일 정보를 요청할 때마다 정확한 정보를 제공하기 위해 큐를 비우고 모든 변경을 다시 적용합니다. 

- 즉, 중복되는 수치에 대한 스타일 정보를 변수에 저장(캐쉬)해 요청수를 줄임으로써 Reflow 비용을 최소화시킵니다.

```javascript
function collect() {
    var elem = document.getElementById('container');
 
    var cw = elem.style.width;
 
    return parseInt(cw, 10) * parseInt(cw + document.documentElement.clientWidth, 10);
 
    return false;
}
```

- 비록, 실무에서 사용되는 코드는 아니지만, 해당 규칙만 이해하면 좋을 것입니다.



#### 11) DOM 사용을 최소화하여 Reflow 비용 줄이기.

- 아래 포스트와 같이 여러 가지 방법을 활용하여 Reflow 비용을 줄일 수 있습니다.



### 참고 관련 링크

1. [DOM 사용 최소화 하기](http://mohwaproject.tistory.com/entry/DOM-사용-최소화-하기)
2. [Reflow 원인과 마크업 최적화](http://lists.w3.org/Archives/Public/public-html-ig-ko/2011Sep/att-0031/Reflow_____________________________Tip.pdf)



#### 출처

- [Web Club](https://webclub.tistory.com/346)

