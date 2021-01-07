package algo_study;

import java.util.*;
import java.io.*;

public class Main_1057_토너먼트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		int count = 0;
		
		while(kim!=lim) {
			if(kim%2==0) 
				kim = kim/2;
			else
				kim = kim/2 + 1;
			if(lim%2==0)
				lim = lim/2;
			else
				lim = lim/2 + 1;
			count++;
		}
		
		System.out.println(count);
	}

}
