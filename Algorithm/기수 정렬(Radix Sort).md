## 기수 정렬 (Radix Sort)

기수정렬은 낮은 자리수부터 비교하여 정렬해 간다는 것을 기본 개념으로 하는 정렬 알고리즘입니다.

기수정렬은 비교 연산을 하지 않으며 정렬 속도가 빠르지만 데이터 전체 크기에 기수 테이블의 크기만한 메모리가 더 필요합니다.



#### Comparison Sort(비교 정렬)

> N개 원소의 배열이 있을 때, 이를 모두 정렬하는 가짓수는 N!임
>
> 따라서, Comparison Sort를 통해 생기는 트리의 말단 노드가 N! 이상의 노드 갯수를 갖기 위해서는, 2^h >= N! 를 만족하는 h를 가져야 하고, 이 식을 h > O(nlgn)을 가져야 한다. (h는 트리의 높이,,, 즉 Comparison sort의 시간 복잡도임)

​	***이런 O(nlgn)을 줄일 수 있는 방법은 Comparison을 하지 않는 것!***





## 정렬방식 (오름차순)

1. 0~9 까지의 Bucket(Queue)을 준비한다.

2. 모든 데이터에 대하여 가장 낮은 자리수에 해당하는 Bucket에 차례대로 데이터를 둔다.

3. 0부터 차례대로 버킷에서 데이터를 다시 가져온다.

4. 가장 높은 자리수를 기준으로 하여 자리수를 높여가며 2번 3번 과정을 반복한다.

 

## Java 소스코드 (오름차순)

```java
void countSort(int arr[], int n, int exp) {
	int buffer[n];
    int i, count[10] = {0};
    
    // exp의 자릿수에 해당하는 count 증가
    for (i = 0; i < n; i++){
        count[(arr[i] / exp) % 10]++;
    }
    // 누적합 구하기
    for (i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }
    // 일반적인 Counting sort 과정
    for (i = n - 1; i >= 0; i--) {
        buffer[count[(arr[i]/exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }
    for (i = 0; i < n; i++){
        arr[i] = buffer[i];
    }
}

void radixsort(int arr[], int n) {
     // 최댓값 자리만큼 돌기
    int m = getMax(arr, n);
    
    // 최댓값을 나눴을 때, 0이 나오면 모든 숫자가 exp의 아래
    for (int exp = 1; m / exp > 0; exp *= 10) {
        countSort(arr, n, exp);
    }
}
int main() {
    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    int n = sizeof(arr) / sizeof(arr[0]);			// 좋은 습관
    radixsort(arr, n);
    
    for (int i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
    return 0;
}
```



## GIF로 이해하는 Radix Sort

![radixsort](C:\Users\dnjst\OneDrive\바탕 화면\STUDY\CS\CS-Study\Algorithm\image\radixsort.GIF)

## 시간복잡도

- 시간 복잡도 : O(d * (n + b))
  - d는 정렬할 숫자의 자릿수, b는 10 (k와 같으나 10으로 고정되어 있다.)
  - Counting Sort의 경우 : O(n + k) 로 배열의 최댓값 k에 영향을 받음



## 계수 정렬의 특징

- **정렬하는 숫자가 특정한 범위 내에 있을 때 사용**

  (Suffix Array 를 얻을 때, 시간복잡도 O(nlgn)으로 얻을 수 있음.)

  

### 장점

- 자리수를 비교해 정렬하기때문에 문자열도 정렬이 가능하다.
- O(dn)O(dn)의 빠른시간으로 정렬이 가능
- 안정 정렬 이다.

### 단점

- 자릿수가 없는 것은 정렬이 불가능 하다. (부동소수점)
- 추가적인 메모리 공간이 필요하다.



## 참고자료

- https://gyoogle.dev/blog/algorithm/Radix%20Sort.html
- https://herong.tistory.com/entry/%EA%B8%B0%EC%88%98%EC%A0%95%EB%A0%ACRidix-Sort?category=818669

