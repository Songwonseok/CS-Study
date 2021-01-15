package y2021.m01.d14;

public class QueueTest {
	private int rear=-1;
	private int front=-1;
	private int queueSize=10001;
	private int[] queue = new int[queueSize];
	
	private void enQueue(int a) {
		if(isFull()) {
			System.out.println("ERROR-overflow");
			return;
		}
		rear++;
		queue[rear]=a;
	}
	private int deQueue() {
		if(isEmpty()) {
			System.out.println("ERROR-underflow");
			return -Integer.MAX_VALUE;
		}
		front++;
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
		if(rear>=queueSize-1) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		QueueTest q = new QueueTest();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
}
