class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sLen = s.length();
        int result = 0;

        for(int i=0;i<sLen;i++)
        {
            char c = s.charAt(i);
            boolean newNumFlag = false;
            if( i<sLen-1 && (c == 'I' || c == 'X' || c == 'C') )
            {
                if(c == 'I')
                {
                    char nextC = s.charAt(i+1);
                    if(nextC == 'V') 
                    {
                        result += 4;
                        i++;
                        continue;
                    }
                    else if(nextC == 'X')
                    {
                        result += 9;
                        i++;
                        continue;
                    }
                }
                else if(c == 'X')
                {
                    char nextC = s.charAt(i+1);
                    if(nextC == 'L') 
                    {
                        result += 40;
                        i++;
                        continue;
                    }
                    else if(nextC == 'C')
                    {
                        result += 90;
                        i++;
                        continue;
                    }
                } 
                else if(c == 'C')
                {
                    char nextC = s.charAt(i+1);
                    if(nextC == 'D') 
                    {
                        result += 400;
                        i++;
                        continue;
                    }
                    else if(nextC == 'M')
                    {
                        result += 900;
                        i++;
                        continue;
                    }
                }
            }
            
            result += map.get(c);
            
        }

        return result;
    }
}
