class Solution {
    public int[] searchRange(int[] nums, int target) {
        int st_idx = -1;
        int ed_idx = -1;
        int cnt = 1;
        for(int i=0; i<nums.length;i++){
            if(cnt==1 && nums[i]==target){
                st_idx = i;
                cnt++;

            }
            if(cnt==2 && nums[i]==target){
                ed_idx = i;
            }
        }
        if(ed_idx == -1) st_idx = -1;
        int[] answer = {st_idx, ed_idx};
        return answer;
    }
}