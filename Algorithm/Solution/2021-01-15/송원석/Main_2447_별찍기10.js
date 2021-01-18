const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().split("\n");
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const drawEmpty = (board, startX, startY, size) => {
  for (let x = startX; x < startX + size; x++) {
    for (let y = startY; y < startY + size; y++) {
      board[x][y] = ' ';
    }
  }
}

const partition = (board, startX, startY, N) => {
  if (N === 1) {
    board[startX][startY] = '*';
    return;
  }

  for (let x = startX; x < startX + N; x += N / 3) {
    for (let y = startY; y < startY + N; y += N / 3) {
      if (x === startX + N / 3 && y === startY + N / 3) {
        drawEmpty(board, x, y, N / 3);
        continue;
      }
      partition(board, x, y, N / 3);
    }
  }
}


const Main = () => {
  const N = parseInt(inputs[0]);
  const board = new Array(N).fill(0).map(el => new Array(N));

  partition(board, 0, 0, N);

  const astarisk = board.reduce((acc, el) => acc += el.join('') + "\n", '')

  console.log(astarisk);
}

Main();