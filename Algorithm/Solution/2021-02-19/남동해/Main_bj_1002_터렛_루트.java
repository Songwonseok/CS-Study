package y2021.m02.d19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5
1 1 1 1 1 1 
 */

class Main_bj_1002_터렛_루트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			double d1=Integer.parseInt(st.nextToken());
			double d2=Integer.parseInt(st.nextToken());
			double r1=Integer.parseInt(st.nextToken());
			d1-=Integer.parseInt(st.nextToken());
			d2-=Integer.parseInt(st.nextToken());
			double r2=Integer.parseInt(st.nextToken());
			double d = Math.sqrt(Math.pow(d1, 2) + Math.pow(d2, 2));
			if(d==0&&r1==r2) {
				sb.append(-1).append("\n");
				continue;
			}
			if(r1+r2<d||Math.abs(r1-r2)>d) {
				sb.append(0).append("\n");
			}else if(r1+r2==d||Math.abs(r1-r2)==d) {
				sb.append(1).append("\n");
			}else if(Math.abs(r1-r2)<d&&d<r1+r2) {
				sb.append(2).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}