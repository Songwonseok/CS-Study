package a2021;

import java.util.Arrays;

public class MergeSort구현 {
	static int[] originalArr, storageArr;
	
	public static class MergeSort {

		public void mergeSort(int left, int right) {
			if (left >= right) return;
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			startMerge(left, right, mid);
		}

		public void startMerge(int left, int right ,int mid) {
			int idx = left;
			int lIndex = left;
			int	mIndex = mid + 1;
			storageArr = new int[10];
			
			while(lIndex <= mid || mIndex <= right) {
				if(mIndex > right || (lIndex <= mid && originalArr[lIndex] < originalArr[mIndex])) {
					storageArr[idx++] = originalArr[lIndex++];
				} else {
					storageArr[idx++] = originalArr[mIndex++];
				}
			}
			
			for(int i=left;i<=right;i++)
				originalArr[i] = storageArr[i];
			System.out.println("left: "+left+" mid: "+mid+" right: "+right);
//			System.out.println("lIndex: "+lIndex+" mIndex: "+mIndex);
			System.out.println(Arrays.toString(storageArr));
			System.out.println(Arrays.toString(originalArr));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		originalArr = new int[10];

		for (int i = 0; i < 10; i++) {
			originalArr[i] = (int)(Math.random() * 100);
		}
		
		System.out.println("정렬 전");
		System.out.println(Arrays.toString(originalArr));
		int left = 0;
		int right = originalArr.length-1;
		System.out.println();
		MergeSort sort = new MergeSort();
		sort.mergeSort(left, right);
		System.out.println();
		System.out.println("정렬 후");
		System.out.println(Arrays.toString(originalArr));

	}

}
