class Node {
  constructor(item) {
    this.item = item;
    this.next = null;
  }
}

class Stack {
  #head;
  #top;
  #length;
  constructor() {
    this.#head = null;
    this.#top = null;
    this.#length = 0;
  }

  push(item) {
    const newItem = new Node(item);
    if (this.#head == null) {
      this.#head = newItem
      this.#top = this.#head;
    } else {
      this.#top.next = newItem;
      this.#top = this.#top.next;
    }
    this.#length++;
  }

  pop() {
    if (this.#top === null)
      return undefined;

    const popItem = this.#top.item;
    this.#length--;

    if (this.#head === this.#top) {
      this.#head = null;
      this.#top = this.#head;
    } else {
      let prev = this.#head;
      while (prev.next !== this.#top) {
        prev = prev.next;
      }
      this.#top = prev;
    }

    return popItem;
  }

  isEmpty() {
    return this.#top === null ? true : false;
  }

  size() {
    return this.#length;
  }

}

const stack = new Stack();

console.log(stack.isEmpty());
stack.push(1)
stack.push(2)
stack.push(3)
stack.push(4)
console.log(stack.isEmpty());
console.log(stack.pop(), stack.size());
console.log(stack.pop(), stack.size());
console.log(stack.pop(), stack.size());
console.log(stack.pop(), stack.size());
console.log(stack.pop(), stack.size());
console.log(stack.isEmpty());