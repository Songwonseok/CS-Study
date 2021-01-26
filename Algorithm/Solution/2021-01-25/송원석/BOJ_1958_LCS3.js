const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split('\r\n');

const getTable = (str1, str2, str3) => {
  const table = new Array(str1.length + 1).fill(0).map(el => new Array(str2.length + 1).fill(0).map(el => new Array(str3.length + 1).fill(0)))
  for (let i = 1; i <= str1.length; i++) {
    for (let j = 1; j <= str2.length; j++) {
      for (let k = 1; k <= str3.length; k++) {
        if (str1[i - 1] === str2[j - 1] && str2[j - 1] === str3[k - 1]) {
          table[i][j][k] = table[i - 1][j - 1][k - 1] + 1
        } else {
          table[i][j][k] = Math.max(table[i - 1][j][k], table[i][j - 1][k], table[i][j][k - 1]);
        }
      }
    }
  }
  return table;
}

const Main = () => {
  inputs.sort((a, b) => a.length - b.length);
  const table = getTable(inputs[0], inputs[1], inputs[2]);
  console.log(table[inputs[0].length][inputs[1].length][inputs[2].length]);
};

Main();