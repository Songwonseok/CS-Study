function findSet(p, n) {
  if (p[n] === n) {
    return n;
  }
  return findSet(p, p[n]);
}

function unionSet(p, a, b) {
  a = findSet(p, a);
  b = findSet(p, b);

  if (a < b) {
    p[a] = b;
  } else {
    p[b] = a;
  }
}

function solution(n, costs) {
  let answer = 0;
  const p = new Array(n);
  for (let i = 0; i < n; i++) {
    p[i] = i;
  }
  costs.sort((a, b) => a[2] - b[2]);

  for (let i = 0; i < costs.length; i++) {
    const a = costs[i][0];
    const b = costs[i][1];
    if (findSet(p, a) !== findSet(p, b)) {
      unionSet(p, a, b);
      answer += costs[i][2];
    }
  }
  return answer;
}

console.log(solution(4, [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]]));