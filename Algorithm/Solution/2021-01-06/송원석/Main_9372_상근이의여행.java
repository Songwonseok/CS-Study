package baek;

import java.io.*;
import java.util.*;

public class Main_9372_상근이의여행 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<M;i++)
				br.readLine();
			
			sb.append(N-1).append("\n");
		}
		System.out.println(sb);
	}

}
