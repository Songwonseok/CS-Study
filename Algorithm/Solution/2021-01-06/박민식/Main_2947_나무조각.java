package algo_study;

import java.util.*;
import java.io.*;

public class Main_2947_나무조각 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] trees = new int [5];
		
		for(int i=0;i<5;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		
		while(true) {
			if(trees[0]==1 && trees[1]==2 && trees[2]==3 && trees[3]==4 && trees[4]==5) {
				break;
			}
			
			for(int i=0;i<4;i++) {
				if(trees[i] > trees[i+1]) {
					int temp = trees[i];
					trees[i] = trees[i+1];
					trees[i+1] = temp;
					print(trees);
				}
			}
			
		}
	} // end of main

	public static void print(int [] trees) {
		for(int i=0;i<5;i++)
			System.out.print(trees[i]+" ");
		System.out.println();
	}
	
}
