package y2021.m03.d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
4
 */


class Main_bj_1904_01타일 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+3];
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=N;i++) {
			dp[i]=(dp[i-1]%15746+dp[i-2]%15746)%15746;
		}
		System.out.println(dp[N]);
	}
}