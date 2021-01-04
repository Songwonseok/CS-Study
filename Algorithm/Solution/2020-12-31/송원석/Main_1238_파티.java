package baek;

import java.io.*;
import java.util.*;

public class Main_1238_파티 {
	static int N,M,X, INF = Integer.MAX_VALUE;
	
	public static class Node implements Comparable<Node>{
		public int idx;
		public int distance;
		
		Node(int idx, int distance){
			this.idx = idx;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
	
	public static int[] dijkstra(int start, ArrayList<Node>[] distList) {
		int[] dist = new int[N+1];
		
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while(!pq.isEmpty()) {
			int curr = pq.poll().idx;
			
			for(Node next : distList[curr]) {
				if(dist[next.idx] > next.distance + dist[curr]) {
					dist[next.idx] = next.distance + dist[curr];
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] distList = new ArrayList[N+1];
		ArrayList<Node>[] reverseList = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			distList[i] = new ArrayList<Node>();
			reverseList[i] = new ArrayList<Node>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			distList[from].add(new Node(to, weight));
			reverseList[to].add(new Node(from, weight));
		}
		
		int[] going = dijkstra(X, distList);
		int[] comeBack = dijkstra(X, reverseList);
		
		for(int i=1;i<=N;i++) {
			if(i != X) {
				max = Math.max(max, going[i] + comeBack[i]);
			}
		}
		System.out.println(max);
	}

}
