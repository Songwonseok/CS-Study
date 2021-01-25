const fs = require('fs');
// const inputs = fs.readFileSync('./dev/stdin').toString().trim().split("\n");
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split('\r\n');

const Main = () => {
  const [N, K] = inputs.shift().split(" ").map(el => Number(el));

  if (K < 5) {
    console.log(0);
    return;
  }

  const set = new Set([..."antic"]);
  let max = 0;

  const alphabet = [...new Set(inputs.reduce((acc, word) => {
    return acc.concat([...word]);
  }, []))];

  if (alphabet.length <= K) {
    console.log(N);
    return;
  }

  const combination = (start) => {
    if (set.size === K) {
      const count = inputs.reduce((acc, word) => {
        for (let i = 4; i < word.length - 4; i++) {
          if (!set.has(word[i])) {
            return acc;
          }
        }
        return acc + 1;
      }, 0)
      max = Math.max(max, count);
      return;
    }

    for (let i = start; i < alphabet.length; i++) {
      if (set.has(alphabet[i])) continue;
      set.add(alphabet[i]);
      combination(i);
      set.delete(alphabet[i]);
    }
  }

  combination(0);
  console.log(max);
}

Main();

