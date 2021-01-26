package y2021.m01.d26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
6 3 15
0 0 1 0 0 0
0 0 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 1 0
0 0 0 1 0 0
6 5
2 2 5 6
5 4 1 6
4 2 3 5
 */


class Main_bj_19238_스타트택시 {
	public static int N,M,map[][],di[]= {-1,1,0,0},dj[]= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		//입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int ti = Integer.parseInt(st.nextToken())-1;
		int tj = Integer.parseInt(st.nextToken())-1;
		int[][] passenger=new int[M][4];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				passenger[i][j]=Integer.parseInt(st.nextToken())-1;
			}
			map[passenger[i][0]][passenger[i][1]]=-(i+1);
		}
		//입력끝
		
		boolean f = false;
		for(int i=0;i<M;i++) {
			int[] next = searchPass(ti,tj);
			if(next[0]==-1) {
				f = true;
				break;
			}
			fuel-=next[3];
			if(fuel<0) {
				f = true;
				break;
			}
			ti=next[0];
			tj=next[1];
			map[ti][tj]=0;
			next = drivingDest(ti,tj,passenger[next[2]-1][2],passenger[next[2]-1][3]);
			if(next[0]==-1) {
				f = true;
				break;
			}
			ti=next[0];
			tj=next[1];
			fuel-=next[2];
			if(fuel<0) {
				f=true;
				break;
			}
			fuel+=next[2]*2;
		}
		if(f) {
			System.out.println(-1);
		}else {
			System.out.println(fuel);
		}
	}
	
	private static int[] drivingDest(int si, int sj, int ei, int ej) {
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {si,sj,0});
		visit[si][sj]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<N&&!visit[ni][nj]&&map[ni][nj]!=1) {
					q.add(new int[] {ni,nj,curr[2]+1});
					visit[ni][nj]=true;
					if(ni==ei&&nj==ej) {
						return new int[] {ni,nj,curr[2]+1};
					}
				}
			}
		}
		return new int[] {-1,-1};
	}
	
	private static int[] searchPass(int ti, int tj) {
		int esc = Integer.MAX_VALUE;
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {ti,tj,0});
		if(map[ti][tj]<0) {
			return new int[] {ti,tj,-map[ti][tj],0};
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0]) {
					return 1;
				}else if(o1[0]==o2[0]){
					if(o1[1]>o2[1]) {
						return 1;
					}				
				}
				return -1;
			}
		});
		visit[ti][tj]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				if(ni>=0&&nj>=0&&ni<N&nj<N&&!visit[ni][nj]&&map[ni][nj]!=1) {
					visit[ni][nj]=true;
					if(esc>=curr[2]+1) {
						q.add(new int[] {ni,nj,curr[2]+1});
						if(map[ni][nj]<0) {
							esc=curr[2]+1;
							pq.add(new int[] {ni,nj,-map[ni][nj],curr[2]+1});
						}
					}
				}
			}
		}
		if(pq.size()==0) {
			return new int[] {-1,-1};
		}
		return pq.poll();
	}
}
