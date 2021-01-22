## 힙 정렬 (Heap Sort)

최대 힙 트리나 최소 힙 트리를 구성해 정렬을 하는 방법

내림차순 정렬을 위해서는 최대 힙을 구성하고 오름차순 정렬을 위해서는 최소 힙을 구성하면 된다.

- 힙 정렬 과정
  - 정렬해야 할 n개의 요소들로 최대 힙(완전 이진 트리 형태)을 만든다.
  - 내림차순을 기준으로 정렬
  - 그 다음으로 한 번에 하나씩 요소를 힙에서 꺼내서 배열의 뒤부터 저장하면 된다.
  - 삭제되는 요소들(최댓값부터 삭제)은 값이 감소되는 순서로 정렬되게 된다.



### 자료구조 ‘힙(heap)’

- 완전 이진 트리의 일종으로 우선순위 큐를 위하여 만들어진 자료구조
- 최댓값, 최솟값을 쉽게 추출할 수 있는 자료구조
  ![heapsort-1](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/heapsort-1.PNG?raw=true)





## 정렬방식 (내림차순 - 최대 힙)

- 힙(heap)은 1차원 배열로 쉽게 구현될 수 있다.
- 정렬해야 할 n개의 요소들을 1차원 배열에 기억한 후 최대 힙 삽입을 통해 차례대로 삽입한다.
- 최대 힙으로 구성된 배열에서 최댓값부터 삭제한다.



1. **최대 힙(max heap)의 삽입**

  1. 힙에 새로운 요소가 들어오면, 일단 새로운 노드를 힙의 마지막 노드에 이어서 삽입한다.
  2. 새로운 노드를 부모 노드들과 교환해서 힙의 성질을 만족시킨다.
  3. 아래의 최대 힙(max heap)에 새로운 요소 8을 삽입해보자.

  ![heapsort-2](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/heapsort-2.PNG?raw=true)



2. **최대 힙(max heap)의 삭제**

  1. 최대 힙에서 최댓값은 루트 노드이므로 루트 노드가 삭제된다.
  2. 최대 힙(max heap)에서 삭제 연산은 최댓값을 가진 요소를 삭제하는 것이다.
  3. 삭제된 루트 노드에는 힙의 마지막 노드를 가져온다.
  4. 힙을 재구성한다.

  ![heapsort-3](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/heapsort-3.PNG?raw=true)



## Java 소스코드 (최대 힙)

```java
private void solve() {
    int[] array = { 230, 10, 60, 550, 40, 220, 20 };
 
    heapSort(array);
 
    for (int v : array) {
        System.out.println(v);
    }
}
 
public static void heapify(int array[], int n, int i) {
    int p = i;
    int l = i * 2 + 1;
    int r = i * 2 + 2;
 
    if (l < n && array[p] < array[l]) {
        p = l;
    }
 
    if (r < n && array[p] < array[r]) {
        p = r;
    }
 
    if (i != p) {
        swap(array, p, i);
        heapify(array, n, p);
    }
}
 
public static void heapSort(int[] array) {
    int n = array.length;
 
    // init, max heap
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(array, n, i);
    }
 
    // for extract max element from heap
    for (int i = n - 1; i > 0; i--) {
        swap(array, 0, i);
        heapify(array, i, 0);
    }
}
 
public static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}
```



## GIF로 이해하는 Heap Sort

![heapsort](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/heapsort.GIF?raw=true)



## 시간복잡도

- 시간복잡도를 계산한다면
- 힙 트리의 전체 높이가 거의 log₂n(완전 이진 트리이므로)이므로 하나의 요소를 힙에 삽입하거나 삭제할 때 힙을 재정비하는 시간이 log₂n만큼 소요된다.
- 요소의 개수가 n개 이므로 전체적으로 O(nlog₂n)의 시간이 걸린다.
- T(n) = O(nlog₂n)



## 힙 소트가 유용할 때

- 가장 크거나 가장 작은 값을 구할 때

  > 최소 힙 or 최대 힙의 루트 값이기 때문에 한번의 힙 구성을 통해 구하는 것이 가능

- 최대 k 만큼 떨어진 요소들을 정렬할 때

  > 삽입정렬보다 더욱 개선된 결과를 얻어낼 수 있음



## 참고자료

- https://gmlwjd9405.github.io/2018/05/10/algorithm-heap-sort.html
- https://github.com/gyoogle/tech-interview-for-developer/blob/master/Algorithm/HeapSort.md
- https://herong.tistory.com/entry/%ED%9E%99-%EC%A0%95%EB%A0%ACHeap-Sort?category=818669

