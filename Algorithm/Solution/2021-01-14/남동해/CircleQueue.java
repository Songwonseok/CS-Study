package y2021.m01.d14;

public class CircleQueue {
	private int rear=0;
	private int front=0;
	private int queueSize=10001;
	private int[] queue = new int[queueSize];
	
	private void enQueue(int a) {
		if(isFull()) {
			System.out.println("ERROR-overflow");
			return;
		}
		rear=(rear+1)%queueSize;
		queue[rear]=a;
	}
	private int deQueue() {
		if(isEmpty()) {
			System.out.println("ERROR-underflow");
			return -Integer.MAX_VALUE;
		}
		front=(front+1)%queueSize;
		int temp = queue[front];
		return temp;
	}

	private boolean isEmpty() {
		if(rear==front) {
			return true;
		}else {
			return false;
		}
	}
	private boolean isFull() {
		if((rear+1)%queueSize>=front) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		CircleQueue q = new CircleQueue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
}
