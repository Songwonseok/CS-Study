package baek;

import java.io.*;
import java.util.*;

public class Main_1806_부분합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = numbers[0];
		int INF = Integer.MAX_VALUE;
		int min = INF;
		
		while(left <= right && right < N) {
			if(sum >= S) {
				int length = right - left +1;
				min = Math.min(min, length);
			}
			
			if(sum < S) {
				if(right + 1 >= N)
					break;
				sum += numbers[++right];
			}else {
				sum -= numbers[left++];
			}
		}
		
		if(min == INF) {
			System.out.println(0);
		}else {
			System.out.println(min);
		}
	}

}
