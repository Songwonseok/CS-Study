package baek;

import java.io.*;
import java.util.*;

public class Main_1392_노래악보 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] sheets = new int[N];
		int[] times = new int[N+1];
		
		for(int i=0;i<N;i++) {
			sheets[i] = Integer.parseInt(br.readLine());
			times[i+1] = times[i] + sheets[i];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<Q;i++) {
			int question = Integer.parseInt(br.readLine());
			for(int idx=1;idx<times.length;idx++) {
				if(question < times[idx]) {
					sb.append(idx).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
