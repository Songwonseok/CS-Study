package y2021.m02.d19;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
 */

class Main_bj_8958_OX퀴즈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			int counter=0;
			for(int j=0;j<input.length();j++) {
				if(input.charAt(j)=='O') {
					counter++;
					answer+=counter;
				}else {
					counter=0;
				}
			}
			sb.append(answer).append("\n");
			answer=0;
		}
		System.out.println(sb.toString());
	}
}