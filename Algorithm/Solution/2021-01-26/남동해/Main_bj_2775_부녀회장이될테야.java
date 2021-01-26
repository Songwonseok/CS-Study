package y2021.m01.d26;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
2
1
3
2
3
 */


class Main_bj_2775_부녀회장이될테야 {
	public static int[] start;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		start = new int[15];
		for(int i=1;i<15;i++) {
			start[i]=i;
		}
		for(int tc=0;tc<T;tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int dp[][] = new int[k+1][n+1];
			dp[0]=start;
			for(int i=1;i<=k;i++) {
				for(int j=1;j<=n;j++) {
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}
			}
			System.out.println(dp[k][n]);
		}
	}
}