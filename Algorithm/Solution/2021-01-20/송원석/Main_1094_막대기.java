package baek;

import java.io.*;

public class Main_1094_막대기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		
		for(int i=0;i<7;i++) {
			if((N & (1<<i)) > 0) {
				count++;
			}
		}
		System.out.println(count);
	}

}
