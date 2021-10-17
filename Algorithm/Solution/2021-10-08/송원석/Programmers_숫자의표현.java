package Programmers.practice;

public class Programmers_숫자의표현 {

	public int solution(int n) {
		int answer = 0;
		int left = 0;
		int right = 1;

		int sum = 1;

		while (left != n) {
			if (sum <= n) {
				sum += ++right;
			} else if (sum > n) {
				sum -= ++left;
			}

			if (sum == n) {
				answer++;
			}

		}

		return answer;
	}
}