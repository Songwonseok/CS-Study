public class 부족한금액계산하기 {

    public static void main(String[] args) {
        부족한금액계산하기 num1 = new 부족한금액계산하기();
        System.out.println(num1.solution(
                3, 20, 4
        ));
    }

    public long solution(int price, int money, int count) {
        long answer;
        long fee = count * (price + (long) count * price) / 2;
        answer = fee - money;
        if (answer <= 0) return 0;
        return answer;
    }
    /**
     *  n(a+l) / 2
     */

}
