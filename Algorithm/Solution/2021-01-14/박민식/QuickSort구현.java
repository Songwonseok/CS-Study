package a2021;

import java.util.Arrays;

public class QuickSort구현 {
	static int [] arr;
	static int tryNum = 0;;
	public static int divide(int left, int right) {
		System.out.println(++tryNum +"번 째 정렬");
		int pivotIdx = (left + right) / 2;
		int pivotNum = arr[pivotIdx];
		
		while(left < right) {
			while((arr[left] < pivotNum) && (left <  right)) left++;
			while((arr[right]> pivotNum) && (left <= right)) right--;
			
			if(left < right) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println();
		return left;
	}
	
 	public static void quickSort(int left, int right) {
		if(left < right) {
			int pivotIndex = divide(left, right);
			quickSort(left, pivotIndex - 1);
			quickSort(pivotIndex + 1, right);
		}
	}
	
	public static void main(String[] args) {
		arr = new int [10];
		
		for(int i=0;i<arr.length;i++) 
			arr[i] = (int)(Math.random() * 100);
		
		System.out.println("정렬 전");
		System.out.println(Arrays.toString(arr));
		System.out.println();
		
		quickSort(0 ,arr.length-1);
		
		System.out.println("정렬 후");
		System.out.println(Arrays.toString(arr));
	}

}
