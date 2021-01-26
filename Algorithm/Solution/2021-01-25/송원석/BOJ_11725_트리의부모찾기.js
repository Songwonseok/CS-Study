const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split('\r\n');

const Main = () => {
  const N = +inputs.shift();
  const graph = new Array(N + 1).fill(0).map(el => []);
  const parent = new Array(N + 1);

  for (let i = 0; i < N - 1; i++) {
    const [from, to] = inputs[i].split(" ")
    graph[from].push(to);
    graph[to].push(from);
  }

  let answer = "";
  const queue = [];
  queue.push(1);

  while (queue.length > 0) {
    const curr = queue.shift();
    for (let i = 0; i < graph[curr].length; i++) {
      const next = graph[curr][i];
      if (!parent[next]) {
        parent[next] = curr;
        queue.push(next);
      }
    }
  }


  for (let i = 2; i <= N; i++) {
    answer += `${parent[i]}\n`;
  }
  console.log(answer);
}

Main();