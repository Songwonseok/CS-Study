function solution(jobs) {
  let times = 0;
  let waiting = [];

  jobs.sort((a, b) => {
    if (a[0] === b[0])
      return a[1] - b[1];
    return a[0] - b[0];
  });

  let jobIndex = 0;
  let prevEnd = 0;
  let count = 0;

  while (count < jobs.length) {
    let isAdd = false;

    while (jobIndex < jobs.length && jobs[jobIndex][0] <= prevEnd) {
      waiting.push(jobs[jobIndex++]);
      isAdd = true;
    }

    if (isAdd) {
      waiting.sort((a, b) => {
        if (a[1] === b[1])
          return b[0] - a[0]
        return b[1] - a[1];
      });
    }

    if (waiting.length === 0) {
      prevEnd = jobs[jobIndex][0];
    } else {
      const job = waiting.pop();
      prevEnd += job[1];
      times += prevEnd - job[0];
      count++;
    }
  }
  return Math.floor(times / jobs.length);
}