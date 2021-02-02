const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().split("\n");
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

function main() {
  const [N, S] = inputs[0].split(" ").map(v => +v);
  const numbers = inputs[1].split(" ").map(v => +v);
  const MAX_NUMBER = 100001;
  let left = 0;
  let right = 0;
  let sum = numbers[0];

  let min = MAX_NUMBER;
  while (left <= right) {
    if (sum >= S) {
      min = Math.min(min, right - left + 1);
    }

    if (sum < S) {
      if (right + 1 === N)
        break;
      sum += numbers[++right];
    } else {
      sum -= numbers[left++];
    }
  }
  if (min === MAX_NUMBER) {
    console.log(0);
  } else {
    console.log(min);
  }
}

main();