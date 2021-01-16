const binarySearch = (times, n) => {
  let left = 0;
  let right = times[times.length - 1] * n;
  let mid = Math.floor((left + right) / 2);
  let min = right;

  while (left <= right) {
    const count = times.reduce((acc, el) => acc += Math.floor(mid / el), 0);

    if (count >= n) {
      min = Math.min(min, mid);
      right = mid - 1;
    } else {
      left = mid + 1;
    }
    mid = Math.floor((left + right) / 2);
  }
  return min;
}

function solution(n, times) {
  times.sort((a, b) => a - b);
  return binarySearch(times, n);
}


// 1. 돈 10원 옷 종류 4, 옷 가격 []
// 
// 2. longest string chain : A B BA BCA BDA BDCA
// 문자열 체인 AB -> A, AB -> B
// 3. html
// 4. 캐러셀 (이미지 넘기기)
// 5. 

