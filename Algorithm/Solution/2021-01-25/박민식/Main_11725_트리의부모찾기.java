package a2021;

import java.util.*;
import java.io.*;

public class Main_11725_트리의부모찾기 {
	static ArrayList<Integer> [] list;
	static int N;
	static int [] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()) + 1;
		list = new ArrayList [N];
		
		for(int i=0;i<N;i++) 
			list[i] = new ArrayList<>();
		
		for(int i=0;i<N-2;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		findParent();
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<N;i++)
			sb.append(result[i]+"\n");
			
		System.out.println(sb);
	}
	
	public static void findParent() {
		result = new int [N];
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int i=0;i<list[curr].size();i++) {
				int idx = list[curr].get(i);
				if(result[idx] == 0) {
					result[idx] = curr;
					q.offer(idx);
				}
			}
		}
	}
}
