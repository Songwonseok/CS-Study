package y2021.m02.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
 */

class Main_bj_2636_치즈 {
	public static int count;
	public static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		count = 0;
		flag = false;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					count++;
				}
			}
		}
		if(count==0) {
			System.out.println(0);
			System.out.println(0);
		}else {
			int result = 0;
			while(true) {
				result++;
				map = bfs(map, N,M);
				if(map==null) {
					break;
				}
			}
			System.out.println(result);
			System.out.println(count);
		}
	}

	private static int[][] bfs(int[][] map, int N, int M) {
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> melt = new LinkedList<>();
		q.add(new int[] {0,0});
		visit[0][0]=true;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<M&&!visit[ni][nj]) {
					visit[ni][nj]=true;
					if(map[ni][nj]==0) {
						q.add(new int[] {ni,nj});
					}else {
						melt.add(new int[] {ni,nj});
					}
				}
			}
		}
		if(count-melt.size()==0) {
			return null;
		}else {
			count-=melt.size();
		}
		while(!melt.isEmpty()) {
			int[] curr = melt.poll();
			map[curr[0]][curr[1]]=0;
		}
		return map;
	}
}