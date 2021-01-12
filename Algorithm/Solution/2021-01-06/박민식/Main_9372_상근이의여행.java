package algo_study;

import java.io.*;
import java.util.*;

public class Main_9372_상근이의여행 {
	static ArrayList<Integer> [] list;
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 국가의 수
			M = Integer.parseInt(st.nextToken()); // 뱅기의 수
			
			list = new ArrayList[N];
			
			for(int i=0;i<N;i++)
				list[i] = new ArrayList<>();
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				
				list[start].add(end);
				list[end].add(start);
			}
			
			System.out.println(solve());
		}
	}// end of main
	
	public static int solve() {
		int answer = -1;
		Queue<Integer> q = new LinkedList<>();
		boolean [] v = new boolean [N];
		q.offer(0); // 현재위치 , 몇개 나라를 지나왔는지
		v[0] = true;
		
		while(!q.isEmpty()) {
			answer++;
			int curr = q.poll();
			for(int i=0;i<list[curr].size();i++) {
				int next = list[curr].get(i);
				if(!v[next]) {
					v[next] = true;
					q.offer(next);
				}
			}
			
		}
		return answer;
	}

}
