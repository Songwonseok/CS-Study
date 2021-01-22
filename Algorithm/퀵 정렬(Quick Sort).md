## 퀵 정렬 (Quick Sort)

퀵정렬은 real-world 데이터에서 빠르다고 알려져 있어 가장 많이 쓰는 정렬알고리즘이다.

퀵정렬은 pivot을 선정하여 pivot을 기준으로 좌측과 우측으로 pivot보다 작은값은 왼쪽 pivot보다 큰값은 오른쪽으로 재배치를 하고 계속하여 분할하여 정렬하는 알고리즘이다.

최악의 경우에는 O(n²)의 비교를 수행하지만 일반적으로 O(nlogn)의 시간복잡도를 가진다.

> 안전 정렬 : 동일한 값에 기존 순서가 유지 (버블, 삽입)
>
> 불안정 정렬 : 동일한 값에 기존 순서가 유지X (선택,퀵)



## 정렬방식 (오름차순)

- 배열에 5, 3, 8, 4, 9, 1, 6, 2, 7이 저장되어 있다고 가정하고 자료를 오름차순으로 정렬해 보자.

- 퀵 정렬에서 피벗을 기준으로 두 개의 리스트로 나누는 과정(c언어 코드의 partition 함수의 내용)
- ![quicksort-1](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/quicksort-1.PNG?raw=true)

- 피벗 값을 입력 리스트의 첫 번째 데이터로 하자. (다른 임의의 값이어도 상관없다.)

- 2개의 인덱스 변수(low, high)를 이용해서 리스트를 두 개의 부분 리스트로 나눈다.

- 1회전: 피벗이 5인 경우,
  1. low는 왼쪽에서 오른쪽으로 탐색해가다가 피벗보다 큰 데이터(8)을 찾으면 멈춘다.
  2. high는 오른쪽에서 왼쪽으로 탐색해가다가 피벗보다 작은 데이터(2)를 찾으면 멈춘다.
  3. low와 high가 가리키는 두 데이터를 서로 교환한다.
  4. 이 탐색-교환 과정은 low와 high가 엇갈릴 때까지 반복한다.

- 2회전: 피벗(1회전의 왼쪽 부분리스트의 첫 번째 데이터)이 1인 경우,
  - 위와 동일한 방법으로 반복한다.

- 3회전: 피벗(1회전의 오른쪽 부분리스트의 첫 번째 데이터)이 9인 경우,
  - 위와 동일한 방법으로 반복한다.



## Java 소스코드 (오름차순)

```java
public static int partition(int[] array, int left, int right) {
    int mid = (left + right) / 2;
    swap(array, left, mid);
 
    int pivot = array[left];
    int i = left, j = right;
 
    while (i < j) {
        while (pivot < array[j]) {
            j--;
        }
 
        while (i < j && pivot >= array[i]) {
            i++;
        }
        swap(array, i, j);
    }
    array[left] = array[i];
    array[i] = pivot;
    return i;
}
 
public static void swap(int[] array, int a, int b) {
    int temp = array[b];
    array[b] = array[a];
    array[a] = temp;
}
 
public static void quicksort(int[] array, int left, int right) {
    if (left >= right) {
        return;
    }
 
    int pi = partition(array, left, right);
 
    quicksort(array, left, pi - 1);
    quicksort(array, pi + 1, right);
}

```

1. 우선, 위치(index)를 **선택**해줍니다.
2. i+1번째 원소부터 선택한 위치(index)의 값과 비교를 시작합니다.
3. 오름차순이므로 현재 선택한 자리에 있는 값보다 순회하고 있는 값이 작다면, 위치(index)를 갱신해줍니다.
4. '2'번 반복문이 끝난 뒤에는 indexMin에 '1'번에서 선택한 위치(index)에 들어가야하는 값의 위치(index)를 갖고 있으므로 서로 교환(swap)해줍니다.



## GIF로 이해하는 Quick Sort

![quicksort](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/quicksort.GIF?raw=true)



## 시간복잡도

### 최선의 경우

- 비교 횟수

  ![quicksort-2](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/quicksort-2.PNG?raw=true)

- 순환 호출의 깊이

  - 레코드의 개수 n이 2의 거듭제곱이라고 가정(n=2^k)했을 때, 

    n=2^3의 경우, 2^3 -> 2^2 -> 2^1 -> 2^0 순으로 줄어들어 순환 호출의 깊이가 3임을 알 수 있다. 이것을 일반화하면 n=2^k의 경우, k(k=log₂n)임을 알 수 있다.

  - k=log₂n

- 각 순환 호출 단계의 비교 연산

  - 각 순환 호출에서는 전체 리스트의 대부분의 레코드를 비교해야 하므로 평균 n번 정도의 비교가 이루어진다.
  - 평균 n번

- 순환 호출의 깊이 * 각 순환 호출 단계의 비교 연산 = nlog₂n

- 이동 횟수

  - 비교 횟수보다 적으므로 무시할 수 있다.

- **최선의 경우 T(n) = nlog₂n**

### 최악의 경우

- 리스트가 계속 불균형하게 나누어지는 경우 (특히, 이미 정렬된 리스트에 대하여 퀵 정렬을 실행하는 경우)

  ![quicksort-3](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/quicksort-3.PNG?raw=true)

- 비교 횟수
  - 순환 호출의 깊이
    - 레코드의 개수 n이 2의 거듭제곱이라고 가정(n=2^k)했을 때, 순환 호출의 깊이는 n임을 알 수 있다.
    - n
  - 각 순환 호출 단계의 비교 연산
    - 각 순환 호출에서는 전체 리스트의 대부분의 레코드를 비교해야 하므로 평균 n번 정도의 비교가 이루어진다.
    - 평균 n번
  - 순환 호출의 깊이 * 각 순환 호출 단계의 비교 연산 = n^2
- 이동 횟수
  
  - 비교 횟수보다 적으므로 무시할 수 있다.
- **최악의 경우 T(n) = n^2**

### 평균

- **평균 T(n) = nlog₂n**
- 시간 복잡도가 nlog₂n를 가지는 다른 정렬 알고리즘과 비교했을 때도 가장 빠르다.
- 퀵 정렬이 불필요한 데이터의 이동을 줄이고 먼 거리의 데이터를 교환할 뿐만 아니라, 한 번 결정된 피벗들이 추후 연산에서 제외되는 특성 때문이다



## 공간복잡도

주어진 배열 안에서 교환(swap)을 통해, 정렬이 수행되므로 **O(n)** 입니다.



## 장점

- 속도가 빠르다.
  - 시간 복잡도가 O(nlog₂n)를 가지는 다른 정렬 알고리즘과 비교했을 때도 가장 빠르다.
- 추가 메모리 공간을 필요로 하지 않는다.
  - 퀵 정렬은 O(log n)만큼의 메모리를 필요로 한다.

## 단점

- 정렬된 리스트에 대해서는 퀵 정렬의 불균형 분할에 의해 오히려 수행시간이 더 많이 걸린다.
- 퀵 정렬의 불균형 분할을 방지하기 위하여 피벗을 선택할 때 더욱 리스트를 균등하게 분할할 수 있는 데이터를 선택해야 한다.
- **불안정 정렬(Unstable Sort)** 입니다.



## 참고자료

- https://ko.wikipedia.org/wiki/%ED%80%B5_%EC%A0%95%EB%A0%AC
- https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html

