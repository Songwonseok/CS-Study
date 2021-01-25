package y2021.m01.d22;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_채널톡코테4 {
	public static void main(String[] args) throws Exception {
		int total_sp = 121;
		int skills[][] = {{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
		System.out.println(Arrays.toString(solution(total_sp, skills)));
	}
	public static int point[],total;
	public static int[] solution(int total_sp, int[][] skills) {
		ArrayList<Integer>[] al = new ArrayList[skills.length+2];
		point = new int[skills.length+2];
		int top = skills[0][0];
		for(int i=0;i<skills.length;i++) {
			int up=skills[i][0];
			int down=skills[i][1];
			if(al[up]==null) {
				al[up]=new ArrayList<>();
			}
			al[up].add(down);
			
			if(down==top) {
				top=up;
			}
		}
		
		dfs(al,top);
		total=total_sp/total;
		int answer[] = new int[skills.length+1];
		for(int i=0;i<answer.length;i++) {
			answer[i]=point[i+1]*total;
		}
		return answer;
    }
	private static int dfs(ArrayList<Integer>[] al,int top) {
		if(al[top]==null) {
			total+=1;
			point[top]=1;
			return 1;
		}
		int sum = 0;
		for(int i=0;i<al[top].size();i++) {
			int next = al[top].get(i);
			sum+=dfs(al,next);
		}
		total+=sum;
		point[top]=sum;
		return sum;
	}
}
