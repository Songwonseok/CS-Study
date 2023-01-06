import java.util.*;

class Solution {
    int[] dp;
     
    public int getFibonacci(int n) {
        if(dp[n] != -1) {
            return dp[n];
        }
        
        dp[n] = (getFibonacci(n-1) + getFibonacci(n-2)) % 1234567;
        
        return dp[n];
    }
    
    public int solution(int n) {       
        dp = new int[100001];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        
        
        return getFibonacci(n);
    }
}