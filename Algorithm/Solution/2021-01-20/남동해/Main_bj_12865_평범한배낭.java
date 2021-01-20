package y2021.m01.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4 7
6 13
4 8
3 6
5 12
*/

class Main_bj_12865_평범한배낭 {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int[] W = new int[N];
    	int[] V = new int[N];
    	int[][] dp = new int[N][K+1];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		W[i]=Integer.parseInt(st.nextToken());
    		V[i]=Integer.parseInt(st.nextToken());
    	}
    	for(int i=W[0];i<=K;i++) {
    		dp[0][i]=V[0];
    	}
    	
    	for(int i=1;i<N;i++) {
    		for(int j=0;j<=K;j++) {
    			if(j<W[i]) {
    				dp[i][j]=dp[i-1][j];
    				continue;
    			}
    			int curr = V[i]+dp[i-1][j-W[i]];
    			if(dp[i-1][j]>curr) {
    				dp[i][j]=dp[i-1][j];
    			}else {
    				dp[i][j]=curr;
    			}
    		}
    	}
    	System.out.println(dp[N-1][K]);
	}
}
