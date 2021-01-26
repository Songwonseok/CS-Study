const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split('\r\n');

const Main = () => {
  const N = +inputs.shift();
  let bit = 0;
  let answer = "";
  for (let i = 0; i < N; i++) {
    const [command, num] = inputs[i].split(" ");
    switch (command) {
      case 'add':
        bit |= 1 << num;
        break;
      case 'remove':
        bit &= ~(1 << num);
        break;
      case 'check':
        if (bit & (1 << num)) {
          answer += `1\n`
        } else {
          answer += `0\n`
        }
        break;
      case 'toggle':
        bit ^= (1 << num);
        break;
      case 'all':
        bit = (1 << 21) - 1;
        break;
      case 'empty':
        bit = 0
    }
  }
  console.log(answer);
}

Main();