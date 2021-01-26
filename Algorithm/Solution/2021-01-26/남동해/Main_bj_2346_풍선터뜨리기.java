package y2021.m01.d26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5
3 2 1 -3 -1
 */


class Main_bj_2346_풍선터뜨리기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] balloon = new int[N];
		for(int i=0;i<N;i++) {
			balloon[i]=Integer.parseInt(st.nextToken());
		}
		sb.append(1).append(" ");
		int count = balloon[0];
		int dir =0;
		if(count>0) {
			dir=1;
		}else {
			count=-balloon[0];
			dir=2;
		}
		balloon[0]=0;
		int start = 0;
		for(int i=1;i<N;i++) {
			if(dir==1) {
				while(count>0) {
					start=(start+1)%N;
					if(balloon[start]!=0) {
						count--;
					}
				}
			}else {
				while(count>0) {
					start=(start-1+N)%N;
					if(balloon[start]!=0) {
						count--;
					}
				}
			}
			int temp = balloon[start];
			if(temp>0) {
				count=temp;
				dir=1;
			}else {
				count=-temp;
				dir=2;
			}
			balloon[start]=0;
			sb.append(start+1).append(" ");
		}
		System.out.println(sb.toString());
	}
}