package Programmers.Scatterlab;

import java.util.ArrayList;

public class Solution3 {
	
	public static ArrayList<Integer> getPrime(int N){
		boolean[] number = new boolean[N+1];
		ArrayList<Integer> prime = new ArrayList<Integer>();
		
		number[0] = true;
		number[1] = true;
		for(int i=2;i*i <= N; i++) {
			if(!number[i]) {
				for(int j=2; i*j <= N;j++) {
					number[j*i] = true;
				}
			}
		}
		for(int i=0;i<=N;i++) {
			if(!number[i])
				prime.add(i);
		}
		return prime;
	}
	
	
	public static int solution(int N, int M) {
		ArrayList<Integer> prime = getPrime(N);
		int answer = 0;
		int left = 0;
		int right = 0;
		int sum = prime.get(0);
		int size = prime.size();
		
		while(left <= right) {
			if(sum == M) {
				answer++;
			}
			
			if(sum < M) {
				if(right + 1 == size) {
					break;
				}
				sum += prime.get(++right);
			}else {
				sum -= prime.get(left++);
			}
		}
		
        return answer;
    }

	public static void main(String[] args) {
		int a = solution(3000000,1000000000);
		System.out.println(a);

	}

}
