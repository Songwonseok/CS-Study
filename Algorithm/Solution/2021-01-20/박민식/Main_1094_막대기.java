package a2021;

import java.io.*;
import java.util.*;

public class Main_1094_막대기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
//		while문으로 나머지가 1인 경우 비트마스크 방식으로 검출한 같은방식과 같이 풀이한 것
		
//		while(N>0) {
//			if(N%2==1)
//				count++;
//			N /= 2;
//		}
//		System.out.println(count);
		
		// 비트마스크
		for(int i=0;i<7;i++) {
			// 1<<i : 1(2), 10(2), 100(2) .... , 1000000(2)
			// 		  1(10), 2(10), .....          6(10)
			if((1<<i & N) > 0)
				count++;
		}
		System.out.println(count);
	}
}
