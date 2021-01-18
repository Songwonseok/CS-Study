package y2021.m01.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
27
*/

class Main_bj_2447_별찍기10 {
	public static boolean map[][];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int N = Integer.parseInt(br.readLine());
    	map = new boolean[N][N];
    	dfs(0,0,N);
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			if(map[i][j]) {
    				sb.append("*");
    			}else {
    				sb.append(" ");
    			}
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb.toString());
	}

	private static void dfs(int si, int sj, int size) {
		if(size==3) {
			int index=1;
			for(int i=si;i<si+size;i++) {
				for(int j=sj;j<sj+size;j++) {
					if(index==5) {
						index++;
						continue;
					}
					map[i][j]=true;
					index++;
				}
			}
			return;
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==1&&j==1) {
					continue;
				}
				dfs(si+i*size/3,sj+j*size/3,size/3);
			}
		}
	}
}
