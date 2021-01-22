package y2021.m01.d21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
ACAYKP
CAPCAK
 */


class Main_bj_9251_LCS {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		
		int[][] dp = new int[A.length()+1][B.length()+1];
		for(int i=1;i<=A.length();i++) {
			for(int j=1;j<=B.length();j++) {
				if(A.charAt(i-1)==B.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
//		for(int i=0;i<dp.length;i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(dp[A.length()][B.length()]);
//		int di = A.length();
//		int dj = B.length();
//		int N = dp[di][dj];
//		char[] data = new char[N];
//		int index = N-1;
//		while(di>0||dj>0) {
//			if(dp[di][dj]==dp[di][dj-1]) {
//				dj--;
//			}else if(dp[di][dj]==dp[di-1][dj]) {
//				di--;
//			}else {
//				di--;
//				dj--;
//				data[index]=A.charAt(di);
//				index--;
//			}
//		}
//		System.out.println(Arrays.toString(data));
	}
}
