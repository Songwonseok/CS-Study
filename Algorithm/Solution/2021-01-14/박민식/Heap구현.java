package a2021;

public class Heap구현 {
	public static class Heap {
		int N, size = 0;
		int [] arr;
		
		public Heap(int N) {
			this.N = N;
			arr = new int [N];
		}
		
		public void offer(int num) {
			arr[++size] = num;
			System.out.println(size+"번 째 숫자 삽입완료");
			for(int i=size;i>1;i/=2) {
				if(arr[i] > arr[i/2]) {
					swapArr(i, i/2);
				}
			}
		} // end of offer
		
		public int poll() {
			int pollItem = arr[1];
			arr[1] = arr[size];
			arr[size--] = 0;
			int idx = 1;
			
			while(idx*2 <= size) {
				
				
				if(arr[idx*2] < arr[idx*2+1]) {
					if(arr[idx] < arr[idx*2+1]) {
						swapArr(idx, idx*2+1);
						idx *= 2;
						idx++;
					}
				} else {
					if(arr[idx] < arr[idx*2]) {
						swapArr(idx, idx*2);
						idx *= 2;
					}
				}
				
				if(idx*2 == size) {
					if(arr[idx] < arr[idx*2]) {
						swapArr(idx, idx*2);
					}
					break;
				}
			}
			return pollItem;
		} // end of poll
		
		public void swapArr(int i, int j) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		Heap h = new Heap(6);
		h.offer(1);
		h.offer(2);
		h.offer(3);
		h.offer(4);
		System.out.println(h.poll());
		System.out.println(h.poll());
		System.out.println(h.poll());
		System.out.println(h.poll());
	}

}
