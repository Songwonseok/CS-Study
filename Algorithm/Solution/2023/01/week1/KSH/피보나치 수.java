class Solution {
    //static int answer;
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        int a = 0;
        int b = 1;
        while(true){
            // (a%c+b%c)%c
            if(n == cnt) break;
            int temp = a+b;
            a = b%1234567;
            b = temp%1234567;
            cnt++;
        }
        System.out.print(a+"     "+b);
        answer = a;
        return answer;
    }

}