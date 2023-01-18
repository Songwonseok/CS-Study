import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> clothMap = new HashMap<>();
        
        int len = clothes.length;
        
        for(int i=0;i<len;i++)
        {
            String clothName = clothes[i][0]; // 필요없는듯?
            String clothKind = clothes[i][1];
            
            if(clothMap.get(clothKind) == null)
                clothMap.put(clothKind, 1);
            else
                clothMap.put(clothKind, clothMap.get(clothKind) + 1);
        }
        
        int mult = 1;
        for(String clothKind: clothMap.keySet())
        {
            // 사실 답을 봤는데 위에 코드는 다 똑같지만 
            // 여기서 mult에 곱해줄 때 +1 을 해주는 이유가
            // 스파이가 옷을 안입을 경우가 있으므로 +1을 해준다는데
            // 이건 도저히 이해가 불가...
            mult *= (clothMap.get(clothKind) + 1);
        }
        answer += mult;
        
        return --answer;
    }
}