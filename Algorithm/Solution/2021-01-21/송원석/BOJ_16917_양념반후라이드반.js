const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const Main = () => {
  let [A, B, C, X, Y] = inputs[0].split(" ").map(el => Number(el));

  let answer = 0;

  if (C * 2 <= A + B) {
    if (X > Y) {
      answer += (C * 2) * Y;
      X -= Y;
      Y = 0;
    } else {
      answer += (C * 2) * X;
      Y -= X;
      X = 0;
    }
  }

  if (X > 0) {
    if (C * 2 < A)
      answer += (C * 2) * X;
    else
      answer += A * X;
  }

  if (Y > 0) {
    if (C * 2 < B)
      answer += (C * 2) * Y;
    else
      answer += B * Y;
  }


  console.log(answer);
}


Main();