const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const Main = () => {
  const numbers = inputs[1].split(" ").map(el => parseInt(el)).sort((a, b) => a - b);

  let total = 0
  numbers.reduce((acc, el) => {
    acc += el;
    total += acc;
    return acc;
  }, 0);

  console.log(total);
}

Main();