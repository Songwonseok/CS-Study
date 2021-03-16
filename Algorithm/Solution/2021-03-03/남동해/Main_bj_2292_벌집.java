package y2021.m03.d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
13
 */


class Main_bj_2292_벌집 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int curr = 1;
		if(N==1) {
			System.out.println(1);
		}else {
			for(int i=0;i<N;i++) {
				if(N>curr&&N<=curr+i*6) {
					System.out.println(i+1);
					break;
				}
				curr=curr+i*6;
			}
		}
	}
}