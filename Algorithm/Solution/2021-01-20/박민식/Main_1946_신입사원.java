package a2021;

import java.util.*;
import java.io.*;

public class Main_1946_신입사원 {

	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				public int compare(int [] o1, int [] o2) {
					return o1[0]-o2[0];
				}
			});
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pq.offer(new int [] {a,b});
			}
			
			int [] curr = pq.poll();
			int count = 1; // 첫빠따는 비교할 사람이 없으므로 바로 통과
			int interviewScore = curr[1];
			while(!pq.isEmpty()) {
				curr = pq.poll();
				if(interviewScore > curr[1]) {
					interviewScore = curr[1];
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
