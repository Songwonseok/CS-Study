package Programmers.practice;

public class Practice_가장긴팰린드롬 {
	public int getLength(String s, int left, int right) {
		int count = 0;

		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				count += 2;
				left--;
				right++;
			} else {
				break;
			}
		}

		return count;
	}

	public int solution(String s) {
		int answer = 1;

		for (int i = 0; i < s.length() - 1; i++) {
			int length = getLength(s, i - 1, i + 1) + 1;

			if (s.charAt(i) == s.charAt(i + 1)) {
				length = Math.max(length, getLength(s, i, i + 1));
			}

			answer = Math.max(answer, length);
		}

		return answer;
	}

	public static void main(String[] args) {
		Practice_가장긴팰린드롬 test = new Practice_가장긴팰린드롬();
		String s = "a";

		System.out.println(test.solution(s));

	}
}