package a2021;

import java.util.*;
import java.io.*;

public class Main_10825_국영수 {
	public static class stu implements Comparable<stu>{
		String name;
		int kor;
		int eng;
		int mat;
		
		public stu(String name, int kor, int eng, int mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}

		@Override
		public int compareTo(stu s) {
			if(s.kor == kor) {
				if(eng == s.eng) {
					if(s.mat == mat) {
						return name.compareTo(s.name);
					}
					return s.mat - mat;
				}
				return eng - s.eng;
			}
			return s.kor - kor;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<stu> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int mat = Integer.parseInt(st.nextToken());
			
			pq.offer(new stu(name, kor, eng, mat));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			stu s = pq.poll();
			sb.append(s.name+"\n");
		}
		System.out.println(sb);
	}

}
