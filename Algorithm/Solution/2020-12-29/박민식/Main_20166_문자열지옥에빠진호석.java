package algo_study;

import java.util.*;
import java.io.*;

public class Main_20166_문자열지옥에빠진호석 {
	static int N,M,K,maxSize;
	static char [][] board;
	static ArrayList<String> list;
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new char [N][M];
		map = new HashMap<>();
		
		for(int i=0;i<N;i++)
			board[i] = br.readLine().toCharArray();
		
		maxSize = -1;
		list = new ArrayList<>();
		
		for(int i=0;i<K;i++) {
			String want = br.readLine();
			list.add(want);
			if(want.length() > maxSize)
				maxSize = want.length();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				up(i,j);
				down(i,j);
				left(i,j);
				right(i,j);
				leftup(i,j);
				rightup(i,j);
				leftdown(i,j);
				rightdown(i,j);
			}
		}
		
		for(int i=0;i<list.size();i++) {
			String answer = list.get(i);
			if(map.containsKey(answer))
				System.out.println(map.get(answer));
			else
				System.out.println(0);
		}
	} // end of main

	private static void rightdown(int i, int j) {
		String tmp = "";
		for(int x=0;x<maxSize;x++) {
			tmp += board[i][j] + "";
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			if(--j < 0) // left
				j = M-1;
			if(++i > N-1) // down
				i = 0;
		}
	}

	private static void leftdown(int i, int j) {
		String tmp = "";
		for(int x=0;x<maxSize;x++) {
			tmp += board[i][j] + "";
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			if(++j > M-1) // right
				j = 0;
			if(++i > N-1) // down
				i = 0;
		}
	}

	private static void rightup(int i, int j) {
		String tmp = "";
		for(int x=0;x<maxSize;x++) {
			tmp += board[i][j] + "";
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			if(++j > M-1) // right
				j = 0;
			if(--i < 0) // up
				i = N-1;
		}
	}

	private static void leftup(int i, int j) {
		String tmp = "";
		for(int x=0;x<maxSize;x++) {
			tmp += board[i][j] + "";
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			if(--j < 0) // left
				j = M-1;
			if(--i < 0) // up
				i = N-1;
		}
		
	}

	private static void right(int i, int j) {
		String tmp = "";
		for(int x=0;x<maxSize;x++) {
			tmp += board[i][j] + "";
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			if(++j > M-1) // right
				j = 0;
		}
	}

	private static void left(int i, int j) {
		String tmp = "";
		for(int x=0;x<maxSize;x++) {
			tmp += board[i][j] + "";
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			if(--j < 0) // left
				j = M-1;
		}
	}

	private static void down(int i, int j) {
		String tmp = "";
		for(int x=0;x<maxSize;x++) {
			tmp += board[i][j] + "";
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			if(++i > N-1) // down
				i = 0;
		}
	}

	private static void up(int i, int j) {
		String tmp = "";
		for(int x=0;x<maxSize;x++) {
			tmp += board[i][j] + "";
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			if(--i < 0) // up
				i = N-1;
		}
	}

	
}
