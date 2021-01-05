package baek;

import java.io.*;
import java.util.*;

public class Main_1922_네트워크연결_kruskal {
	public static int[] parent;
	public static int N,M;
	public static ArrayList<int[]> graph;
	
	public static int getParent(int num) {
		if(parent[num] == num)
			return num;
		
		return getParent(parent[num]);
	}
	
	public static void union(int a, int b) {
		int computerA = getParent(a);
		int computerB = getParent(b);
		
		if(computerA == computerB) return;
		
		if(computerA > computerB)
			parent[computerA] = computerB;
		else
			parent[computerB] = computerA;
	}
	
	
	public static int kruskal() {
		int sum = 0;
		for(int i=0;i<graph.size();i++) {
			int[] curr = graph.get(i);
			
			if(getParent(curr[0]) != getParent(curr[1])) {
				sum += curr[2];
				union(curr[0], curr[1]);
			}
		}
		return sum;
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		graph = new ArrayList<int[]>();
		
		for(int i=1;i<=N;i++)
			parent[i] = i;
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph.add(new int[] {from,to,value});
		}
		
		Collections.sort(graph, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[2], b[2]);
			}
		});
		
		System.out.println(kruskal());
	}
}
