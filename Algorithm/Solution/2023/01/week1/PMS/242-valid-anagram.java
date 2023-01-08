class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        int [] result = new int [26];

        for(int i=0;i<sLen;i++)
        {
            char c = s.charAt(i);
            result[c-'a']++;
        }

        for(int i=0;i<tLen;i++)
        {
            char c = t.charAt(i);
            result[c-'a']--;
        }

        for(int i=0;i<26;i++)
            if(result[i] != 0) return false;
        
        return true;
    }
}
