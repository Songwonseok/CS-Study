package y2021.m01.d22;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_채널톡코테6 {
	public static void main(String[] args) throws Exception {
		int[] v = {1,2,3,4,5};
		int[][] q = {{1,2,4},{2,3,8},{1,2,4}};
		System.out.println(Arrays.toString(solution(v,q)));
	}
	public static Integer[] solution(int[] v, int[][] q) {
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0;i<q.length;i++) {
			if(q[i][0]==1) {
				int sum = 0;
				for(int j=q[i][1];j<=q[i][2];j++) {
					sum+=v[j];
				}
				al.add(sum);
			}else {
				v[q[i][1]]=q[i][2];
			}
		}
		Integer[] answer =al.toArray(new Integer[al.size()]);
		return answer;
	}
}
