package algo_study;

import java.util.*;
import java.io.*;

public class Main_1922_네트워크연결 {
	static int N,M;
	static int [] parents;
	static PriorityQueue<Computer> pq;
	
	public static class Computer implements Comparable<Computer>{
		int start;
		int end;
		int cost;
		
		public Computer(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		public int compareTo(Computer com) {
			return cost - com.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int [N];
		
		for(int i=0;i<N;i++) 
			parents[i] = i;
		
		pq = new PriorityQueue<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			pq.offer(new Computer(start, end, cost));
		}
		
		int answer = 0;
		
		while(!pq.isEmpty()) {
			Computer com = pq.poll();
			int start = com.start;
			int end = com.end;
			int cost = com.cost;
			int a = find(start);
			int b = find(end);
			
			if(a == b) continue;
			
			union(a,b);
			answer += cost;
		}
		
		System.out.println(answer);
	} // end of main method

	public static int find(int idx) {
		if(parents[idx] == idx) return idx;
		parents[idx] = find(parents[idx]);
		return parents[idx];
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot)
			parents[aRoot] = bRoot;
		return;
	}
}
