package baek;

import java.util.*;
import java.io.*;

public class Main_12865_평범한배낭 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] DP = new int[K+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			// 앞에서부터 하면 이미 넣은 가방을 비교할 경우가 생김
//			for(int j= W;j<=K;j++) { 
//				DP[j] = Math.max(DP[j], DP[j-W] + V);
//			}
			
			for(int j= K;j >= W;j--) {
				DP[j] = Math.max(DP[j], DP[j-W] + V);
			}
		}
		System.out.println(DP[K]);
	}
}
