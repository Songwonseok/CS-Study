const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim();
const input = fs.readFileSync('./BOJ/input/input.txt').toString().trim();

function main() {
  const regex = /^(100+1+|01)+$/;
  if (input.match(regex)) {
    console.log("SUBMARINE");
  } else {
    console.log("NOISE");
  }
}

main();