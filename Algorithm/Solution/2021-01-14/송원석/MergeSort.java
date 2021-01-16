package CSstudy;

import java.util.Arrays;

public class MergeSort {
	public static void merge(int[] array, int left, int mid, int right) {
		int[] leftArray = Arrays.copyOfRange(array, left, mid+1);
		int[] rightArray = Arrays.copyOfRange(array, mid, right+1);
		
		int leftIdx = 0;
		int rightIdx = 0;
		
		for(int i=left;i<=right;i++) {
			if(rightIdx >= rightArray.length || leftArray[leftIdx] < rightArray[rightIdx]) {
				array[i] = leftArray[leftIdx++];
			}else{
				array[i] = rightArray[rightIdx++];
			}
		}
	}
	
	public static void mergeSort(int[] array, int left, int right) {
		if(left >= right) return;
		
		int mid = (left+right)/2;
		
		mergeSort(array, left, mid);
		mergeSort(array, mid+1, right);
		
		merge(array, left, mid, right);
		
	}

	public static void main(String[] args) {
		int[] array = {5,3,9,4,1,6,2,7};
		mergeSort(array, 0, array.length-1);
		
		System.out.println(Arrays.toString(array));
	}

}
