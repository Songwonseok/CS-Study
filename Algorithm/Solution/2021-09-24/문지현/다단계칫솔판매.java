import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {

    public static void main(String[] args) {
        다단계칫솔판매 num1 = new 다단계칫솔판매();
        System.out.println(Arrays.toString(num1.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
        )));
    }

    Map<String, Integer> ans;
    Map<String, String> rel;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int [enroll.length];
        rel = new HashMap<>();
        ans = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            String child = enroll[i];
            String parent = referral[i];
            ans.put(enroll[i], 0);
            rel.put(child, parent);
        }

        for (int i = 0; i < seller.length; i++) {
            solv(seller[i], amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = ans.get(enroll[i]);
        }

        return answer;
    }

    private void solv(String seller, int amount) {
        if (seller.equals("-")) return;

        double up = amount * 0.1;
        int upMoney = (int) up;
        if (up < 1) {
            ans.put(seller, ans.get(seller) + amount);
            return;
        }

        int mine = amount - upMoney;
        ans.put(seller, ans.get(seller) + mine);

        solv(rel.get(seller), upMoney);
    }

}
