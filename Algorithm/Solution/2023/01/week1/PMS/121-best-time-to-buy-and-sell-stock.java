class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0;i<len;i++)
        {
            int price = prices[i];
            if(price < min) min = price;

            if(price - min > result) result = price - min;
        }
        return result;
    }
}
