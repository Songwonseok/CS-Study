package baek;

import java.io.*;
import java.util.*;

public class Main_2630_색종이만들기 {
	static int N, white, blue;
	static int[][] paper;
	
	
	public static boolean checkOne(int x, int y, int size, int color) {
		
		for(int i=x;i<x+size;i++) {
			for(int j = y; j<y+size;j++) {
				if(paper[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void partition(int startX, int startY, int size) {
		int color = paper[startX][startY];
		
		if(size == 1) {
			if(color == 1) 
				blue++;
			else 
				white++;
			return;
		}
		
		boolean isOne = checkOne(startX,startY,size, color);
		
		if(isOne) {
			if(color == 1) 
				blue++;
			else 
				white++;
			return;
		}
		
		for(int x = startX; x<startX + size; x += size/2) {
			for(int y = startY; y< startY + size; y += size/2) {
				partition(x,y,size/2);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		white = 0;
		blue = 0;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0,0,N);
		
		System.out.println(white + "\n" + blue);
	}

}
