class Solution {
    public int[] searchRange(int[] nums, int target) {
        Arrays.sort(nums);

        int len = nums.length;
        int [] result = new int [2];
        Arrays.fill(result, -1);
        ArrayList<Integer> list = new ArrayList<>();
        int startNum = -1;
        for(int i=0;i<len;i++)
        {
            int num = nums[i];
            if(num == target)
            {
                if(startNum == -1) {
                    startNum = i;
                    continue;
                }
                list.add(i);
            } 
        }

        if(startNum == -1) return result;

        int listLen = list.size();

        result[0] = startNum;
        result[1] = startNum + listLen;

        return result;
    }
}
