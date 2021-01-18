package baek;

import java.io.*;
import java.util.*;

public class Main_1654_랜선자르기 {
	
	public static long binarySearch(long left, long right, int[] array, int target) {
		long result = 0;
		
		while(left <= right) {
			long mid = (left+right)/2;
			int sum = 0;
			for(int num : array) {
				sum += num/mid;
			}
			
			if(sum >= target) {
				result = mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] wires = new int[K];
		long total = 0;
		
		for(int i=0;i<K;i++) {
			wires[i] = Integer.parseInt(br.readLine());
			total += wires[i];
		}
		
		long answer = binarySearch(1,total/N,wires,N);
		
		System.out.println(answer);
		
	}

}
