package y2021.m01.d14;

import java.util.Arrays;

public class QuickSort {
	private static int partition(int[] array, int left, int right) {
	    int mid = (left + right) / 2;
	    swap(array, left, mid);
	 
	    int pivot = array[left];
	    int i = left, j = right;
	 
	    while (i < j) {
	        while (pivot < array[j]) {
	            j--;
	        }
	 
	        while (i < j && pivot >= array[i]) {
	            i++;
	        }
	        swap(array, i, j);
	    }
	    array[left] = array[i];
	    array[i] = pivot;
	    return i;
	}
	 
	private static void swap(int[] array, int a, int b) {
	    int temp = array[b];
	    array[b] = array[a];
	    array[a] = temp;
	}
	 
	private int[] quicksort(int[] array, int left, int right) {
	    if (left >= right) {
	        return null;
	    }
	 
	    int pi = partition(array, left, right);
	 
	    quicksort(array, left, pi - 1);
	    quicksort(array, pi + 1, right);
	    return array;
	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr = {1,7,2,6,8,3,15,9};
		System.out.println(Arrays.toString(arr));
		arr = qs.quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
