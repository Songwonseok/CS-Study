package y2021.m01.d18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
9
0
12345678
1
2
0
0
0
0
32
*/

class Main_bj_1927_최소힙 {
	private static int heapsize=0;
	private static long[] minheap = new long[100001];
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<N;i++) {
    		long input = Integer.parseInt(br.readLine());
    		if(input==0) {
    			sb.append(delete_minheap()).append("\n");
    		}else {
    			insert_minheap(input);
    		}
    	}
    	System.out.println(sb.toString());
	}
	
	private static void insert_minheap(long a) {
		heapsize++;
		minheap[heapsize]=a;
		for(int i=heapsize;i>1;i/=2) {
			if(minheap[i/2]>minheap[i]) {
				swap(i,i/2);
			}else {
				break;
			}
		}
	}
	
	private static long delete_minheap() {
		if(heapsize==0) {
			return 0;
		}
		long ret = minheap[1];
		minheap[1]=minheap[heapsize];
		minheap[heapsize]=0;
		heapsize--;
		int i=1;
		while(i*2<=heapsize) {
			if(i*2==heapsize) {
				if(minheap[i]>minheap[i*2]) {
					swap(i,i*2);
				}
				break;
			}
			if(minheap[i*2]<minheap[i*2+1]) {
				if(minheap[i]>minheap[i*2]) {
					swap(i,i*2);
					i=i*2;
				}else {
					break;
				}
			}else {
				if(minheap[i]>minheap[i*2+1]) {
					swap(i,i*2+1);
					i=i*2+1;
				}else {
					break;
				}
			}
		}
		return ret;
	}
	
	private static void swap(int a, int b) {
		long temp = minheap[a];
		minheap[a]=minheap[b];
		minheap[b]=temp;
	}
}
