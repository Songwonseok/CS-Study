class Solution {
    public int dfs(int[] numbers, int target, int depth, int sum) {
        if(depth < numbers.length) {
            return dfs(numbers, target, depth + 1, sum + numbers[depth]) 
            + dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }
        
        if(sum == target) {
            return 1;
        }
        
        return 0;
    }
    
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }
}