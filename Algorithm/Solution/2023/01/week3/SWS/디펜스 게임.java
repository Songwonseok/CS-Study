import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int finalRound = enemy.length;
        
        if(finalRound <= k) {
            return finalRound;
        }    
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for(int i = 0; i < finalRound; i++) {
            pq.add(enemy[i]);
            
            if(n >= enemy[i]) {
                n -= enemy[i];
                continue;
             }
            
            if(k == 0) {
                return i;
            }
            
            n += pq.poll();
            k--;
            
            if(n < enemy[i]) {
                return i;
            }
            
            n -= enemy[i];
        }
        
        
        return finalRound;
    }
}