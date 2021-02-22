package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17609_회문 {
	
	public static int check(String str, boolean removed, int left, int right) {
		if(left > right) {
			if(removed) return 1;
			return 0;
		}
		
		if(str.charAt(left) == str.charAt(right)) {
			return check(str,removed ,left+1, right-1);
		}else {
			if(!removed) {
				return Math.min(check(str, !removed ,left+1, right), check(str, !removed ,left, right-1));
			}else {
				return 2;
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine().trim();
			int result = check(str, false, 0, str.length()-1);
			sb.append(result+"\n");
		}
		
		System.out.println(sb);
	}

}
