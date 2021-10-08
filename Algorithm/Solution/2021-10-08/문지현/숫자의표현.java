public class 숫자의표현 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;

        int left = 1;
        int right = 1;
        int sum = 1;

        while(left <= right) {
            if(sum > n) {
                sum -= left;
                left++;
            }else if(sum < n) {
                right++;
                sum += right;
            }else {
                answer++;
                sum -= left;
                left++;
            }
        }

        return answer;
    }
}
