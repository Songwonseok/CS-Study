const fs = require('fs');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split("\r\n");
// const inputs = fs.readFileSync('./dev/stdin').toString().split("\n");


function main() {
  const [N, Q] = inputs.shift().split(" ");
  const sheets = [...inputs.slice(0, N)].map(el => Number(el));
  const questions = [...inputs.slice(N)].map(el => Number(el));
  const times = [0];
  for (let i = 0; i < sheets.length; i++) {
    times.push(times[i] + sheets[i])
  }
  let answer = '';
  for (let i = 0; i < questions.length; i++) {
    for (let idx = 1; idx < times.length; idx++) {
      if (questions[i] < times[idx]) {
        answer += (idx + '\n')
        break;
      }
    }
  }


  console.log(answer);
}

main();
