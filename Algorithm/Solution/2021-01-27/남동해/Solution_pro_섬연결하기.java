package y2021.m01.d27;

import java.util.Arrays;
import java.util.Comparator;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_섬연결하기 {
	public static void main(String[] args) throws Exception {
		int n = 4;
		int costs[][] = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(solution(n, costs));
	}
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        int island[]=new int[n];
        Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
        int isindex=1;
        int count = 0;
        for(int i=0;i<costs.length;i++) {
        	if(count==n-1) {
        		break;
        	}
        	int isa = costs[i][0];
        	int isb = costs[i][1];
        	int cost = costs[i][2];
        	if(island[isa]==0&&island[isb]==0) {
        		island[isa]=isindex;
        		island[isb]=isindex;
        		answer+=cost;
        		isindex++;
        	}else if(island[isa]==0&&island[isb]!=0) {
        		island[isa]=island[isb];
        		answer+=cost;
        	}else if(island[isa]!=0&&island[isb]==0) {
        		island[isb]=island[isa];
        		answer+=cost;
        	}else {
        		if(island[isa]==island[isb]) {
        			continue;
        		}else {
        			int temp = island[isa];
        			for(int j=0;j<island.length;j++) {
        				if(island[j]==temp) {
        					island[j]=island[isb];
        				}
        			}
        			answer+=cost;
        		}
        	}
        	count++;
        }
        return answer;
    }
}
