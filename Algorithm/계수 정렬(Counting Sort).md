## 계수 정렬 (Counting Sort)

Counting Sort는 **숫자들간 비교를 하지 않고 정렬**을 하는 알고리즘이다. 각 숫자가 몇개 있는지 개수를 세어 저장한 후에 정렬하는 방식이다.



#### Comparison Sort(비교 정렬)

> N개 원소의 배열이 있을 때, 이를 모두 정렬하는 가짓수는 N!임
>
> 따라서, Comparison Sort를 통해 생기는 트리의 말단 노드가 N! 이상의 노드 갯수를 갖기 위해서는, 2^h >= N! 를 만족하는 h를 가져야 하고, 이 식을 h > O(nlgn)을 가져야 한다. (h는 트리의 높이,,, 즉 Comparison sort의 시간 복잡도임)

​	***이런 O(nlgn)을 줄일 수 있는 방법은 Comparison을 하지 않는 것!***





## 정렬방식 (오름차순)

1. 정렬하고자 하는 배열의 최대값을 구한다.
2. 최대값 크기의 배열에 각 원소를 순회하며 해당 값이 몇개인지 저장한다.
3. 저장된 데이터를 순서대로 출력한다.



## Java 소스코드 (오름차순)

```java
int arr[5]; 		// [5, 4, 3, 2, 1]
int sorted_arr[5];

// 과정 1 - counting 배열의 사이즈를 최대값 5가 담기도록 크게 잡기
int counting[6];	
// 단점 : counting 배열의 사이즈의 범위를 가능한 값의 범위만큼 크게 잡아야 하므로, 비효율적이 됨.

// 과정 2 - counting 배열의 값을 증가해주기.
for (int i = 0; i < arr.length; i++) {
    counting[arr[i]]++;
}

// 과정 3 - counting 배열을 누적합으로 만들어주기.
for (int i = 1; i < arr.length; i++) {
    counting[i] += counting[i - 1];
}

// 과정 4 - 뒤에서부터 배열을 돌면서, 해당하는 값의 인덱스에 값을 넣어주기.
for (int i = arr.length - 1; i >= 0; i--) {
    sorted_arr[counting[arr[i]]] = arr[i];
    counting[arr[i]]--;
}

```



## GIF로 이해하는 Counting Sort

![countingsort](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/countingsort.GIF?raw=true)

## 시간복잡도

- O(n + k) 

> k는 배열에서 등장하는 최대값



## 공간복잡도

- k만큼 크기의 배열을 만들어야 하기 때문에 O(k)



## 계수 정렬의 특징

- **정렬하는 숫자가 특정한 범위 내에 있을 때 사용**

  (Suffix Array 를 얻을 때, 시간복잡도 O(nlgn)으로 얻을 수 있음.)

  

### 장점

- O(n) 의 시간복잡도로 빠르다

### 단점

- 배열 사이즈 N 만큼 돌 때, 증가시켜주는 Counting 배열의 크기가 큼 (메모리 낭비가 심함)



## 참고자료

- https://gyoogle.dev/blog/algorithm/Counting%20Sort.html
- https://herong.tistory.com/entry/%EA%B3%84%EC%88%98%EC%A0%95%EB%A0%ACCounting-Sort?category=818669

