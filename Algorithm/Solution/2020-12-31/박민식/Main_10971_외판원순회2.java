package algo_study;

import java.util.*;
import java.io.*;

public class Main_10971_외판원순회2 {
	static int N, min;
	static int [] dist;
	static int [][] map;
	static boolean [] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			dist = new int [N];
			v = new boolean [N];
			findRoad(i,i,0);
		}
		
		System.out.println(min);
	} // end of main
	
	public static void findRoad(int curr, int start, int count) {
		if(curr==start && count == N) {
			int temp = 0;
			for(int i=0;i<N;i++)
				temp += dist[i];
			
			min = Math.min(min, temp);
			return;
		}
		
		for(int j=0;j<N;j++) {
			int tmp = map[curr][j];
			if(tmp > 0 && !v[j]) {
				v[j] = true;
				dist[count] = tmp;
				findRoad(j,start,count+1);
				v[j] = false;
			}
		}
	}
}
