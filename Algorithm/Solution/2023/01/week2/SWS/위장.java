import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap();
        
        for(String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 1) + 1); // 안입는 경우도 있어서 default: 1
        }
        
        int answer = 1;
        
        for(String key: map.keySet()) {
           answer *= map.get(key); 
        }
        
        answer--; // 아무것도 안입은 경우는 제외
        
        return answer;
    }
}