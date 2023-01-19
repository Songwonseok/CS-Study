class Solution {
    
    static int answer;
    
    public static int solution(int [] numbers, int target) {
		answer = 0;
		findTarget(numbers, target, 0);
		return answer;
	}
    
    public static void findTarget(int [] numbers, int target, int tryNum) {
		if(tryNum == numbers.length) {
			int result = 0;
			for(int i=0;i<numbers.length;i++)
				result += numbers[i];
			if(result == target)
				answer++;
			return;
		}
		
		findTarget(numbers, target, tryNum+1);
		
		numbers[tryNum] *= -1;
		findTarget(numbers, target, tryNum+1);
		numbers[tryNum] *= -1;
	}
}