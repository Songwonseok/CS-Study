import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int lcm = arr[0];
        
label:  while(true) {
            for(int num : arr) {
                if(lcm % num != 0) {
                    lcm += arr[0];
                    continue label;
                }
            }
            
            break;
        }
        
        return lcm;
    }
}