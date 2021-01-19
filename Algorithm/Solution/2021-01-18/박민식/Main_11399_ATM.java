package a2021;

import java.util.*;
import java.io.*;

public class Main_11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] time = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			time[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(time);
		
		int result = time[0];
		
		for(int i=0;i<N-1;i++) {
			time[i+1] = time[i]+time[i+1];
			result+=time[i+1];
		}
		
		System.out.println(result);
	}

}
