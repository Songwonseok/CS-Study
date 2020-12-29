package baek;

import java.io.*;
import java.util.*;

public class Main_1697_숨바꼭질 {
	static int MAX_RANGE = 100001;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] visit = new boolean[MAX_RANGE];
		int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치
		visit[N] = true;
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[]{N,0});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			if(curr[0] == K) {
				System.out.println(curr[1]);
				break;
			}
			
			int[] next = {curr[0]-1, curr[0]+1, curr[0]*2};
			
			for(int i=0;i<next.length;i++) {
				if(next[i] < 0 || next[i] >= MAX_RANGE || visit[next[i]]) 
					continue;
				visit[next[i]] = true;
				queue.add(new int[] {next[i], curr[1]+1});
			}
		}
	}
}
