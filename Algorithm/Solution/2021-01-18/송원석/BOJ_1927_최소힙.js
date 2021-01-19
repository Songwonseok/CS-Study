const fs = require('fs');
const inputs = fs.readFileSync('./BOJ/input/input.txt').toString().trim().split("\r\n").map(el => parseInt(el));
// const inputs = fs.readFileSync('./dev/stdin').toString().split("\n");

const Main = () => {
  const answer = [];
  const N = inputs[0];
  const heap = new Array(100001);
  let heapsize = 0;

  const swap = (a, b) => {
    const temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }

  const offer = (item) => {
    heap[++heapsize] = item;

    for (let i = heapsize; i > 1; i = Math.floor(i / 2)) {
      const parent = Math.floor(i / 2);
      if (heap[i] < heap[parent]) {
        swap(parent, i);
      } else {
        break;
      }
    }
  }

  const poll = () => {
    if (heapsize === 0) return 0;

    const pollData = heap[1];

    heap[1] = heap[heapsize--];

    for (let i = 1; i * 2 <= heapsize;) {
      if (i * 2 == heapsize) {
        if (heap[i * 2] < heap[i]) {
          swap(i * 2, i);
        }
        break;
      }

      if (heap[i * 2] < heap[i * 2 + 1]) {
        if (heap[i * 2] < heap[i]) {
          swap(i, i * 2);
          i *= 2;
          continue;
        }
      } else {
        if (heap[i * 2 + 1] < heap[i]) {
          swap(i, i * 2 + 1);
          i = i * 2 + 1;
          continue;
        }
      }
      break;
    }

    return pollData;
  }


  for (let i = 1; i <= N; i++) {
    if (inputs[i] != 0) {
      offer(inputs[i], heap, heapsize);
    } else {
      answer.push(poll(heap, heapsize));
    }
  }

  console.log(answer.join("\n"));
}

Main();