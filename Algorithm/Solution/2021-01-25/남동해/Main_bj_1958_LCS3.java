package y2021.m01.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
abcdefghijklmn
bdefg
efg
 */


class Main_bj_1958_LCS3 {
	public static int di[]= {-1,0,0},dj[]= {0,-1,0},dk[]= {0,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();
		
		int[][][] dp = new int[A.length()+1][B.length()+1][C.length()+1];
		for(int i=1;i<=A.length();i++) {
			for(int j=1;j<=B.length();j++) {
				for(int k=1;k<=C.length();k++) {
					if(A.charAt(i-1)==B.charAt(j-1)&&B.charAt(j-1)==C.charAt(k-1)) {
						dp[i][j][k]=dp[i-1][j-1][k-1]+1;
					}else {
						int max = 0;
						for(int d=0;d<di.length;d++) {
							int ni = di[d] + i;
							int nj = dj[d] + j;
							int nk = dk[d] + k;
							if(dp[ni][nj][nk]>max) {
								max = dp[ni][nj][nk];
							}
						}
						dp[i][j][k]=max;
					}
				}
			}
		}
		System.out.println(dp[A.length()][B.length()][C.length()]);
	}
}
