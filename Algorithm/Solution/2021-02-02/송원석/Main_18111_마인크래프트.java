package baek;

import java.io.*;
import java.util.*;

public class Main_18111_마인크래프트 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int INF = Integer.MAX_VALUE;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] ground = new int[N*M];
		int minHeight = INF;
		int maxHeight = 0;
		
		int minTime = INF;
		int highest = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=i*M;j<M*(i+1);j++) {
				ground[j] = Integer.parseInt(st.nextToken());
				minHeight = Math.min(minHeight, ground[j]);
				maxHeight = Math.max(maxHeight, ground[j]);
			}
		}
		
		for(int i=minHeight; i<= maxHeight;i++) {
			int over = 0;
			int lack = 0;
			
			for(int height : ground) {
				if(height > i) {
					over += height - i;
				}else if(height < i) {
					lack += i - height;
				}
			}
			
			if(over + B >= lack) {
				int time = lack + over*2;
				if(time <= minTime) {
					minTime = time;
					highest = i;
				}
			}
		}
		
		System.out.println(minTime + " " + highest);
	}

}
