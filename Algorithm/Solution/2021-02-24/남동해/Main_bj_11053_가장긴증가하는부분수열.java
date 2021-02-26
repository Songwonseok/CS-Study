package y2021.m02.d24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
6
10 20 10 30 20 50
 */

class Main_bj_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		int answer = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int curr = 0;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					curr = Math.max(curr, dp[j]);
				}
			}
			dp[i]=curr+1;
			if(answer<dp[i]) {
				answer = dp[i];
			}
		}
		System.out.println(answer);
	}
}