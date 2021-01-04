package baek;

import java.util.*;
import java.io.*;

public class Main_10819_차이를최대로 {
	static boolean[] visit;
	static int N, MAX;
	static int[] permResult, valueArray;
	
	static void getPermutation(int depth) {
		if(depth == N) {
			int sum = 0;
			for(int i=0;i<N-1;i++) {
				sum += Math.abs(permResult[i] - permResult[i+1]); 
			}
			MAX = Math.max(MAX, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				permResult[depth] = valueArray[i];
				getPermutation(depth+1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		MAX = 0;
		valueArray = new int[N];
		permResult = new int[N];
		visit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			valueArray[i] = Integer.parseInt(st.nextToken());
		
		getPermutation(0);
		
		System.out.println(MAX);
	}

}
