package a2021;

import java.util.*;
import java.io.*;

public class Main_2210_숫자판점프 {
	static String [][] board;
	static HashSet<String> set;
	static int [] di = {-1,1,0,0}, dj = {0,0,-1,1};
	
	public static void makeNumber(int x, int y, int count, String currNumber) {
		if(count==6) {
			set.add(currNumber);
			return;
		}
		
		for(int d=0;d<di.length;d++) {
			int ni = x+di[d];
			int nj = y+dj[d];
			if(ni<0 || nj<0 || ni>4 || nj>4) continue;
			makeNumber(ni,nj,count+1,currNumber+board[ni][nj]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new String [5][5];
		set = new HashSet<>();
		StringTokenizer st;
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				board[i][j] = st.nextToken();
			}
		}
		
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				makeNumber(i,j,0,"");
		
		System.out.println(set.size());
	}

}
