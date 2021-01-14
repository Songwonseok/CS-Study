package y2021.m01.d13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3 3
1
1 0
1 1
1 2 3 4
*/

class Main_bj_13901_로봇 {
	public static int R,C,K,di[] = {0,-1,1,0,0},dj[] = {0,0,0,-1,1},dir[];
	public static boolean map[][];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(br.readLine());
    	map = new boolean[R][C];
    	
    	for(int i=0;i<K;i++) {
    		st = new StringTokenizer(br.readLine());
    		int tr = Integer.parseInt(st.nextToken());
    		int tc = Integer.parseInt(st.nextToken());
    		map[tr][tc]=true;
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int sr = Integer.parseInt(st.nextToken());
    	int sc = Integer.parseInt(st.nextToken());
    	dir = new int[4];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<4;i++) {
    		dir[i] = Integer.parseInt(st.nextToken());
    	}
    	map[sr][sc]=true;
    	int answer[] = moveRobot(sr,sc);
    	System.out.println(answer[0] + " " + answer[1]);
	}
	private static int[] moveRobot(int sr, int sc) {
		int dirindex=0;
		int esc=0;
		while(esc<4) {
			int ni = sr + di[dir[dirindex]];
			int nj = sc + dj[dir[dirindex]];
			if(ni>=0&&nj>=0&&ni<R&&nj<C&&!map[ni][nj]) {
				esc = 0;
				sr = ni;
				sc = nj;
				map[ni][nj]=true;
			}else {
				esc++;
				dirindex++;
				if(dirindex==4) {
					dirindex=0;
				}
			}
		}
		return new int[] {sr,sc};
	}
}
