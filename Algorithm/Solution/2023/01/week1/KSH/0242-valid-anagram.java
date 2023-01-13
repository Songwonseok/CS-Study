import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();

        Arrays.sort(s_char);
        Arrays.sort(t_char);

        if(Arrays.equals(s_char, t_char)) return true;
        return false;
    }
}