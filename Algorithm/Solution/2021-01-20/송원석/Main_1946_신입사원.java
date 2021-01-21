package baek;

import java.io.*;
import java.util.*;

public class Main_1946_신입사원 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] interview = new int[N+1];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int document = Integer.parseInt(st.nextToken());
				interview[document] = Integer.parseInt(st.nextToken());
			}
			
			
			int count = 1;
			int worst = interview[1];
			
			for(int i=2;i<=N;i++) {
				if(worst > interview[i]) {
					worst = interview[i];
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
