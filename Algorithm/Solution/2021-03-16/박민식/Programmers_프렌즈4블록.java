package algo_study;

import java.util.*;

public class Programmers_프렌즈4블록 {
	static boolean [][] bomb;
	
	public static void main(String[] args) {
//		int m = 4;
//		int n = 5;
//		String [] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		
		int m = 6;
		int n = 6;
		String [] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m,n,board));
	}

	public static int solution(int m, int n, String [] board) {
		int answer = 0;
		
		char [][] blockBoard = new char [m][n];
		for(int i=0;i<m;i++) {
			blockBoard[i] = board[i].toCharArray();
		}
		boolean peace = false;
		
		while(!peace) { // true 없어지는 블록 없음
			int findCount = 0;
			bomb = new boolean [m][n];
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					findCount += findBlock(i,j,m,n,blockBoard);
				}
			}
			if(findCount==0) peace = true;
			if(peace) break;
			answer += deleteBlock(m,n,blockBoard);
			moveBlock(m,n,blockBoard);
		}
		
		return answer;
	}
	
	public static int whatElement(int x, int j, char [][] blockBoard) {
		int answer = -1;
		
		for(int i=x;i>=0;i--) {
			if(blockBoard[i][j] != '0') {
				answer = i;
				return answer;
			}
		}
		return answer;
	}
	
	public static void moveBlock(int m, int n, char [][] blockBoard) {
		for(int j=0;j<n;j++) { // 열순서대로 행 역순으로 찾아보며 '0'인 부분에서 위에 있는 원소 가져옴
			for(int i=m-1;i>=0;i--) {
				if(blockBoard[i][j] == '0') {
					int tmp = whatElement(i,j,blockBoard);
					if(tmp != -1) {
						blockBoard[i][j] = blockBoard[tmp][j];
						blockBoard[tmp][j] = '0';
					}
				}
			}
		}
		
		for(int i=0;i<m;i++) { // 공백처리
			for(int j=0;j<n;j++) {
				if(blockBoard[i][j]=='0') blockBoard[i][j] = '-';
			}
		}
	}
	
	public static int deleteBlock(int m, int n, char [][] blockBoard) {
		int answer = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(bomb[i][j]) { 
					answer++;
					blockBoard[i][j] = '0';
				}
			}
		}
		return answer;
	}
	
	public static int findBlock(int x, int y, int m, int n, char [][] blockBoard) {
		// 우측, 아래, 우측아래
		if(blockBoard[x][y] == '-') return 0;
		int [] di = {0,1,1}, dj = {1,0,1};
		char c = blockBoard[x][y];
		for(int d=0;d<3;d++) {
			int ni = x + di[d];
			int nj = y + dj[d];
			if(ni<0 || nj<0 || ni>m-1 || nj>n-1 || blockBoard[ni][nj] != c) return 0;
		}
		
		bomb[x][y] = true;
		for(int d=0;d<3;d++) {
			int ni = x + di[d];
			int nj = y + dj[d];
			bomb[ni][nj] = true;
		}
		return 1;
	}
}
