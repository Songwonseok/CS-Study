function solution(clothes) {
  let answer = 1;
  const map = new Map();
  clothes.forEach(v => map.set(v[1], map.has(v[1]) ? map.get(v[1]) + 1 : 1));
  for (const value of map.values()) {
    answer *= value + 1;
  }
  return answer - 1;
}