package a2021;

import java.io.*;
import java.util.*;

public class Main_2447_별찍기10 {
	static int N;
	static String [][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new String [N][N];
		
		makeStars(0,0,N,false);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void makeStars(int x, int y, int n, boolean iswhiteSpace) {
		
		if(iswhiteSpace) { // 여백이어야 하는 경우
			for(int i=x;i<x+n;i++) {
				for(int j=y;j<y+n;j++) {
					board[i][j] = " ";
				}
			}
			return;
		} // end of if
		
		if(n==1) {
			board[x][y] = "*";
			return;
		}
		
		int size = n/3;
		int wsCount = 0; // 여백칸을 찾기위함, 매 배열 중 5번째는 무조건 여백
		
		for(int i=x;i<x+n;i+=size) {
			for(int j=y;j<y+n;j+=size) {
				wsCount++;
				if(wsCount==5)
					makeStars(i,j,size,true);
				else
					makeStars(i,j,size,false);
					
			}
		}
	}

}
