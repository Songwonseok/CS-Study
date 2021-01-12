function solution(citations) {
  citations.sort((a, b) => a - b);
  let index = citations.findIndex((el, idx) => el >= citations.length - idx);

  if (index < 0)
    return 0;

  return citations.length - index;
}