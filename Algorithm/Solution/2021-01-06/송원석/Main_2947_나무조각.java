package baek;

import java.io.*;
import java.util.*;

public class Main_2947_나무조각 {
	
	public static void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void printArray(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int num: arr) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
	
	public static boolean checkSort(int[] arr) {
		for(int i = 0; i<arr.length;i++) {
			if(arr[i] != i+1) 
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] woods = new int[5];
		
		for(int i=0;i<5;i++)
			woods[i] = Integer.parseInt(st.nextToken());
		
		while(!checkSort(woods)) {
			for(int i=0;i<woods.length -1;i++) {
				if(woods[i] > woods[i+1]) {
					swap(i,i+1,woods);
					printArray(woods);
				}
			}
		}
	}
}
