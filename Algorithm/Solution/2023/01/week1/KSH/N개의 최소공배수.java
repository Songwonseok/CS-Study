class Solution {
    public int solution(int[] arr) {
        
        int answer = 0;
        int temp = arr[0];
        for(int i=1; i<arr.length; i++){
            temp = lcm(temp, arr[i]);
        }
        

        return temp;
    }
    
    static int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    
    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}