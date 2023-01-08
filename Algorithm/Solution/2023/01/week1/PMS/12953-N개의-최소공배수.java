class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int len = arr.length;
        
        int gcd = GCD(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;
        
        for(int i=2;i<len;i++)
        {
            gcd = GCD(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        
        answer = lcm;
        
        return answer;
    }
    
    public int GCD(int i, int j)
    {
        if(i%j == 0) return j;
        return GCD(j, i%j);
    }
}
