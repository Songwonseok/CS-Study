package baek;

import java.io.*;
import java.util.*;

public class Main_10971_외판원순회2 {
	static int N, MIN;
	static int[][] graph;
	static boolean[] visit;
	
	public static void TSP(int start, int prev, int depth, int sum) {
		if(depth == N-1) {
			if(graph[prev][start] == 0)
				return;
			MIN = Math.min(MIN, sum+ graph[prev][start]);
			return;
		}
		
		for(int next=0;next<N;next++) {
			if(!visit[next] && graph[prev][next] != 0) {
				visit[next] = true;
				TSP(start, next, depth+1, sum + graph[prev][next]);
				visit[next] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		MIN = Integer.MAX_VALUE;
		visit = new boolean[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			visit[i] = true;
			TSP(i, i, 0, 0);
			visit[i] = false;
		}
		
		if(MIN == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(MIN);
		}
	}

}
