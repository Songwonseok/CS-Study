class Solution {
    public int maxProfit(int[] prices) {
        
        int minValue = Integer.MAX_VALUE;
        int answer = 0;
        
        for(int price : prices) {
            minValue = Math.min(minValue, price);
            
            answer = Math.max(price - minValue, answer);
        }
        
        return answer;
    }
}