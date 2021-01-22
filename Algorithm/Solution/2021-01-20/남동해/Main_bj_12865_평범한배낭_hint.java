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
1 3
1 1
*/

class Main_bj_12865_평범한배낭_hint {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int[] W = new int[N];
    	int[] V = new int[N];
    	int[] dp = new int[K+1];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		W[i]=Integer.parseInt(st.nextToken());
    		V[i]=Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i=0;i<N;i++) {
    		for(int j=K;j>=W[i];j--) {
    			int curr = V[i]+dp[j-W[i]];
    			if(dp[j]>curr) {
    				dp[j]=dp[j];
    			}else {
    				dp[j]=curr;
    			}
    		}
    	}
//    	for(int i=1;i<N;i++) {
//    		for(int j=W[i];j<N;j++) {
//    			int curr = V[i]+dp[j-W[i]];
//    			if(dp[j]>curr) {
//    				dp[j]=dp[j];
//    			}else {
//    				dp[j]=curr;
//    			}
//    		}
//    	}
    	System.out.println(dp[K]);
	}
}
