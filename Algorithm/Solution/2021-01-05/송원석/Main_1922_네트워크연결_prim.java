package baek;

import java.io.*;
import java.util.*;

public class Main_1922_네트워크연결_prim {
	static ArrayList<int[]>[] graph;
	static int N,M;
	
	public static int prim() {
		int sum = 0;
		boolean[] visit = new boolean[N+1];
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		pq.add(new int[] {1,0});
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			
			if(visit[curr[0]]) continue;
			
			visit[curr[0]] = true;
			sum += curr[1];
			
			for(int i=0;i < graph[curr[0]].size();i++) {
				int[] next = graph[curr[0]].get(i);
				
				if(visit[next[0]]) continue;
				
				pq.add(next);
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++)
			graph[i] = new ArrayList<int[]>();
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph[from].add(new int[] {to,value});
			graph[to].add(new int[] {from,value});
		}
		
		System.out.println(prim());
	}
}
