package baek;

import java.io.*;
import java.util.*;

public class Main_1012_유기농배추 {
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static int N, M;
	
	public static void grouping(boolean[][] graph, int x, int y) {
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] {x,y});
		graph[x][y] = false;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			
			for(int dir=0;dir<4;dir++) {
				int nx = curr[0] + dx[dir];
				int ny = curr[1] + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || !graph[nx][ny])
					continue;
				graph[nx][ny] = false;
				queue.add(new int[] {nx,ny});
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			boolean[][] graph = new boolean[N][M];
			int count = 0;
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = true;
			}
			
			for(int x=0;x<N;x++) {
				for(int y=0;y<M;y++) {
					if(graph[x][y]) {
						count++;
						grouping(graph,x,y);
					}
				}
			}
			
			sb.append(count+"\n");
		}
		
		System.out.println(sb);
	}

}
