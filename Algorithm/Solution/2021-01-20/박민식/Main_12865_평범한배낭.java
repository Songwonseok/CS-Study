package a2021;

import java.util.*;
import java.io.*;

// 가방에 물건을 많이 넣을 수 있지만, 물건의 가치를 최대로 만들어서 출력하기

public class Main_12865_평범한배낭 {
	static int N,K;
	static int [][] userBag;
	static ArrayList<int[]> sackList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		userBag = new int [N+1][K+1];
		sackList = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			sackList.add(new int [] {W,V});
		}
		
		for(int i=1;i<=N;i++) {
			int [] currList = sackList.get(i-1);
			int weight = currList[0];
			int value = currList[1];
			for(int j=1;j<=K;j++) { // j : 현재 담을 수 있는 무게
				userBag[i][j] = inKnapSack(i,j,weight,value);
			}
		}
		
		System.out.println(userBag[N][K]);
	}
	
	public static int inKnapSack(int i, int j, int weight, int value) {
		int answer = userBag[i-1][j];
		if(j - weight >= 0)
			answer = Math.max(userBag[i-1][j], userBag[i-1][j-weight]+value);
		return answer;
	}
}
