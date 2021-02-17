function solution(dartResult) {
  const score = [];
  const effect = {
    S: 1,
    D: 2,
    T: 3,
  };
  let number = "";
  for (let i = 0; i < dartResult.length; i++) {
    if (dartResult[i] == "S" || dartResult[i] == "D" || dartResult[i] == "T") {
      score.push(Number(number));
      number = "";
      score[score.length - 1] **= effect[dartResult[i]];
    } else if (dartResult[i] == "*") {
      for (let j = score.length - 1; j >= 0 && j >= score.length - 2; j--) {
        score[j] *= 2;
      }
    } else if (dartResult[i] == "#") {
      score[score.length - 1] *= -1;
    } else {
      number += dartResult[i];
    }
  }

  const answer = score.reduce((acc, v) => acc += v, 0);

  return answer;
}