import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        HashMap<String, String> map = new HashMap<>();
        int N = phone_book.length;
        
        for(int i=0;i<N;i++) 
        {
            String tempStr = phone_book[i];
            map.put(tempStr, tempStr);
        }
        
        
        for(int i=0;i<N;i++)
        {
            String s = phone_book[i];
            for(int j=0;j<s.length();j++)
            {
                if(map.containsKey(s.substring(0,j)))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}