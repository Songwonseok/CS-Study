package a2021;

public class Stack구현 {
	public static class RealStack {
		int sp;
		int [] realstack;
		int size;
		
		public RealStack(int size) {
			sp = -1;
			realstack = new int [size];
			this.size = size;
		}
		
		public RealStack() {
			sp = -1;
			size = 100;
			realstack = new int [size];
		}
		
		public int peek() {
			if(isEmpty()) {
				System.out.println("stack에 값이 없음다~");
				return Integer.MIN_VALUE;
			}
			return realstack[sp];
		}
		
		public void push(int number) {
			sp++;
			if(isFull()) {
				System.out.println("stack이 가득 찼슴다~");
				return;
			}
			realstack[sp] = number;
			System.out.println(number+" push 완료");
		}
		
		public int pop() {
			sp--;
			if(isEmpty()) {
				System.out.println("stack에 값이 없음다~");
				return Integer.MIN_VALUE;
			}
			return realstack[sp];
		}
		
		public boolean isEmpty() {
			return sp==-1 ? true : false;
		}
		
		public boolean isFull() {
			return sp==size-1 ? true : false;
		}
		
		public void clear() {
			sp = -1;
		}
	}
	
	
	public static void main(String[] args) {
		int N = (int) (Math.random() * 10);
		RealStack stack = new RealStack(N);
		System.out.println(stack.peek());
		if(stack.isEmpty()) System.out.println("스택 비어있음");
		else System.out.println("스택 안비어있음");
		
		for(int i=0;i<N;i++)
			stack.push(i);
		
		System.out.println("스택의 최상단에는"+stack.peek()+"가 있습니다.");
		if(stack.isFull()) System.out.println("스택 꽉참");
		else System.out.println("아직 덜 참");
		
		for(int i=0;i<N;i++)
			System.out.println(stack.pop());
	}
}
