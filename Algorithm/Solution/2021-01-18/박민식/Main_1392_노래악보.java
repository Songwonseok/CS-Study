package a2021;

import java.util.*;
import java.io.*;

public class Main_1392_노래악보 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int [] note = new int [N];
		for(int i=0;i<N;i++) 
			note[i] = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> musicStudy = new ArrayList<>();
		int notePage = 1;
		int idx = 0;
		while(idx < N) {
			musicStudy.add(notePage);
			note[idx]--;
			if(note[idx]==0) {
				notePage++;
				idx++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<Q;i++) 
			sb.append(musicStudy.get(Integer.parseInt(br.readLine()))+"\n");
		
		System.out.println(sb);
	}
}
