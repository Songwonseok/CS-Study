function solution(n, lost, reserve) {
  const students = new Array(n + 1).fill(0);
  lost.forEach(v => students[v]--);
  reserve.forEach(v => students[v]++);

  reserve.forEach(v => {
    if (students[v] <= 0) return;
    if (v > 1 && students[v - 1] < 0) {
      students[v]--;
      students[v - 1]++;
    } else if (v < n && students[v + 1] < 0) {
      students[v]--;
      students[v + 1]++;
    }
  })
  let count = 0;
  for (let i = 1; i <= n; i++)
    if (students[i] >= 0) count++;

  return count;
}