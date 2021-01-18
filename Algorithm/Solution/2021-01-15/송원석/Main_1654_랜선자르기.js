const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().split("\n");
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const Main = () => {
  const line = inputs[0].split(" ");
  const K = parseInt(line[0]);
  const N = parseInt(line[1]);
  const wireArray = [];

  let total = 0;

  for (let i = 1; i <= K; i++) {
    const wire = parseInt(inputs[i]);
    wireArray.push(wire);
    total += wire;
  }

  let min = 1;
  let max = Math.floor(total / N);
  let answer = 0;

  const binarySearch = (left, right) => {
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      const count = wireArray.reduce((acc, el) => acc += Math.floor(el / mid), 0);
      if (count >= N) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
  }

  binarySearch(min, max);

  console.log(answer);
}

Main();