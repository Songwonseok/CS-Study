const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().split('\n');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().split('\r\n');

const Main = () => {
  inputs.shift();
  const students = inputs.map(el => {
    const info = el.split(" ");
    return {
      name: info[0],
      korean: +info[1],
      english: +info[2],
      math: +info[3]
    }
  });

  students.sort((a, b) => {
    if (a.korean === b.korean) {
      if (a.english === b.english) {
        if (a.math === b.math) {
          if (a.name < b.name) {
            return -1;
          } else {
            return 1;
          }
        }
        return b.math - a.math
      }
      return a.english - b.english
    }
    return b.korean - a.korean;
  })

  let answer = students.reduce((acc, el) => acc += el.name + "\n", "");

  console.log(answer);
}

Main()