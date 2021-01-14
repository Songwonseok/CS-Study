package baek;

import java.io.*;
import java.util.*;

public class Main_11403_경로찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] graph = new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					graph[i][j] = true;
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(graph[i][k] && graph[k][j])
						graph[i][j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(graph[i][j])
					sb.append(1).append(" ");
				else
					sb.append(0).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
