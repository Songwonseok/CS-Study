public class 가장긴팰린드롬 {

    public static void main(String[] args) {
        가장긴팰린드롬 num1 = new 가장긴팰린드롬();
        System.out.println(num1.solution("abcdcba"
        ));
    }

    public int solution(String s) {
        int answer = 1;

        for (int i = s.length(); i >= 2; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i + j > s.length()) break;

                boolean flag = true;
                for (int k = 0; k < i/2; k++) {
                    if(s.charAt(j+k) != s.charAt(i+j-k-1)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) return i;
            }
        }
        return answer;
    }

}
