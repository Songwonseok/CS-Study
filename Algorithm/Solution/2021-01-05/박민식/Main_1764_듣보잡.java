package algo_study;

import java.util.*;
import java.io.*;

public class Main_1764_듣보잡 {
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0;i<N+M;i++) {
			String input = br.readLine();
			if(map.get(input) == null)
				map.put(input, 1);
			else
				map.put(input, map.get(input)+1);
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		int count = 0;
		for(String k: map.keySet()) {
			if(map.get(k) > 1) {
				count++;
				pq.offer(k);
			}
		}
		System.out.println(count);
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+"\n");
		}
		System.out.println(sb.toString());
	}

}
