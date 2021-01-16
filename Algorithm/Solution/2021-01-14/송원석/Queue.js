class Queue {
  #data;
  #length;
  #rear;
  #front
  constructor() {
    this.#data = new Array(5);
    this.#front = -1;
    this.#rear = -1;
    this.#length = 0;
  }

  add(item) {
    if (this.isFull()) {
      console.log('resize', this.#data);
      this.resize();
    }
    this.#length++;
    this.#data[(++this.#rear) % this.#data.length] = item;
  }

  poll() {
    if (this.isEmpty())
      return undefined;
    this.#length--;
    return this.#data[(++this.#front) % this.#data.length];
  }

  isEmpty() {
    if (this.#rear === this.#front)
      return true;
    return false;
  }

  isFull() {
    if ((this.#rear + 1) % this.#data.length === this.#front)
      return true;
    return false;
  }

  resize() {
    const resized = new Array(this.#data.length * 2);
    let idx = 0;

    while (!this.isEmpty()) {
      resized[idx++] = this.#data[++this.#front];
    }
    resized[idx] = this.peek();
    this.#front = -1;
    this.#rear = this.#data.length - 2;
    this.#data = resized;
  }

  peek() {
    if (this.isEmpty())
      return undefined;
    return this.#data[this.#rear]
  }

  size() {
    return this.#length;
  }
}

const queue = new Queue();

