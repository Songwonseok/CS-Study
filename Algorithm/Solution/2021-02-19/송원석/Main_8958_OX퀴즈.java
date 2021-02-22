package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8958_OX퀴즈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		
		for(int tc=0;tc<N;tc++) {
			String answer = br.readLine();
			int score = 0;
			int offset = 1;
			for(int i=0;i<answer.length();i++) {
				if(answer.charAt(i) == 'X') {
					offset = 1;
				}else {
					score += offset++;
				}
			}
			sb.append(score+"\n");
		}
		System.out.println(sb);
	}

}
