package a2021;

import java.util.*;
import java.io.*;

public class Main_2630_색종이만들기 {
	static int N, blue, white;
	static int [][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int [N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		blue = 0;
		white = 0;
		
		isDivide(N,0,0);
		System.out.println(white+"\n"+blue);
	}
	public static boolean isColorSame(int n, int row, int col) {
		int whatColor = board[row][col];
		
		for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++) {
				if(whatColor != board[i][j]) 
					return false;
			}
		}
		return true;
	}
	public static void isDivide(int n, int row, int col) {
		if(isColorSame(n, row, col)) {
			if(board[row][col] == 1) blue++;
			else white++;
			return;
		}
		
		isDivide(n/2, row, col); // 1사분면
		isDivide(n/2, row, col + n/2); // 2사분면
		isDivide(n/2, row + n/2, col); // 3사분면
		isDivide(n/2, row + n/2, col+ n/2); // 4사분면
		
	}

}
