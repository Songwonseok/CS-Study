const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');


// LCS 구하는 로직
// const getLCS = (table, str1, str2) => {
//   const LCS = [];
//   let i = str2.length, j = str1.length;
//   while (i > 0 && j > 0) {
//     const curr = table[i][j];
//     if (table[i][j - 1] === curr) {
//       j--;
//     } else if (table[i - 1][j] === curr) {
//       i--;
//     } else {
//       i--;
//       j--;
//       LCS.unshift(str2[i]);
//     }
//   }

//   return LCS.join("");
// }

const Main = () => {
  const str1 = inputs[0];
  const str2 = inputs[1];

  const table = new Array(str2.length + 1).fill(0).map(el => new Array(str1.length + 1).fill(0));

  for (let i = 1; i < table.length; i++) {
    for (let j = 1; j < table[i].length; j++) {
      if (str2[i - 1] === str1[j - 1]) {
        table[i][j] = table[i - 1][j - 1] + 1;
      } else {
        table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
      }
    }
  }

  // console.log(getLCS(table, str1, str2));


  console.log(table[str2.length][str1.length]);
};

Main();