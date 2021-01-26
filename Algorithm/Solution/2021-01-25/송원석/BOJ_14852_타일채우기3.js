const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split('\r\n');


const Main = () => {
  const MOD = 1000000007;
  const N = +inputs[0];
  const f = [1, 2];
  const g = [0, 1,]

  for (let i = 2; i <= N; ++i) {
    g[i] = ((f[i - 1] + f[i - 2]) % MOD + g[i - 2]) % MOD;
    f[i] = (f[i - 2] + (2 * g[i]) % MOD) % MOD;
  }
  console.log(f[N]);
}

Main();

