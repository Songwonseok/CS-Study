package a2021;

import java.io.*;
import java.util.*;

public class Main_1927_최소힙 {
	public static class Heap {
		int N, size = 0;
		int [] arr;
		
		public Heap(int N) {
			this.N = N;
			arr = new int [N];
		}
		
		public void offer(int num) {
			arr[++size] = num;
//			System.out.println(size+"번 째 숫자 삽입완료");
			for(int i=size;i>1;i/=2) {
				if(arr[i/2] > arr[i]) {
					swapArr(i/2, i);
					continue;
				}
				break;
			}
//			System.out.println(Arrays.toString(arr));
		} // end of offer
		
		public boolean isEmpty() {
			return size==0 ? true : false;
		}
		
		public int poll() {
			if(isEmpty()) 
				return 0;
			
			int pollItem = arr[1];
			arr[1] = arr[size];
			arr[size--] = 0;
			int idx = 1;
			
			while(idx*2 <= size) {
				if(idx*2 == size) {
					if(arr[idx*2] < arr[idx]) {
						swapArr(idx*2, idx);
					}
					break;
				}
				if(arr[idx*2+1] > arr[idx*2]) {
					if(arr[idx*2] < arr[idx]) {
						swapArr(idx*2, idx);
						idx *= 2;
						continue;
					}
				} else {
					if(arr[idx*2+1] < arr[idx]) {
						swapArr(idx*2+1, idx);
						idx *= 2;
						idx++;
						continue;
					}
				}
				break;
			}
			return pollItem;
		} // end of poll
		
		public void swapArr(int i, int j) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Heap h = new Heap(100001);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			int question = Integer.parseInt(br.readLine());
			if(question == 0) {
				sb.append(h.poll()+"\n");
			} else {
				h.offer(question);
			}
		}
		
		System.out.println(sb);
	}

}
