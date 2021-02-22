package baek;

import java.io.*;
import java.util.*;

public class Main_2303_숫자게임 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int winner = 0;
		int max = 0;
		
		for(int p=1;p<=N;p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] card = new int[5];
			
			for(int i=0;i<5;i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int f = 0; f<3;f++) {
				for(int s = f+1; s<4;s++) {
					for(int t = s+1; t<5;t++) {
						int sum = card[f] + card[s] + card[t];
						if(sum%10 >= max) {
							winner = p;
							max = sum%10;
						}
					}
				}
			}
		}
		System.out.println(winner);
	}

}
