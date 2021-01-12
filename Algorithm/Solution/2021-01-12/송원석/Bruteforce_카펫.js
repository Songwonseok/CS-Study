function solution(brown, yellow) {
  var answer = [];
  const total = brown + yellow;

  let height = 1;
  let width = yellow;
  let area = (height + 2) * (width + 2);

  while (area != total && height <= width) {
    height++;
    if (yellow % height != 0 || height > width) continue;
    width = yellow / height;
    area = (height + 2) * (width + 2);
  }

  return [width + 2, height + 2];
}