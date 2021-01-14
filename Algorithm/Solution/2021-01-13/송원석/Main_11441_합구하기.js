const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const Main = () => {
  const N = parseInt(inputs[0]);
  const arr = new Array(N + 1);
  arr[0] = 0;

  inputs[1].split(" ").forEach((el, idx) => {
    arr[idx + 1] = arr[idx] + parseInt(el);
  })
  const answer = [];
  const M = inputs[2];
  for (let i = 0; i < M; i++) {
    const range = inputs[3 + i].split(" ");
    answer.push(arr[range[1]] - arr[range[0] - 1])
  }

  console.log(answer.join("\n"));
}

Main();