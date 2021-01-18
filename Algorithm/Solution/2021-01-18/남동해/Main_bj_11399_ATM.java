package y2021.m01.d18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
3 1 4 3 2
*/

class Main_bj_11399_ATM {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] arr = new int[N];
    	for(int i=0;i<N;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
    	arr = mergeSort(arr, 0, arr.length-1);
    	int answer = 0;
    	for(int i=0;i<N;i++) {
    		answer+=arr[i]*(N-i);
    	}
    	System.out.println(answer);
	}
	
	private static int[] mergeSort(int[] array, int left, int right) {
	    if (left < right) {
	        int mid = (left + right) / 2;
	 
	        mergeSort(array, left, mid);
	        mergeSort(array, mid + 1, right);
	        merge(array, left, mid, right);
	    }
	    return array;
	}
	 
	private static void merge(int[] array, int left, int mid, int right) {
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
}
