function getCount(startTime, logs) {
  let count = 0;
  const endTime = startTime + 999;

  for (let i = 0; i < logs.length; i++) {
    if (logs[i].start <= startTime && logs[i].end >= endTime) {
      count++;
    } else if (logs[i].end >= startTime && logs[i].end <= endTime) {
      count++;
    } else if (logs[i].start >= startTime && logs[i].start <= endTime) {
      count++;
    }
  }
  return count;
}

function solution(lines) {
  let firstTime = Number.MAX_VALUE;
  const logs = lines.map(v => {
    const log = v.split(" ");
    const time = Number(log[2].slice(0, -1)) * 1000 - 1;
    const end = new Date(log.slice(0, 2).join(" ")).getTime();
    const start = end - time;
    firstTime = Math.min(start, firstTime);
    return { start, end };
  });
  let max = 0;

  logs.sort((a, b) => a.start - b.start);

  for (let i = 0; i < logs.length; i++) {
    const count1 = getCount(logs[i].start, logs);
    const count2 = getCount(logs[i].end, logs);

    max = Math.max(max, count1, count2);
  }

  return max;
}