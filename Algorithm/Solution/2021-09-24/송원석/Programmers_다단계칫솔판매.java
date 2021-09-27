package Programmers.practice;

import java.util.Arrays;
import java.util.HashMap;

public class Programmers_다단계칫솔판매 {
	class Organizer {
		int amount;
		Organizer referrer;

		void distributeIncome(int income) {
			int incentive = income / 10;

			if (incentive == 0) {
				amount += income;
				return;
			}

			amount += income - incentive;

			if (referrer != null) {
				referrer.distributeIncome(incentive);
			}
		}
	}

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Organizer[] answer = new Organizer[enroll.length];
		HashMap<String, Organizer> map = new HashMap<>();

		// HashMap과 마지막 return 값을 위한 answer에 조직원 저장
		for (int idx = 0; idx < enroll.length; idx++) {
			Organizer organizer = new Organizer();
			map.put(enroll[idx], organizer);
			answer[idx] = organizer;
		}

		// 추천인 업데이트, 추천인이 없으면 referrer은 null
		for (int idx = 0; idx < referral.length; idx++) {
			Organizer organizer = map.get(enroll[idx]);

			String referrer = referral[idx];

			if (!referrer.equals("-")) {
				organizer.referrer = map.get(referrer);
			}
		}

		// 수익 분배
		for (int i = 0; i < seller.length; i++) {
			map.get(seller[i]).distributeIncome(amount[i] * 100);
		}

		return Arrays.stream(answer).mapToInt(o -> o.amount).toArray();
	}

	public static void main(String[] args) {
		Programmers_다단계칫솔판매 test = new Programmers_다단계칫솔판매();
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};

		System.out.println(Arrays.toString(test.solution(enroll, referral, seller, amount)));
	}
}
