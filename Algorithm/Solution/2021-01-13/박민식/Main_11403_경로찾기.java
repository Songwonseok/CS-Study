package a2021;

import java.util.*;
import java.io.*;

public class Main_11403_경로찾기 {
	static int [][] map;
	static Queue<Integer> q;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					q.offer(j);
				}
			}
			
			if(q.size()!=0) {
				findGraph(i);
			}
		} // for i
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void findGraph(int currRow) {
		while(!q.isEmpty()) {
			int currCol = q.poll();
			map[currRow][currCol] = 1;
			bfs(currRow, currCol);
		}
	}
	
	public static void bfs(int currRow, int currCol) {
		for(int j=0;j<N;j++) {
			if(map[currCol][j] == 1 && map[currRow][j] != 1)
				q.offer(j);
		}
	}
}
