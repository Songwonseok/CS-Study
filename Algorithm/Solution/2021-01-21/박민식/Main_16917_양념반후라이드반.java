package a2021;

import java.util.*;
import java.io.*;

public class Main_16917_양념반후라이드반 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken()); // 양념 가격
		int B = Integer.parseInt(st.nextToken()); // 후라이드 가격
		int C = Integer.parseInt(st.nextToken()); // 반반 가격
		int X = Integer.parseInt(st.nextToken()); // 양념 최소 갯수
		int Y = Integer.parseInt(st.nextToken()); // 후라이드 최소 갯수
		long answer = 0;
		long anotherAnswer = 0;
		int maxSize = Math.max(X, Y);
		anotherAnswer = 2*C*maxSize;
		
		if(A+B >= C*2) { // 반반 2마리가 개별치킨값 합친거 보다 작거나 같을 때
			if(X>=Y) { // 양념갯수가 더 많을 때
				answer =(C*2)*Y + A*(X-Y);
			} else { // 후라이드 갯수가 더 많을 때
				answer = (C*2)*X + B*(Y-X);
			}
		} else { // 아닐 때
			answer = (A*X) + (B*Y);
		}
		
		System.out.println(Math.min(answer, anotherAnswer));
	}

	/*
		if(X-Y==0) { //양념 후라이드 똑같이 사야할때
			result_chicken = Math.min((C*X)*2, (A*X)+(B*Y));
			System.out.println(result_chicken);
		} else {
			ArrayList<int[]> list = new ArrayList<>();
			list.add(new int [] {A,X});
			list.add(new int [] {B,Y});
			
			// 최소 갯수가 앞에 오게끔 정렬
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
					
				}
			});
			
			long min = list.get(0)[1];
			long max = list.get(1)[1];
			long remain_count = max - min;
			long max_chicken = list.get(1)[0];
			
			result_chicken += ((C*min)*2);
			result_chicken += Math.min((max_chicken*remain_count), (C*2)*remain_count);
			System.out.println(result_chicken);
		}
	*/
}
