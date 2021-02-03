package y2021.m02.d02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3 4 99
0 0 0 0
0 0 0 0
0 0 0 1
 */


class Main_bj_18111_마인크래프트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] block = new int[N*M];
		int min = 257;
		int max = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				block[i*M+j]=Integer.parseInt(st.nextToken());
				if(block[i*M+j]<min) {
					min=block[i*M+j];
				}
				if(block[i*M+j]>max) {
					max=block[i*M+j];
				}
			}
		}
		int mintime = Integer.MAX_VALUE;
		int high = 0;
		Arrays.sort(block);
		here:for(int i=min;i<=max;i++) {
			int time = 0;
			int blockcount=B;
			for(int j=block.length-1;j>=0;j--) {
				if(block[j]>i) {
					time+=(block[j]-i)*2;
					blockcount+=(block[j]-i);
				}else if(block[j]<i) {
					time+=(i-block[j]);
					blockcount-=(i-block[j]);
					if(blockcount<0) {
						continue here;
					}
				}
			}
			if(mintime>=time) {
				mintime=time;
				high=i;
			}
		}
		System.out.println(mintime + " " + high);
	}
}