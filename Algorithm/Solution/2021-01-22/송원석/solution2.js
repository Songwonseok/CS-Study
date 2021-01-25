function solution(arrA, arrB) {
  const startIndex = arrB.findIndex(el => el === arrA[0]);

  if (startIndex === -1)
    return false;

  const length = arrA.length;

  for (let i = 0; i < length; i++) {
    if (arrA[i] !== arrB[(startIndex + i) % length]) {
      return false;
    }
  }

  return true;
}