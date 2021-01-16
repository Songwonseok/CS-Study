class Queue {
  constructor() {
    this.enQueueStack = [];
    this.deQueueStack = [];
  }

  add(item) {
    this.enQueueStack.push(item);
  }

  poll() {
    if (this.deQueueStack.length === 0) {
      while (this.enQueueStack.length > 0) {
        this.deQueueStack.push(this.enQueueStack.pop());
      }
    }
    return this.deQueueStack.pop();
  }
}


const queue = new Queue();
