package y2021.m02.d19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
7 5 5 4 9
1 1 1 1 1
2 3 3 2 10
 */

class Main_bj_2303_숫자게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int winner=0;
		int flag=0;
		int[] card = new int[5];
		for(int num=0;num<N;num++) {
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<5;i++) {
				card[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<5;i++) {
				for(int j=i+1;j<5;j++) {
					for(int k=j+1;k<5;k++) {
						int curr = card[i]+card[j]+card[k];
						if(curr%10>=max) {
							max=curr%10;
						}
					}
				}
			}
			if(max>=flag) {
				flag=max;
				winner=num;
			}
		}
		System.out.println(winner+1);
	}
}