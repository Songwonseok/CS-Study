package y2021.m02.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
7
abba
summuus
xabba
xabbay
comcom
comwwmoc
comwwtmoc
 */

class Main_bj_17609_회문 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			String input = br.readLine();
			sb.append(palindrome(input,0,input.length()-1,false,0)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int palindrome(String input, int start, int end, boolean esc, int t) {
		if(start>=end) {
			return t;
		}
		if(input.charAt(start)==input.charAt(end)) {
			return palindrome(input, start+1, end-1, esc,t);
		}else {
			if(!esc) {
				return Math.min(palindrome(input, start,end-1,true,1), palindrome(input, start+1,end,true,1));
			}else {
				return 2;
			}
		}
	}
}