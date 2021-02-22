package baek;

import java.io.*;
import java.util.*;

public class Main_2636_치즈 {
	static int N,M;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static boolean isEmpty(int[][] board) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 1)
					return false;
			}
		}
		return true;
	}
	
	public static int counting(int[][] board) {
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(board[i][j] == 1)
					count++;
			}
		}
		return count;
	}
	
	public static int melting(int[][] board) {
		int[][] temp = new int[N][M];
		
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		
		queue.add(new int[] {0,0});
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = curr[0] + dx[dir];
				int ny = curr[1] + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny])
					continue;
				
				visit[nx][ny] = true;
				if(board[nx][ny] == 1) {
					temp[nx][ny] = 1;
				}else {
					queue.add(new int[] {nx,ny});
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(temp[i][j] == 1)
					board[i][j] = 0;
			}
		}
		
		return counting(temp);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int times = 0;
		int last = 0;
		
		while(!isEmpty(board)) {
			last = melting(board);
			times++;
		}
		
		System.out.println(times + "\n" + last);
	}

}
