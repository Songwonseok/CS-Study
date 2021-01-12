## 합병 정렬 (Merge Sort)

## Goal

- Merge Sort에 대해 설명할 수 있다.
- Merge Sort 과정에 대해 설명할 수 있다.
- Merge Sort을 구현할 수 있다.
- Merge Sort의 시간복잡도와 공간복잡도를 계산할 수 있다.



## Abstract

- 대표적인 nlogn 정렬 알고리즘이다.

- 합병정렬은 항상 nlogn 의 성능을 내는 알고리즘으로 힙정렬과 같고 최악상황의 퀵(n^2) 보다 안정적이다.

- 하지만 평균적으로 퀵정렬보다 느린 성능을 보이며 알고리즘 구현에있어 힙정렬보다 메모리를 더 많이먹는다.

- 일반적인 방법으로 구현했을 때 이 정렬은 **안정 정렬** 에 속하며, 분할 정복 알고리즘의 하나이다.

  - 합병 정렬의 과정
    - 리스트의 길이가 0 또는 1이면 이미 정렬된 것으로 본다.
    - 그렇지 않은 경우, 정렬되지 않은 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
    - 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
    - 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.

- *퀵소트와의 차이점*

  - 퀵정렬 : 우선 피벗을 통해 정렬(partition) → 영역을 쪼갬(quickSort)

  - 합병정렬 : 영역을 쪼갤 수 있을 만큼 쪼갬(mergeSort) → 정렬(merge)

> 안전 정렬 : 동일한 값에 기존 순서가 유지 (버블, 삽입, 합병)
>
> 불안정 정렬 : 동일한 값에 기존 순서가 유지X (선택,퀵)



## Process (Ascending)

- 배열에 27, 10, 12, 20, 25, 13, 15, 22이 저장되어 있다고 가정하고 자료를 오름차순으로 정렬해 보자.

- 2개의 정렬된 리스트를 합병(merge)하는 과정

  1. 2개의 리스트의 값들을 처음부터 하나씩 비교하여 두 개의 리스트의 값 중에서 더 작은 값을 새로운 리스트(sorted)로 옮긴다.

  2. 둘 중에서 하나가 끝날 때까지 이 과정을 되풀이한다.
  3. 만약 둘 중에서 하나의 리스트가 먼저 끝나게 되면 나머지 리스트의 값들을 전부 새로운 리스트(sorted)로 복사한다.
  4. 새로운 리스트(sorted)를 원래의 리스트(list)로 옮긴다.

- ![mergesort-1](C:\Users\dnjst\OneDrive\바탕 화면\STUDY\CS\CS-Study\Algorithm\images\mergesort-1.PNG)



## Java Code (Ascending)

```java
public static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
 
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
}
 
public static void merge(int[] array, int left, int mid, int right) {
    int[] L = Arrays.copyOfRange(array, left, mid + 1);
    int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);
 
    int i = 0, j = 0, k = left;
    int ll = L.length, rl = R.length;
 
    while (i < ll && j < rl) {
        if (L[i] <= R[j]) {
            array[k] = L[i++];
        } else {
            array[k] = R[j++];
        }
        k++;
    }
 
    while (i < ll)
        array[k++] = L[i++];  
 
    while (j < rl)
        array[k++] = R[j++];    
}
```

1. 우선, 위치(index)를 **선택**해줍니다.
2. i+1번째 원소부터 선택한 위치(index)의 값과 비교를 시작합니다.
3. 오름차순이므로 현재 선택한 자리에 있는 값보다 순회하고 있는 값이 작다면, 위치(index)를 갱신해줍니다.
4. '2'번 반복문이 끝난 뒤에는 indexMin에 '1'번에서 선택한 위치(index)에 들어가야하는 값의 위치(index)를 갖고 있으므로 서로 교환(swap)해줍니다.



## GIF로 이해하는 Merge Sort

![mergesort](C:\Users\dnjst\OneDrive\바탕 화면\STUDY\CS\CS-Study\Algorithm\images\mergesort.GIF)

## 시간복잡도

- T(n) = nlog₂n(비교) + 2nlog₂n(이동) = 3nlog₂n = O(nlog₂n)
  



## 공간복잡도

- 두 개의 배열을 병합할 때 병합 결과를 담아 놓을 배열이 추가로 필요합니다. 따라서 공간 복잡도는 `O(N)` 입니다.



## 합병 정렬의 특징

### 장점

- 안정적인 정렬 방법
  - 데이터의 분포에 영향을 덜 받는다. 즉, 입력 데이터가 무엇이든 간에 정렬되는 시간은 동일하다. (O(nlog₂n)로 동일)
  - 만약 레코드를 **연결 리스트(Linked List)** 로 구성하면, 링크 인덱스만 변경되므로 데이터의 이동은 무시할 수 있을 정도로 작아진다.
    - 제자리 정렬(in-place sorting)로 구현할 수 있다.
  - 따라서 크기가 큰 레코드를 정렬할 경우에 연결 리스트를 사용한다면, 합병 정렬은 퀵 정렬을 포함한 다른 어떤 졍렬 방법보다 효율적이다.

### 단점

- 만약 레코드를 배열(Array)로 구성하면, 임시 배열이 필요하다.
  - 제자리 정렬(in-place sorting)이 아니다.
- 레코드들의 크기가 큰 경우에는 이동 횟수가 많으므로 매우 큰 시간적 낭비를 초래한다.

## Reference & Additional Resources

- https://gmlwjd9405.github.io/2018/05/08/algorithm-merge-sort.html

