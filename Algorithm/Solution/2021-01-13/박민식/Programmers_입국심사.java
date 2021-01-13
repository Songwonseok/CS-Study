package a2021;

import java.util.*;

public class Programmers_입국심사 {

	public static void main(String[] args) {
		int n = 6;
		int [] times = {7,10};
		System.out.println(solution(n,times));
	}

	public static long solution(int n, int [] times) {
		long answer = 0;
		Arrays.sort(times);
		long left = 1;
		long right = (long)times[times.length-1] * n;
		long mid = 0;
		answer = right;
		while(left<=right) {
			mid = (left + right) / 2;
			long curr = 0;
			for(int i=0;i<times.length;i++) 
				curr += mid / times[i];
			
			if(curr >= n) {
				right = mid - 1;
				if(answer > mid)
					answer = mid;
			} else {
				left = mid + 1;
			}
			
		}
		return answer;
	}
	
}
