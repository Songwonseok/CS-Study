package baek;

import java.io.*;
import java.util.*;

public class Main_11441_합구하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i] += arr[i-1];
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(arr[end] - arr[start-1]).append("\n");
		}
		
		System.out.println(sb);
	}

}
