function solution(matrix) {
  const set = new Set();
  const N = matrix.length;
  const medianIndex = Math.floor(N / 2);
  const colArray = new Array(N).fill(0)
    .map(el => new Array(N));
  let answer = 0;

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      colArray[j][i] = matrix[i][j];
    }
  }

  for (let i = 0; i < N; i++) {
    colArray[i].sort((a, b) => a - b);
    matrix[i].sort((a, b) => a - b);
    set.add(matrix[i][medianIndex]);
  }

  for (let i = 0; i < N; i++) {
    if (set.has(colArray[i][medianIndex])) {
      answer++;
    }
  }

  return answer;
}