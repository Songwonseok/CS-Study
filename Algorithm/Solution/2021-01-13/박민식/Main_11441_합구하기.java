package a2021;

import java.util.*;
import java.io.*;

public class Main_11441_합구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] num = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			if(i==0)
				num[i] = Integer.parseInt(st.nextToken());
			else
				num[i] = num[i-1] + Integer.parseInt(st.nextToken());
				
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			if(s == 0) sb.append(num[e]+"\n");
			else sb.append(num[e] - num[s-1]+"\n");
		}
		System.out.println(sb);
	}
}
