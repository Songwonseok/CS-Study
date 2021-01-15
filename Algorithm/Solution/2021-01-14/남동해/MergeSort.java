package y2021.m01.d14;

import java.util.Arrays;

public class MergeSort {
	private int[] mergeSort(int[] array, int left, int right) {
	    if (left < right) {
	        int mid = (left + right) / 2;
	 
	        mergeSort(array, left, mid);
	        mergeSort(array, mid + 1, right);
	        merge(array, left, mid, right);
	    }
	    return array;
	}
	 
	private void merge(int[] array, int left, int mid, int right) {
	    int[] L = Arrays.copyOfRange(array, left, mid + 1);
	    int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);
	 
	    int i = 0, j = 0, k = left;
	    int ll = L.length, rl = R.length;
	 
	    while (i < ll && j < rl) {
	        if (L[i] <= R[j]) {
	            array[k] = L[i++];
	        } else {
	            array[k] = R[j++];
	        }
	        k++;
	    }
	 
	    while (i < ll)
	        array[k++] = L[i++];  
	 
	    while (j < rl)
	        array[k++] = R[j++];    
	}

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = {1,7,2,6,8,3,15,9};
		System.out.println(Arrays.toString(arr));
		arr = ms.mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
