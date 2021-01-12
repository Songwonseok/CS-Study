const calculation = (leftSet, rightSet, acc) => {
  [...leftSet].forEach(left => {
    [...rightSet].forEach(right => {
      acc.add(left + right);
      acc.add(left - right);
      acc.add(left * right);
      if (right !== 0)
        acc.add(Math.floor(left / right))
    })
  })
}

const solution = (N, number) => {
  const accumulate = new Array(9).fill(0).map(v => new Set());

  for (let i = 1; i <= 8; i++) {
    const init = '1'.repeat(i) * N;
    accumulate[i].add(init);
  }

  for (let i = 1; i <= 8; i++) {
    for (let j = 1; j < i; j++) {
      const leftSet = accumulate[j];
      const rightSet = accumulate[i - j];
      calculation(leftSet, rightSet, accumulate[i]);
    }
    if (accumulate[i].has(number)) {
      return i;
    }
  }

  return -1;
}

console.log(solution(5, 12));