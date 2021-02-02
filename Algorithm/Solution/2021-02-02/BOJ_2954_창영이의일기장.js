const fs = require('fs');
// const input = fs.readFileSync('./dev/stdin').toString().trim();
const input = fs.readFileSync('./BOJ/input/input.txt').toString().trim();

function main() {
  const regex = /(apa|epe|ipi|opo|upu)/g;
  const answer = input.replace(regex, (match) => match[0]);
  console.log(answer);
}

main();
