function solution(operations) {
  const queue = [];

  operations.forEach(el => {
    const op = el.split(" ");
    if (op[0] === "I") {
      queue.push(parseInt(op[1]));
      queue.sort((a, b) => a - b);
    } else {
      if (queue.length === 0)
        return;
      if (op[1] > 0)
        queue.pop();
      else
        queue.shift();
    }
  })
  if (queue.length === 0)
    return [0, 0];

  return [queue[queue.length - 1], queue[0]];
}