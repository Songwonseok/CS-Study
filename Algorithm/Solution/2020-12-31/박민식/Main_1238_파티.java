package algo_study;

import java.util.*;
import java.io.*;

public class Main_1238_파티_retry {
	static int N,M,host;
	static ArrayList<int[]> [] originalMap, reverseMap;
	static int [] originalDist, reverseDist;
	
	public static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Node n) {
			return weight - n.weight;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		host = Integer.parseInt(st.nextToken()) - 1;
		
		originalDist = new int [N];
		reverseDist = new int [N];
		Arrays.fill(originalDist, Integer.MAX_VALUE);
		Arrays.fill(reverseDist, Integer.MAX_VALUE);
		
		originalMap = new ArrayList[N];
		reverseMap = new ArrayList[N];
		for(int i=0;i<N;i++) {
			originalMap[i] = new ArrayList<>();
			reverseMap[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			
			originalMap[start].add(new int [] {end, weight}); // 친구들 -> Host
			reverseMap[end].add(new int [] {start, weight});  // Host -> 친구들
		}
		
		int max = -1;
		
		dijkstra(originalMap,originalDist,host); // 각 친구들이 Host를 찾아가는 최단경로
		dijkstra(reverseMap,reverseDist, host); // Host에서 각 친구들 찾아가는 최단경로
			
		for(int i=0;i<N;i++) 
			max = Math.max(max, originalDist[i] + reverseDist[i]);
		
		System.out.println(max);
	} // end of main
	
	public static void dijkstra(ArrayList<int[]> [] map, int [] dist, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean [] check = new boolean [N];
		dist[start] = 0;
		
		pq.offer(new Node(start, 0));
		while(!pq.isEmpty()) {
			int curr = pq.poll().end; // 출발지점
			if(check[curr]) continue;
			check[curr] = true;
			
			for(int i=0;i<map[curr].size();i++) {
				int e = map[curr].get(i)[0]; // 도착지점
				int ew = map[curr].get(i)[1]; // 도착지점의 가중치
				if(dist[e] > dist[curr] + ew) {
					dist[e] = dist[curr] + ew;
					pq.offer(new Node(e, dist[e]));
				}
			}
		}
	}
}
