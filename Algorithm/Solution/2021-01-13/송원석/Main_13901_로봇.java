package baek;

import java.io.*;
import java.util.*;

public class Main_13901_로봇 {
	static int R,C;
	static int[] dir, robot;
	static int [] dx = {-1,1,0,0}, dy = {0,0,-1,1}; // 상하좌우 // 0,1,2,3 // 1 => 0
	static int[][] room;
	
	public static void solve() {
		int dirChange = 0;
		int curr = 0;
		StringBuilder sb = new StringBuilder();
		
		while(dirChange < 4) {
			int nx = robot[0] + dx[dir[curr] -1];
			int ny = robot[1] + dy[dir[curr] -1];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || room[nx][ny] == 1) {
				curr = (curr + 1)%4;
				dirChange++;
				continue;
			}
			
			room[nx][ny] = 1;
			robot[0] = nx;
			robot[1] = ny;
			dirChange = 0;
		}
		
		sb.append(robot[0]).append(" ").append(robot[1]);
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		room = new int[R][C];
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			room[r][c] = 1;
		}
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		robot = new int[] {sx,sy};
		room[sx][sy] = 1;
		st = new StringTokenizer(br.readLine());
		dir = new int[4];
		
		for(int i=0;i<4;i++) 
			dir[i] = Integer.parseInt(st.nextToken()); // 1,2,3,4, 상하좌우 
		
		solve();
		
	}

}
