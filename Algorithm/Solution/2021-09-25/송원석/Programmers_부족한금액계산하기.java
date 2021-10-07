package Programmers.weekly;

public class Programmers_부족한금액계산하기 {
	public long solution(int price, int money, int count) {
		long N = count;

		long total = N * (2 * price + (N - 1) * price) / 2;

		if(total <= money) {
			return 0;
		}

		return total - money;
	}

	public static void main(String[] args) {

	}
}
