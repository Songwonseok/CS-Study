package algo_study;

import java.io.*;
import java.util.*;

public class Main_10819_차이를최대로 {
	static int N,max;
	static int [] originalArr, randomArr;
	static boolean [] Arr_v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		originalArr = new int [N];
		randomArr = new int [N];
		Arr_v = new boolean [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++)
			originalArr[i] = Integer.parseInt(st.nextToken());
		
		max = -1;
		
		findMaxSum(0);
		
		System.out.println(max);
	}
	
	public static void findMaxSum(int n) {
		if(n==N) {
			int tmp = 0;
			for(int i=0;i<N-1;i++) 
				tmp += Math.abs(randomArr[i] - randomArr[i+1]);
			max = Math.max(max, tmp);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!Arr_v[i]) {
				Arr_v[i] = true;
				randomArr[n] = originalArr[i];
				findMaxSum(n+1);
				Arr_v[i] = false;
			}
		}
	}

}
