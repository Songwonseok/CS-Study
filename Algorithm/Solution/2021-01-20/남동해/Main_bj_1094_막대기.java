package y2021.m01.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
23
*/

class Main_bj_1094_막대기 {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int X = Integer.parseInt(br.readLine());
    	int count=0;
		for(int i=0;i<7;i++) {
			if(((X>>i)&1)==1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
