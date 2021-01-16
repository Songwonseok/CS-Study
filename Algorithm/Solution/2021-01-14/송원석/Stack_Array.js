class Stack {
  #data;
  #top;
  constructor() {
    this.#data = new Array(10);
    this.#top = -1;
  }

  push(item) {
    if (this.isEmpty()) {
      this.resize();
    }
    this.#data[++this.#top] = item;
  }

  pop() {
    if (this.#top == -1)
      return undefined;
    const item = this.#data[this.#top--];
    return item;
  }

  isEmpty() {
    if (this.#top + 1 === this.#data.length)
      return true;

    return false;
  }

  size() {
    return this.#top + 1;
  }

  resize() {
    const newArray = new Array(this.#data.length);
    this.#data = this.#data.concat(newArray);
  }

  peek() {
    if (this.isEmpty())
      return undefined;
    return this.#data[this.#top];
  }
}

const stack = new Stack();