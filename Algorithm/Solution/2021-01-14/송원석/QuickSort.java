package CSstudy;

import java.util.Arrays;

public class QuickSort {
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static int partition(int[] array, int left, int right) {
		int pivot = array[left];
		int low = left+1;
		int high = right;
		
		while(low < high) {
			while(array[low] < pivot) low++;
			while(low <= high && array[high] > pivot) high--;
			
			if(low < high) {
				swap(array,low,high);
			}
		}
		
		swap(array,left, high);
		
		return high;
	}
	
	public static void quickSort(int[] array, int left, int right) {
		if(left >= right) return;
		
		int pivot = partition(array, left, right);
		
		quickSort(array, left, pivot-1);
		quickSort(array, pivot+1, right);
	}
	
	public static void main(String[] args) {
		int[] array = {5,3,9,4,1,6,2,7};
		quickSort(array, 0, array.length-1);
		
		System.out.println(Arrays.toString(array));
	}

}
