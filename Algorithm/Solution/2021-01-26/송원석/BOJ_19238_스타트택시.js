const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split("\n");
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split('\r\n');

const [N, M, gas] = inputs.shift().split(" ").map(el => +el);
const dx = [-1, 1, 0, 0], dy = [0, 0, -1, 1];
const board = new Array(N);
const map = new Map();
const taxi = {};

function goToDestination(endX, endY) {
  const queue = [[taxi.x, taxi.y, 0]];
  const visit = new Array(N).fill(0).map(el => new Array(N).fill(false));
  visit[taxi.x][taxi.y] = true;
  while (queue.length > 0) {
    const curr = queue.shift();

    if (curr[2] > taxi.gas)
      return false;

    if (curr[0] === endX && curr[1] === endY) {
      taxi.x = curr[0];
      taxi.y = curr[1];
      taxi.gas += curr[2];
      return true;
    }

    for (let dir = 0; dir < dx.length; dir++) {
      const nx = curr[0] + dx[dir];
      const ny = curr[1] + dy[dir];
      if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] === 1 || visit[nx][ny]) continue;
      visit[nx][ny] = true;
      queue.push([nx, ny, curr[2] + 1]);
    }
  }
}

function findPassenger() {
  const queue = [[taxi.x, taxi.y, 0]];

  let find = -1;
  const passengers = [];
  const visit = new Array(N).fill(0).map(el => new Array(N).fill(false));

  visit[taxi.x][taxi.y] = true;
  while (queue.length > 0) {
    const curr = queue.shift();

    if (passengers.length === map.size)
      break;

    if (curr[2] > taxi.gas)
      return false;

    if (find != -1 && curr[2] > find)
      break;

    if (map.has(curr[0] * N + curr[1])) {
      find = curr[2];
      passengers.push([curr[0], curr[1], curr[2]]);
      continue;
    }



    for (let dir = 0; dir < dx.length; dir++) {
      const nx = curr[0] + dx[dir];
      const ny = curr[1] + dy[dir];
      if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] === 1 || visit[nx][ny]) continue;
      visit[nx][ny] = true;
      queue.push([nx, ny, curr[2] + 1]);
    }
  }

  if (passengers.length === 0) {
    return false;
  }

  passengers.sort((a, b) => {
    if (a[0] === b[0]) {
      return a[1] - b[1];
    }
    return a[0] - b[0];
  })

  const key = passengers[0][0] * N + passengers[0][1];
  const destination = map.get(key);
  const endX = Math.floor(destination / N);
  const endY = destination % N;

  map.delete(key);

  taxi.x = passengers[0][0];
  taxi.y = passengers[0][1];
  taxi.gas -= passengers[0][2];
  return goToDestination(endX, endY);
}


function main() {
  for (let i = 0; i < N; i++) {
    board[i] = inputs.shift().split(" ").map(el => +el);
  }
  const [x, y] = inputs.shift().split(" ").map(el => +el);

  taxi.x = x - 1;
  taxi.y = y - 1;
  taxi.gas = gas;

  for (let i = 1; i <= M; i++) {
    const [startX, startY, endX, endY] = inputs.shift().split(" ").map(el => Number(el) - 1);
    map.set(startX * N + startY, endX * N + endY);
  }

  let check = true;

  for (let i = 0; i < M; i++) {
    if (!findPassenger()) {
      check = false;
      break;
    }
  }

  if (check) {
    console.log(taxi.gas);
  } else {
    console.log(-1);
  }

}
main();