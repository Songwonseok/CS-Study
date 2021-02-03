package y2021.m02.d01;

import java.util.ArrayList;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_코테3 {
	public static void main(String[] args) throws Exception {
		int N = 3000000;
		int M = 45675864;
		
		System.out.println(solution(N, M));
	}
	public static ArrayList<Integer> prime;
	public static int solution(int N, int M) {
		int answer=0;
		prime = new ArrayList<>();
		primeNum(N);
		int start = 0;
		int end = 0;
		int sum = 0;
		while(end<prime.size()) {
			if(sum<M) {
				sum+=prime.get(end);
				end++;
			}else if(sum==M) {
				answer++;
				sum+=prime.get(end);
				end++;
			}else {
				sum-=prime.get(start);
				start++;
			}
			if(start==end) {
				break;
			}
		}
		return answer;
	}
	
	private static void primeNum(int N) {
		for(int i=2; i<=N; i++) {
			boolean isPrime = true;
			for(int j=2; j*j<=i; j++) {
				if(i%j == 0) {
					isPrime = false; 
					break; 
					}
				}
			if(isPrime) {
				prime.add(i);
			}
		}
	}
}
