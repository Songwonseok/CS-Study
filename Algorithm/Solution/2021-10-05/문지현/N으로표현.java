public class N으로표현 {

    public static void main(String[] args) {
        N으로표현 num1 = new N으로표현();
        System.out.println(num1.solution(
                2,12
        ));
    }

    int min = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        solve(N,0,0,number);
        if(min>8) return -1;
        return min;
    }

    public void solve(int N, int count, int now, int number){
        if(count > 8) {
            return;
        }
        if(now == number){
            if(min>count) min = count;
            return;
        }
        int temp = N;
        for(int i=0; i<8-count; i++){
            solve(N, count+i+1, now+temp, number);
            solve(N, count+i+1, now-temp, number);
            solve(N, count+i+1, now/temp, number);
            solve(N, count+i+1, now*temp, number);
            temp = temp*10+N;
        }
    }
}
