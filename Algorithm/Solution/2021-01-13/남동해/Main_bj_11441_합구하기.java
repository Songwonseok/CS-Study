package y2021.m01.d13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
10 20 30 40 50
5
1 3
2 4
3 5
1 5
4 4
*/

class Main_bj_11441_합구하기 {
	public static int N,M,sum[];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	N = Integer.parseInt(br.readLine());
    	sum = new int[N+1];
    	st = new StringTokenizer(br.readLine());
    	for(int i=1;i<=N;i++) {
    		sum[i]=sum[i-1] + Integer.parseInt(st.nextToken());
    	}
    	M = Integer.parseInt(br.readLine());
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		sb.append(sum[end]-sum[start-1]).append("\n");
    	}
    	System.out.println(sb.toString());
	}
}
