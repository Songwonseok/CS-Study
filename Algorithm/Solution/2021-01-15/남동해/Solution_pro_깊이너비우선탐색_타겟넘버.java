package y2021.m01.d15;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_깊이너비우선탐색_타겟넘버 {
	public static void main(String[] args) throws Exception {
		int numbers[] = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        int sum = 0;
        answer = dfs(0,sum,numbers,numbers.length,target);
        return answer;
    }

	private static int dfs(int count,int sum,int[] numbers,int K, int T) {
		if(count==K) {
			if(sum==T) {
				return 1;
			}else {
				return 0;
			}
		}
		int temp = 0;
		temp+=dfs(count+1, sum+numbers[count], numbers, K, T);
		temp+=dfs(count+1, sum-numbers[count], numbers, K, T);
		return temp;
	}
}
