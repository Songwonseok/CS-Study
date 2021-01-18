const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().split("\n");
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const Main = () => {
  const set = new Set();
  const dx = [-1, 1, 0, 0], dy = [0, 0, -1, 1];
  const board = inputs.map(el => el.split(" "));

  const dfs = (x, y, total) => {
    if (total.length === 6) {
      set.add(total);
      return;
    }
    for (let dir = 0; dir < dx.length; dir++) {
      const nx = x + dx[dir];
      const ny = y + dy[dir];

      if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
        continue;

      dfs(nx, ny, total + board[nx][ny]);
    }
  }

  for (let i = 0; i < 5; i++) {
    for (let j = 0; j < 5; j++) {
      dfs(i, j, board[i][j]);
    }
  }

  console.log(set.size);
}

Main();