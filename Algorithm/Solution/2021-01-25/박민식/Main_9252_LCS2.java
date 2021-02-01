package a2021;

import java.io.*;
import java.util.*;

public class Main_9252_LCS2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String first = br.readLine();
		String second = br.readLine();

		int firstSize = first.length();
		int secondSize = second.length();

		int[][] board = new int[firstSize + 1][secondSize + 1];

		for (int i = 1; i < firstSize + 1; i++) {
			for (int j = 1; j < secondSize + 1; j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1)) {
					board[i][j] = board[i - 1][j - 1] + 1;
				} else {
					board[i][j] = Math.max(board[i - 1][j], board[i][j - 1]);
				}
			}
		}

		int r = first.length();
		int c = second.length();
		String result = "";
		
		while(r>0 && c>0) {
			if(board[r-1][c] == board[r][c]) // 위와 같을 때 
				r--;
			else if(board[r][c] == board[r][c-1]) // 왼쪽과 같을 때
				c--;
			else { // 왼쪽 대각선 위와 같을 때
				result = first.charAt(r-1) + result;
				r--;
				c--;
			}
			
			if( !(r>0 && c>0) ) {
				if(board[r][c] != 0) {
					result = first.charAt(r-1) + result;
					if(r>=0)
						r--;
					if(c>=0)
						c--;
					if(r<0 || c<0) break;
				}
			}
		}
		
		System.out.println(board[firstSize][secondSize]);
		System.out.println(result);
	}

}
