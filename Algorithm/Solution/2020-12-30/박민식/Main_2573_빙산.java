package algo_study;

import java.util.*;
import java.io.*;

public class Main_2573_빙산 {
	static int N,M,year;
	static int [][] map, temp;
	static boolean [][] isDuplicate;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		year = 0;
		boolean [][] v = new boolean [N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] > 0 && !v[i][j]) {
					v = checkDuplicate(i,j,v);
					answer++;
				}
			}
		}
		
		if(answer >= 2)
			System.out.println(year);
		else {
			while(true) {
				v = new boolean [N][M];
				answer = 0;
				temp = new int [N][M];
				// 녹이기
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(map[i][j] == 0 && !v[i][j]) {
							v = letsMelt(i,j,v);
						}
					}
				}
				// 빼주기 
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						map[i][j] -= temp[i][j];
						if(map[i][j] < 0)
							map[i][j] = 0;
					}
				}
				
				v = new boolean [N][M];
				// 빙산 갯수 찾기
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(map[i][j] > 0 && !v[i][j]) {
							v = checkDuplicate(i,j,v);
							answer++;
						}
					}
				}
				year++;
//				System.out.println(year);
//				System.out.println();
//				for(int i=0;i<N;i++) {
//					for(int j=0;j<M;j++) {
//						System.out.print(map[i][j]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				if(answer >= 2) {
					System.out.println(year);
					break;
				} else if(answer == 0) {
					System.out.println(0);
					break;
				}
			} // end of while
		}
	}// end of main
	
	public static boolean[][] letsMelt(int x, int y, boolean [][] v) {
		Queue<int[]> q = new LinkedList<>();
		int [] di = {-1,1,0,0}, dj = {0,0,-1,1};
		q.offer(new int [] {x,y});
		v[x][y] = true;
		while(!q.isEmpty()) {
			int [] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>N-1 || nj>M-1 || ni<0 || nj<0 || v[ni][nj]) continue;
				if(map[ni][nj] == 0) {
					v[ni][nj] = true;
					q.offer(new int [] {ni,nj});
				} else if(map[ni][nj] > 0) {
					temp[ni][nj]++;
				}
			}
		}
		return v;
	}

	public static boolean[][] checkDuplicate(int x, int y, boolean [][] v) {
		Queue<int[]> q = new LinkedList<>();
		int [] di = {-1,1,0,0}, dj = {0,0,-1,1};
		q.offer(new int [] {x,y});
		v[x][y] = true;
		while(!q.isEmpty()) {
			int [] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>N-1 || nj>M-1 || ni<0 || nj<0 || v[ni][nj]) continue;
				if(map[ni][nj] > 0) {
					v[ni][nj] = true;
					q.offer(new int [] {ni,nj});
				}
			}
		}
		return v;
	}
}
