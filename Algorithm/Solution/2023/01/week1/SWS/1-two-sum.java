class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                answer[0] = map.get(nums[i]);
                answer[1] = i;
                break;
            }
            
            map.put(target - nums[i], i);
        }
        

        return answer;
    }
}
