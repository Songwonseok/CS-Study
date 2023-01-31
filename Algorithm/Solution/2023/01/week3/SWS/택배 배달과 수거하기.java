class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int length = deliveries.length;
        int dBox = 0;
        int pBox = 0;
        
        for(int i = length - 1; i >= 0; i--) {
            int cnt = 0;
            
            while(dBox <  deliveries[i] || pBox < pickups[i]) {
                dBox += cap;
                pBox += cap;
                cnt++;
            }
            
            dBox -= deliveries[i];
            pBox -= pickups[i];

            answer += (long)((i + 1) * cnt * 2);
        }
            
        
        return answer;
    }
}