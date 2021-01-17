package y2021.m01.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 2 1
1 1 1 1 1
*/

class Main_bj_2210_숫자판점프 {
	public static int N, map[][],di[] = {-1,1,0,0}, dj[]= {0,0,-1,1},answer;
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	N=5;
    	map = new int[N][N];
    	visit = new boolean[1000000];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			map[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			dfs(i,j,0,map[i][j]);
    		}
    	}
    	System.out.println(answer);
	}
	private static void dfs(int i, int j, int count,int num) {
		if(count==5) {
			if(!visit[num]) {
				answer++;
				visit[num]=true;
			}
			return;
		}
		for(int d=0;d<4;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&nj>=0&&ni<N&&nj<N) {
				dfs(ni,nj,count+1,num*10+map[ni][nj]);
			}
		}
	}
}
