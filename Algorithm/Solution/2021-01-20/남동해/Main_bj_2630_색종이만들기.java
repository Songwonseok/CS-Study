package y2021.m01.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
*/

class Main_bj_2630_색종이만들기 {
	public static int map[][],answer[];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int N = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	answer = new int[2];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			map[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	dfs(0,0,N);
    	System.out.println(answer[0]);
    	System.out.println(answer[1]);
	}
	private static void dfs(int si, int sj, int size) {
		if(size==1) {
			answer[map[si][sj]]++;
			return;
		}
		for(int i=si;i<si+size;i+=size/2) {
			for(int j=sj;j<sj+size;j+=size/2) {
				if(!check(i,j,size/2)) {
					answer[map[i][j]]++;
				}else {
					dfs(i,j,size/2);
				}
			}
		}
	}
	private static boolean check(int ci, int cj, int K) {
		int state = map[ci][cj];
		for(int i=ci;i<ci+K;i++) {
			for(int j=cj;j<cj+K;j++) {
				if(state!=map[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
