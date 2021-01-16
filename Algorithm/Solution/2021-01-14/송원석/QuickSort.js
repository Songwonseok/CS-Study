const swap = (array, a, b) => {
  const temp = array[a];
  array[a] = array[b];
  array[b] = temp;
}

const partition = (start, end, array) => {
  const pivot = array[start];

  let low = start + 1;
  let high = end;

  while (low <= high) {
    while (array[low] < pivot) low++;
    while (high >= low && array[high] > pivot) high--;

    if (low < high)
      swap(array, low, high);
  }

  swap(array, start, high)
  return high;
}

const quickSort = (start, end, array) => {
  if (start >= end) return;

  const pivot = partition(start, end, array);
  quickSort(start, pivot - 1, array);
  quickSort(pivot + 1, end, array);
}

// const array = [3, 2, 1, 6, 10, 21];
const array = [5, 3, 8, 4, 9, 1, 6, 2, 7]
quickSort(0, array.length - 1, array);

console.log(array);