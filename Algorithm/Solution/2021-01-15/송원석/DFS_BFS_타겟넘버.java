package Programmers.practice;

public class DFS_타겟넘버 {
    public static int DFS(int[] numbers, int depth, int sum,int target){
        if(depth == numbers.length){
            if(sum == target)
            	return 1;
            return 0;
        }
        return DFS(numbers, depth+1, sum + numbers[depth], target) + DFS(numbers, depth+1, sum - numbers[depth], target);
    }

    public static int solution(int[] numbers, int target) {
        return DFS(numbers,0,0,target);
    }
    
	public static void main(String[] args) {
		int[] ar = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(ar,target));

	}

}
