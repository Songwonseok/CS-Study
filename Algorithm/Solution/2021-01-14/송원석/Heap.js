class Heap {
  #tree;
  constructor() {
    this.#tree = [0];
  }

  add(item) {
    if (typeof item != "number")
      throw new Error('Only Number!');

    this.#tree.push(item);

    if (this.#tree.length <= 2) return;
    let curr = this.#tree.length - 1;
    let parent = Math.floor(curr / 2);
    while (parent > 0 && this.compareTo(this.#tree[curr], this.#tree[parent])) {
      this.swap(curr, parent);
      curr = parent;
      parent = Math.floor(curr / 2);
    }
  }

  poll() {
    if (this.isEmpty()) return undefined;

    if (this.#tree.length === 2) {
      return this.#tree.pop();
    }
    const pollData = this.#tree[1];
    this.#tree[1] = this.#tree.pop();
    let curr = 1;
    while (curr < this.#tree.length - 1) {
      const left = curr * 2;
      const right = (curr * 2) + 1;

      if (left > this.#tree.length - 1) break;

      if (this.compareTo(this.#tree[curr], this.#tree[left]) && this.compareTo(this.#tree[curr], (this.#tree[right] | this.#tree[left])))
        break;

      if (!this.#tree[right] || this.compareTo(this.#tree[left], this.#tree[right])) {
        this.swap(left, curr);
        curr = left;
      } else {
        this.swap(right, curr);
        curr = right;
      }
    }

    return pollData;
  }

  compareTo(a, b) {
    if (b < a) return true;
    return false;
  }

  swap(a, b) {
    const temp = this.#tree[a];
    this.#tree[a] = this.#tree[b];
    this.#tree[b] = temp;
  }

  isEmpty() {
    if (this.#tree.length === 1)
      return true;
    return false;
  }
}


const heap = new Heap();

heap.add(1)
heap.add(3)
heap.add(10)
heap.add(9)
heap.add(4)
heap.add(2)

console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.poll());
console.log(heap.isEmpty());