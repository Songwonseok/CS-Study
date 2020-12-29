package algo_study;

import java.util.*;
import java.io.*;

public class Main_2606_바이러스 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
//		int [] com = new int [N];
		ArrayList<Integer> [] com = new ArrayList [N];
		
		for(int i=0;i<N;i++) 
			com[i] = new ArrayList<>();
		
		boolean [] v = new boolean [N];
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			com[c1].add(c2);
			com[c2].add(c1);
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(0);
		int count = 0;
		v[0] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=0;i<com[curr].size();i++) {
				int next = com[curr].get(i);
				if(!v[next]) {
					count++;
					q.offer(next);
					v[next] = true;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(Arrays.toString(v));
		
	}

}
