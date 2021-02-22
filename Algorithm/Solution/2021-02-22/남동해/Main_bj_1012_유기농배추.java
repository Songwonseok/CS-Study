package y2021.m02.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
 */

class Main_bj_1012_유기농배추 {
	public static int N,M,K,map[][],di[] = {-1,1,0,0}, dj[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int nm = Integer.parseInt(st.nextToken());
				int nn = Integer.parseInt(st.nextToken());
				map[nn][nm] = 1;
			}
			int count = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1) {
						count++;
						map[i][j]=0;
						dfs(i,j);
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	private static void dfs(int i, int j) {
		for(int d=0;d<4;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&nj>=0&&ni<N&&nj<M&&map[ni][nj]==1) {
				map[ni][nj]=0;
				dfs(ni,nj);
			}
		}
	}
}