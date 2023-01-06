class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        int[] answer = {-1, -1};
        
        while(left <= right) {
            if(nums[left] == target) {
                answer[0] = left;
            }else{
                left++;
            }
            
            if(nums[right] == target) {
                answer[1] = right;
            }else {
                right--;
            }
            
            if(answer[0] > -1 && answer[1] > -1) {
                break;
            }
        }
        
        
              
        return answer;
        
    }
}