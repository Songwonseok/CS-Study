const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split('\r\n');

function main() {
  const [N, M, B] = inputs[0].split(" ").map(v => +v);
  const ground = new Array(N);
  let min = 256;
  let max = 0;

  for (let i = 0; i < N; i++) {
    ground[i] = inputs[i + 1].split(" ").map(v => +v);
    min = Math.min(min, ...ground[i]);
    max = Math.max(max, ...ground[i]);
  }
  let answerTime = Number.MAX_VALUE;
  let highest = 0;

  for (let h = min; h <= max; h++) {
    let over = 0;
    let lack = 0;

    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (ground[i][j] < h) {
          lack += h - ground[i][j];
        } else if (ground[i][j] > h) {
          over += ground[i][j] - h;
        }
      }
    }

    if (over + B >= lack) {
      const time = lack + over * 2;
      if (time <= answerTime) {
        answerTime = time;
        highest = h;
      }
    }
  }

  console.log(`${answerTime} ${highest}`);
}

main();