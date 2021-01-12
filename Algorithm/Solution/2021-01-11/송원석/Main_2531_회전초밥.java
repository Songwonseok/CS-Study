package baek;

import java.util.*;
import java.io.*;

public class Main_2531_회전초밥 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int[] sushi = new int[N];
		int[] eaten = new int[d+1];
		
		for(int i=0;i<N;i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int left = 0;
		int right = k-1;
		int count = 0;
		
		for(int i=0;i<=right;i++) {
			if(eaten[sushi[i]] == 0) {
				count++;
			}
			eaten[sushi[i]]++;
		}
		
		int max = eaten[c] == 0 ? count+1 : count;
		
		for(int i=0;i<N-1;i++) {
			
			if(--eaten[sushi[left]] == 0)
				count--;
			
			
			left = (left+1)%N;
			right = (right+1)%N;
			
			if(eaten[sushi[right]]++ == 0)
				count++;
			
			if(eaten[c] == 0) {
				max = Math.max(max, count+1);
			}else {
				max = Math.max(max, count);
			}
		}
		
		System.out.println(max);
	}

}
