package a2021;

import java.util.*;
import java.io.*;

public class Main_9251_LCS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String first = br.readLine();
		String second = br.readLine();
		
		int firstSize = first.length();
		int secondSize = second.length();
		
		int [][] board = new int [firstSize+1][secondSize+1];
		
		for(int i=1;i<firstSize+1;i++) {
			for(int j=1;j<secondSize+1;j++) {
				if(first.charAt(i-1) == second.charAt(j-1)) {
					board[i][j] = board[i-1][j-1] + 1;
				} else {
					board[i][j] = Math.max(board[i-1][j], board[i][j-1]);
				}
			}
		}
		
		System.out.println(board[firstSize][secondSize]);
	}

}
