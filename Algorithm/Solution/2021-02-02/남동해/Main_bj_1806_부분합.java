package y2021.m02.d02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
10 30
5 1 3 5 10 7 4 9 2 30
 */


class Main_bj_1806_부분합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			data[i]=Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;
		while(start<=end) {
			if(sum>=S) {
				if(end-start<min)
					min=end-start;
				sum-=data[start++];
			}else {
				if(end>=N)
					break;
				sum+=data[end++];
			}
		}
		if(min==Integer.MAX_VALUE)
			min=0;

		System.out.println(min);
	}
}