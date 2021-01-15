package y2021.m01.d14;

public class StackTest {
	private int SP=-1;	
	private int stackSize=10001;
	private int[] stack = new int[stackSize];

	private void push(int a) {
		if(isFull(a)) {
			int[] arr = new int[stackSize*2];
	        System.arraycopy(stack,0,arr,0,stackSize);
	        stack = arr;
	        stackSize*=2;
	        return;
		}
		SP++;
		stack[SP]=a;
	}
	
	private int pop() {
		if(isEmpty()) {
			System.out.println("isEmpty");
			return -Integer.MAX_VALUE;
		}
		int a = stack[SP];
		SP--;
		return a;
	}
	
	private int peek() {
		if(isEmpty()) {
			System.out.println("Null");
			return -Integer.MAX_VALUE;
		}
		return stack[SP];
	}
	
	private boolean isEmpty() {
		if(SP<=-1) {
			return true;
		}else {
			return false;
		}
	}

	private boolean isFull(int a) {
		if(SP>=stackSize) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		StackTest st = new StackTest();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.peek());
	}
}
