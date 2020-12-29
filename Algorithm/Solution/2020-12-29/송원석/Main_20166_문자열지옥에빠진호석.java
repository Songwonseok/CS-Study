package baek;

import java.io.*;
import java.util.*;

public class Main_20166_문자열지옥에빠진호석 {
	static HashMap<String, Integer> map = new HashMap<>();
	static int N, M, K, MAX_LENGTH;
	static int[] dx = {-1,-1,0,1,1,1,0,-1}, dy = {0,1,1,1,0,-1,-1,-1}; // 시계방향
	static char[][] hell;
	
	public static void solve(int x, int y, int depth, String result) {
		if(map.containsKey(result)) 
			map.put(result, map.get(result) + 1);
		
		if(depth == MAX_LENGTH)
			return;
		
		for(int dir=0;dir< dx.length;dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0)
				nx = N-1;
			else if(nx >= N)
				nx = 0;
			
			if(ny < 0)
				ny = M-1;
			else if(ny >= M)
				ny = 0;
			
			solve(nx,ny, depth+1, result+hell[nx][ny]);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		String[] stringArray = new String[K];
		hell = new char[N][M];
		map = new HashMap<>();
		MAX_LENGTH = 0;
		
		for(int i=0;i<N;i++) {
			hell[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<K;i++) {
			String favoriteString = br.readLine();
			MAX_LENGTH = Math.max(MAX_LENGTH, favoriteString.length());
			map.put(favoriteString, 0);
			stringArray[i] = favoriteString;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				solve(i,j, 1, Character.toString(hell[i][j]));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(String key: stringArray) {
			sb.append(map.get(key)).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
