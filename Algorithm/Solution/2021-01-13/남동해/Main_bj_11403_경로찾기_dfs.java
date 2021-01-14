package y2021.m01.d13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
0 1 0
0 0 1
1 0 0
*/

class Main_bj_11403_경로찾기_dfs {
	public static int N,matrix[][],answer[][];
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	N = Integer.parseInt(br.readLine());
    	matrix = new int[N][N];
    	answer = new int[N][N];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			matrix[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	solve();
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			System.out.print(answer[i][j] + " ");
    		}
    		System.out.println();
    	}
	}
	private static void solve() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				visit = new boolean[N];
				if(dfs(i,j,false)) {
					answer[i][j]=1;
				}
			}
		}
	}
	private static boolean dfs(int start, int end,boolean flag) {
		for(int i=0;i<N;i++) {
			if(matrix[start][i]==1) {
				if(i==end) {
					flag = true;
					break;
				}
				if(!visit[i]) {
					visit[i]=true;
					flag = dfs(i,end,flag);
				}
			}
		}
		return flag;
	}
}
