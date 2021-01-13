## [자료구조] 힙(Heap)

<br>

##### 알아야할 것

> 1.힙의 개념
>
> 2.힙의 삽입 및 삭제

<br>

힙은, 우선순위 큐를 위해 만들어진 자료구조다.

먼저 **우선순위 큐**에 대해서 간략히 알아보자 

<br>

**우선순위 큐** : 우선순위의 개념을 큐에 도입한 자료구조

> 데이터들이 우선순위를 가지고 있음. 우선순위가 높은 데이터가 먼저 나감

스택은 LIFO, 큐는 FIFO

<br>

##### 우선순위 큐의 활용 예시

> 시뮬레이션 시스템, 우선 순위가 존재하는 작업 스케줄링, 수치해석 계산

우선순위 큐는 배열, 연결리스트, 힙으로 구현 (힙으로 구현이 가장 효율적!)

힙 → 삽입 : O(logn) , 삭제 : O(logn)

<br>

<br>

### 힙(Heap)

---

완전 이진 트리의 일종

> 여러 값 중, 최대값과 최소값을 빠르게 찾아내도록 만들어진 자료구조

반정렬 상태

힙 트리는 중복된 값 허용 (이진 탐색 트리는 중복값 허용X)

<br>

#### 힙 종류

###### 최대 힙(max heap)

  부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리

###### 최소 힙(min heap)

  부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리

 <img src="https://t1.daumcdn.net/cfile/tistory/17084F504DA9895214">

<br>

#### 구현

---

![heap-1](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DataStructure/images/heap-1.PNG)

힙을 저장하는 표준적인 자료구조는 `배열`

구현을 쉽게 하기 위해 배열의 첫번째 인덱스인 0은 사용되지 않음

특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않음

(ex. 루트 노드(1)의 오른쪽 노드 번호는 항상 3)

 <br>

##### 부모 노드와 자식 노드 관계

```
왼쪽 자식 index = (부모 index) * 2

오른쪽 자식 index = (부모 index) * 2 + 1

부모 index = (자식 index) / 2
```

<br>

#### 힙의 삽입

1.힙에 새로운 요소가 들어오면, 일단 새로운 노드를 힙의 마지막 노드에 삽입

2.새로운 노드를 부모 노드들과 교환

![heap-2](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DataStructure/images/heap-2.PNG)

<br>

###### 최대 힙 삽입 구현

```java
void insert_max_heap(int x) {
    
    maxHeap[++heapSize] = x; 
    // 힙 크기를 하나 증가하고, 마지막 노드에 x를 넣음
    
    for( int i = heapSize; i > 1; i /= 2) {
        
        // 마지막 노드가 자신의 부모 노드보다 크면 swap
        if(maxHeap[i/2] < maxHeap[i]) {
            swap(i/2, i);
        } else {
            break;
        }
        
    }
}
```

부모 노드는 자신의 인덱스의 /2 이므로, 비교하고 자신이 더 크면 swap하는 방식

<br>

#### 힙의 삭제

1.최대 힙에서 최대값은 루트 노드이므로 루트 노드가 삭제됨
(최대 힙에서 삭제 연산은 최대값 요소를 삭제하는 것)

2.삭제된 루트 노드에는 힙의 마지막 노드를 가져옴

3.힙을 재구성

![heap-3](https://raw.githubusercontent.com/Songwonseok/CS-Study/main/DataStructure/images/heap-3.PNG)

<br>

###### 최대 힙 삭제 구현

```java
int delete_max_heap() {
    
    if(heapSize == 0) // 배열이 비어있으면 리턴
        return 0;
    
    int item = maxHeap[1]; // 루트 노드의 값을 저장
    maxHeap[1] = maxHeap[heapSize]; // 마지막 노드 값을 루트로 이동
    maxHeap[heapSize--] = 0; // 힙 크기를 하나 줄이고 마지막 노드 0 초기화
    
    for(int i = 1; i*2 <= heapSize;) {
        
        // 마지막 노드가 왼쪽 노드와 오른쪽 노드보다 크면 끝
        if(maxHeap[i] > maxHeap[i*2] && maxHeap[i] > maxHeap[i*2+1]) {
            break;
        }
        
        // 왼쪽 노드가 더 큰 경우, swap
        else if (maxHeap[i*2] > maxHeap[i*2+1]) {
            swap(i, i*2);
            i = i*2;
        }
        
        // 오른쪽 노드가 더 큰 경우
        else {
            swap(i, i*2+1);
            i = i*2+1;
        }
    }
    
    return item;
    
}
```

<br>

<br>

**[참고 자료]** [링크](<https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html>)