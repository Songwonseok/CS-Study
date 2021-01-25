function solution(N, trees) {
  trees.sort((a, b) => a[1] - b[1]);
  let answer = 1
  let prevX = trees[0][0];

  for (let i = 1; i < trees.length; i++) {
    if (trees[i][0] < prevX) {
      answer++;
      prevX = trees[i][0];
    }
  }

  return answer;
}