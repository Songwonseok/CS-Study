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

class Main_bj_11403_경로찾기_FloydWarshall {
	public static int N,matrix[][];
	public static boolean visit[];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	N = Integer.parseInt(br.readLine());
    	matrix = new int[N][N];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			matrix[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	floydWarshall();
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			System.out.print(matrix[i][j] + " ");
    		}
    		System.out.println();
    	}
	}
	private static void floydWarshall() {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(matrix[i][k]==1&&matrix[k][j]==1) {
						matrix[i][j]=1;
					}
				}
			}
		}
	}
}
