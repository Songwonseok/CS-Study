package a2021;

import java.util.*;
import java.io.*;

public class Main_1654_랜선자르기 {
	static int [] line;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		line = new int [K];
		
		for(int i=0;i<K;i++) 
			line[i] = Integer.parseInt(br.readLine());
		Arrays.sort(line);
		
		long max = line[K-1];
		long min = 1;
		long mid = (min+max) / 2;
		
		while(min <= max) {
			long lineCount = 0;
			
			// 중간값으로 배열의 모든 원소를 나눈값을 계속 더해줌, 잘라낸 랜선 갯수
			for(int i=0;i<K;i++) 
				lineCount += line[i] / mid;
			
			// 잘라낸 랜선 갯수가 구하고자 하는 값보다 크거나 같을 때 min값 증가
			if(lineCount >= N) 
				min = mid + 1;
			else // 아니라면 max값 감소
				max = mid - 1;
			
			mid = (min+max) / 2;
		}
		
		System.out.println(max);
	}

}
