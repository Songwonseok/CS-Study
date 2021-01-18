const dfs = (numbers, target, acc, depth) => {
  if (depth === numbers.length) {
    return (acc === target) ? 1 : 0;
  }
  return dfs(numbers, target, acc + numbers[depth], depth + 1)
    + dfs(numbers, target, acc - numbers[depth], depth + 1)
}

function solution(numbers, target) {
  return dfs(numbers, target, 0, 0);
}