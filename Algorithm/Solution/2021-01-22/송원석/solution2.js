function equals(arrA, arrB) {
  for (let i = 0; i < arrA.length; i++) {
    if (arrA[i] !== arrB[i]) {
      return false;
    }
  }
  return true;
}

function solution(arrA, arrB) {
  if (arrA.length !== arrB.length) {
    return false;
  }

  if (equals(arrA, arrB))
    return true;

  for (let i = 0; i < arrA.length - 1; i++) {
    arrB.push(arrB.shift());
    if (equals(arrA, arrB)) {
      return true;
    }
  }
  return false;
}