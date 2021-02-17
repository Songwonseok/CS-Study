## 이분 탐색(Binary Search)

> 탐색 범위를 두 부분으로 분할하면서 찾는 방식

처음부터 끝까지 돌면서 탐색하는 것보다 훨~~~씬 빠른 장점을 지님

```
* 시간복잡도
전체 탐색 : O(N)
이분 탐색 : O(logN)
```

![binarysearch](https://github.com/Songwonseok/CS-Study/blob/main/Algorithm/image/binarysearch.GIF?raw=true)





#### 진행 순서

- 배열을 정렬시킴
- first와 last로 mid 값 설정
- mid와 내가 구하고자 하는 값과 비교
- 구할 값이 mid보다 높으면 : first = mid+1 구할 값이 mid보다 낮으면 : last = mid - 1
- first > last가 될 때까지 계속 반복하기



#### Code

```java
public static int binarySearch(int[] A, int n) {
	int first = 0;
	int last = A.length - 1;
	int mid = 0;

	while (first <= last) {
		mid = (first + last) / 2;

		if (n == A[mid])
			return 1;
		else {
			if (n < A[mid])
				last = mid - 1;
			else
				first = mid + 1;
		}
	}
	return 0;
}
```