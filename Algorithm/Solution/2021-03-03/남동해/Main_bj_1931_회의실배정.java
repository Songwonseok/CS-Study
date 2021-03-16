package y2021.m03.d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
 */


class Main_bj_1931_회의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			table[i][0]=Integer.parseInt(st.nextToken());
			table[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(table, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[1];
				}
				return o1[1]-o2[1];
			}
		});
		int answer = 1;
		int curr = table[0][1];
		for(int i=1;i<N;i++) {
			if(table[i][0]>=curr) {
				curr=table[i][1];
				answer++;
			}
		}
		System.out.println(answer);
	}
}