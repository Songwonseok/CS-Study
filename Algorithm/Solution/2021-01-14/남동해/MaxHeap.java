package y2021.m01.d14;

import java.util.Arrays;

public class MaxHeap {
	private int heapsize=0;
	private int[] maxheap = new int[1001];
	
	private void swap(int a, int b) {
		int temp = maxheap[a];
		maxheap[a]=maxheap[b];
		maxheap[b]=temp;
	}
	
	private void insert_maxheap(int a) {
		heapsize++;
		maxheap[heapsize]=a;
		for(int i=heapsize;i>1;i/=2) {
			if(maxheap[i/2]<maxheap[i]) {
				swap(i,i/2);
			}else {
				break;
			}
		}
	}
	
	private int delete_maxheap() {
		if(heapsize==0) {
			return -Integer.MAX_VALUE;
		}
		int ret = maxheap[1];
		maxheap[1]=maxheap[heapsize];
		maxheap[heapsize]=0;
		heapsize--;
		int i=1;
		while(i*2<=heapsize) {
			if(i*2==heapsize) {
				if(maxheap[i]<maxheap[i*2]) {
					swap(i,i*2);
				}
				break;
			}
			if(maxheap[i*2]>maxheap[i*2+1]) {
				if(maxheap[i]<maxheap[i*2]) {
					swap(i,i*2);
					i=i*2;
				}else {
					break;
				}
			}else {
				if(maxheap[i]<maxheap[i*2+1]) {
					swap(i,i*2+1);
					i=i*2+1;
				}else {
					break;
				}
			}
		}
		return ret;
	}
	
	private int[] printHeap(){
		return maxheap;
	}

	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap();
		mh.insert_maxheap(1);
		mh.insert_maxheap(3);
		mh.insert_maxheap(6);
		mh.insert_maxheap(2);
		mh.insert_maxheap(4);
		mh.insert_maxheap(5);
		mh.insert_maxheap(7);
		mh.insert_maxheap(10);
		System.out.println(Arrays.toString(mh.printHeap()));
		System.out.println(mh.delete_maxheap());
		System.out.println(mh.delete_maxheap());
		System.out.println(mh.delete_maxheap());
		System.out.println(mh.delete_maxheap());
		System.out.println(mh.delete_maxheap());
		System.out.println(mh.delete_maxheap());
		System.out.println(mh.delete_maxheap());
	}
}
