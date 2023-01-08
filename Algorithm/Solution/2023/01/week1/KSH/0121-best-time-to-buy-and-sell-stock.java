import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int max_benefits = 0; 
        int min_benefits = prices[0];
        for(int i=0; i<prices.length;i++){
            //최소에서 사서 최대에서 팔아야함
            //완탐은 터짐 DP
            //현재 인덱스에서 살수있는 최소가격이랑
            //현재 팔았을 때 가격차이와 지금까지 최대 이익 가격을 비교한다.
            int now_benefits = prices[i] - min_benefits; // 현재 차익 구하기
            min_benefits = Math.min(prices[i], min_benefits); // 현재 기준 최소 가격
            max_benefits = Math.max(max_benefits, now_benefits); // 최대 차익
        }
        return max_benefits;
    }
}