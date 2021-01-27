const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split("\n");
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split('\r\n');
const DP = new Array(15).fill(0).map(v => new Array(15).fill(0));


function solution(k, n) {
  if (k === 0) {
    return n;
  } else if (n === 1) {
    return solution(k - 1, n);
  } else if (DP[k][n] > 0) {
    return DP[k][n]
  }
  DP[k][n] = solution(k, n - 1) + solution(k - 1, n);
  return DP[k][n];
}

function main() {
  const T = +inputs.shift();
  let answer = "";
  for (let i = 0; i < T; i++) {
    const k = +inputs.shift();
    const n = +inputs.shift();
    answer += solution(k, n) + "\n";
  }
  console.log(answer);
}

main();