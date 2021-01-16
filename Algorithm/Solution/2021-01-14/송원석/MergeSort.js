const merge = (array, left, mid, right) => {
  const leftArray = array.slice(left, mid + 1);
  const rightArray = array.slice(mid + 1, right + 1);
  let leftIndex = 0;
  let rightIndex = 0;
  for (let i = left; i <= right; i++) {
    if (leftIndex >= leftArray.length) {
      array[i] = rightArray[rightIndex++];
    } else if (rightIndex >= rightArray.length) {
      array[i] = leftArray[leftIndex++];
    } else if (leftArray[leftIndex] < rightArray[rightIndex]) {
      array[i] = leftArray[leftIndex++];
    } else {
      array[i] = rightArray[rightIndex++];
    }
  }
}


const mergeSort = (array, left, right) => {
  if (left < right) {
    const mid = Math.floor((left + right) / 2);
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
  }
}


// const array = [3, 2, 1, 6, 10, 21];
const array = [5, 3, 8, 4, 9, 1, 6, 2, 7]
mergeSort(array, 0, array.length - 1);

console.log(array);