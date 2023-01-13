class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int [] result = new int [2];

        label:for(int i=0;i<len-1;i++)
        {
            int first = nums[i];
            for(int j=i+1;j<len;j++)
            {
                int second = nums[j];

                if(first + second == target) 
                {
                    result[0] = i;
                    result[1] = j;
                    break label;
                } 
            }
        }

        return result;
    }
}
