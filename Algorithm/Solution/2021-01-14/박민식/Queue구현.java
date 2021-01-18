package a2021;

public class Queue구현 {
	
	public static class RealQueue {
		int top;
		int rear;
		int size;
		int [] realqueue;
		
		public RealQueue(int size) {
			top = -1;
			rear = -1;
			this.size = size;
			realqueue = new int [size];
		}
		
		public RealQueue() {
			top = -1;
			rear = -1;
			size = 100;
			realqueue = new int [size];
		}
		
		public void offer(int num) {
			rear++;
			if(isFull()) {
				System.out.println("Queue가 가득 찼슴다~");
				return;
			}
			realqueue[rear] = num;
			return;
		}
		
		public int poll() {
			top++;
			if(isEmpty()) {
				System.out.println("Queue에 값이 없음다~");
				return Integer.MIN_VALUE;
			}
			return realqueue[top];
		}
		
		public boolean isFull() {
			return rear == size-1 ? true : false;
		}
		
		public boolean isEmpty() {
			return rear == top ? true : false;
		}
		
		public int peek() {
			if(isEmpty()) {
				System.out.println("Queue에 값이 없음다~");
				return Integer.MIN_VALUE;
			}
			return realqueue[top];
		}
		
		public void clear() {
			//RealQueue(size); // 이건 왜 안됌?
			top = -1;
			rear = -1;
			realqueue = new int [size];
		}
	}
	public static void main(String[] args) {
		int N = (int)Math.random() * 10;
		RealQueue queue = new RealQueue(3);
		if(queue.isEmpty()) System.out.println("큐 비어있음");
		else System.out.println("큐 안비어있음");
		
		for(int i=0;i<N;i++)
			queue.offer(i);
		
		System.out.println("큐의 최상단에는"+queue.peek()+"가 있습니다.");;
		if(queue.isFull()) System.out.println("큐 꽉참");
		else System.out.println("아직 덜 참");
		
		for(int i=0;i<N;i++)
			System.out.println(queue.poll());
	}

}
