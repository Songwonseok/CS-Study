const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split("\n");
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split('\r\n');

function main() {
  const N = +inputs[0];
  const balloons = inputs[1].split(" ");
  const answer = [];
  const visit = new Array(N).fill(false);
  let currIdx = 0;
  while (true) {
    answer.push(currIdx + 1);
    if (answer.length === N) break;
    visit[currIdx] = true;
    let move = balloons[currIdx];

    if (move > 0) {
      while (move > 0) {
        currIdx = (currIdx + 1) % N
        if (!visit[currIdx]) {
          move--;
        }
      }
    } else {
      move = Math.abs(move);
      while (move > 0) {
        currIdx = (currIdx === 0) ? N - 1 : currIdx - 1;
        if (!visit[currIdx]) {
          move--;
        }
      }
    }
  }

  console.log(answer.join(" "));

}
main();