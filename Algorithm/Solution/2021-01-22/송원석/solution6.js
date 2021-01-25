function update(accArray, changeArray) {
  let startIndex = changeArray[0][0];
  let changeValue = changeArray[0][1];
  changeArray.shift();

  for (let i = startIndex; i < accArray.length; i++) {
    while (changeArray.length > 0 && changeArray[0][0] === i) {
      changeValue += changeArray.shift()[1];
    }
    accArray[i] += changeValue;
  }
}

function solution(v, q) {
  const answer = [];
  const accArray = [v[0]];

  for (let i = 1; i < v.length; i++) {
    accArray[i] = accArray[i - 1] + v[i];
  }
  let changeArray = [];
  let isSorted = false;

  q.forEach(el => {
    if (el[0] === 1) {
      if (changeArray.length > 0) {
        if (!isSorted) {
          changeArray.sort((a, b) => a[0] - b[0]);
          isSorted = true;
        }

        if (changeArray[0][0] <= el[2]) {
          update(accArray, changeArray);
        }
      }

      if (el[1] > 0) {
        answer.push(accArray[el[2]] - accArray[el[1] - 1])
      } else {
        answer.push(accArray[el[2]])
      }
    } else {
      const change = el[2] - v[el[1]];
      v[el[1]] = el[2];
      changeArray.push([el[1], change])
      isSorted = false;
    }
  })

  return answer;
}