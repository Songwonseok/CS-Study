package y2021.m02.d24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1
 */

class Main_bj_1780_종이의개수 {
	public static int N, answer[], paper[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		answer = new int[3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		solve(0,paper.length,0,paper.length);
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
	private static void solve(int si, int ei, int sj, int ej) {
		if(check(si,ei,sj,ej)) {
			answer[paper[si][sj]+1]++;
			return;
		}
		for(int i=si;i<ei;i+=(ei-si)/3) {
			for(int j=sj;j<ej;j+=(ej-sj)/3) {
				solve(i,i+(ei-si)/3,j,j+(ej-sj)/3);
			}
		}
	}
	private static boolean check(int si, int ei, int sj, int ej) {
		int curr = paper[si][sj];
		for(int i=si;i<ei;i++) {
			for(int j=sj;j<ej;j++) {
				if(paper[i][j]!=curr) {
					return false;
				}
			}
		}
		return true;
	}
}