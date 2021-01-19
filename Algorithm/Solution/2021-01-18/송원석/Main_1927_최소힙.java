package baek;

import java.io.*;

public class Main_1927_최소힙 {

	private static int[] heap = new int[100001];
	private static int heapsize = 0;
	
	
	public static void offer(int item) {
		heap[++heapsize] = item;
		
		for(int i = heapsize; i> 1; i/=2) {
			if(heap[i] < heap[i/2]) {
				swap(i, i/2);
			}else {
				break;
			}
		}
	}
	
	public static int poll() {
		if(heapsize == 0) return 0;
		
		int pollData = heap[1];
		heap[1] = heap[heapsize--];
		
		for(int i= 1; i*2 <= heapsize;) {
			if(i*2 == heapsize) {
				if(heap[i*2] < heap[i]) {
					swap(i, i*2);
					i *= 2;
				}
				break;
			}
			
			if(heap[i*2] < heap[i*2 + 1]) {
				if(heap[i*2] < heap[i]) {
					swap(i, i*2);
					i *= 2;
					continue;
				}
			}else {
				if(heap[i*2 + 1] < heap[i]) {
					swap(i, i*2+1);
					i = i*2 + 1;
					continue;
				}
			}
			break;
		}
		
		return pollData;
	}
	public static void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				offer(num);
			}else {
				sb.append(poll()).append("\n");
			}
		}
		System.out.println(sb);
	}

}
