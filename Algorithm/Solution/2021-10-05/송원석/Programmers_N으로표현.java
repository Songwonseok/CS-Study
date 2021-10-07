package Programmers.practice;

import java.util.HashSet;

public class Programmers_N으로표현 {

	public int solution(int N, int number) {
		HashSet<Integer>[] dp = new HashSet[9];

		for (int i = 1; i <= 8; i++) {
			dp[i] = new HashSet<>();
		}

		for (int i = 1; i <= 8; i++) {
			String repeatedN = Integer.toString(N).repeat(i);

			dp[i].add(Integer.parseInt(repeatedN));

			for (int j = 1; j < i; j++) {
				HashSet<Integer> left = dp[j];
				HashSet<Integer> right = dp[i - j];

				for(int num1 : left) {
					for(int num2 : right) {
						dp[i].add(num1 + num2));
						dp[i].add(num1 - num2));
						dp[i].add(num1 * num2));
						if(num2 != 0)
							dp[i].add(num1 / num2));
					}
				}
			}

			if (dp[i].contains(number)) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

	}
}
