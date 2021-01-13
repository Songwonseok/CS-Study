package a2021;

import java.util.*;
import java.io.*;

public class Main_13901_로봇 {
	static int N,M;
	static boolean [][] v;
	static int [][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		int k = Integer.parseInt(br.readLine()); // 장애물 갯수
		
		map = new int [N][M];
		v = new boolean[N][M];
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			v[r][c] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// 1 : 상  2 : 하  3 : 좌  4 : 우
		String [] commend = br.readLine().split(" ");
		
		boolean dontMove = false;
		v[R][C] = true;
		int idx = 0;
		
		while(!dontMove) {
			if(idx == commend.length) idx =0;
				String dir = commend[idx];
				
				if(dir.equals("1")) {
					if(!isValid(R-1,C)) {
						idx++;
						continue;
					}
					v[R-1][C] = true;
					R--;
				} else if(dir.equals("2")) {
					if(!isValid(R+1,C)) {
						idx++;
						continue;
					}
					v[R+1][C] = true;
					R++;
				} else if(dir.equals("3")) {
					if(!isValid(R,C-1)) {
						idx++;
						continue;
					}
					v[R][C-1] = true;
					C--;
				} else {
					if(!isValid(R,C+1)) {
						idx++;
						continue;
					}
					v[R][C+1] = true;
					C++;
				}
				
				if(!isMove(R,C)) dontMove = true;
			
		}
		System.out.println(R+" "+C);
	}
	
	public static boolean isMove(int r, int c) {
		int [] di = {-1,1,0,0};
		int [] dj = {0,0,-1,1};
		int count = 0;
		
		for(int d=0;d<4;d++) {
			int ni = r+di[d];
			int nj = c+dj[d];
			if(ni<0 || nj<0 || ni>N-1 || nj>M-1 || v[ni][nj]) count++;
		}
		
		if(count==4) return false;
		else return true;
	}
	
	public static boolean isValid(int r, int c) {
		if(r<0 || c<0 || r>N-1 || c>M-1 || v[r][c]) return false;
		return true;
	}

}
