package Programmers.Scatterlab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution1 {
	public static boolean validWorst(int[] weatherInfo) {
		if(weatherInfo[0] == 4 || weatherInfo[1] == 1) {
			return true;
		}else if(weatherInfo[2] >= 30 || weatherInfo[2] <= 0) {
			return true;
		}
		return false;
	}
	
	public static int[] solution(int[][] data) {
		int[] sky = {0,20,20,17,10}; // 하늘상태 점수
        int[] weather = {0,5,14}; // 강수상태 점수
        int[] dayPriority = {1,2,4,3,6,7,5}; // 요일 우선순위
        ArrayList<int[]> dayScore = new ArrayList<int[]>(); // {요일,점수}를 담는 리스트
        
        for(int i=0; i< data.length;i++) {
        	int score = 0;
    		if(data[i][1] == 0) {
    			score += sky[data[i][0]];
    		}else {
    			score += weather[data[i][1]];
    		}
    		score += 20 - Math.abs(22 - data[i][2]);
    		dayScore.add(new int[] {i, score});
        }
        
        Collections.sort(dayScore, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return dayPriority[o2[0]]- dayPriority[o1[0]];
				}
				return o2[1] - o1[1];
			}
        });
        
        int best = dayScore.get(0)[0];
        int[] answer = {best, -1};
        
        for(int i= 6;i>=0;i--){
            int day = dayScore.get(i)[0];
            if(validWorst(data[day])){
                answer[1] = day;
                break;
            }
        }
        
        return answer;
        
    }

	public static void main(String[] args) {
		int[][] data = {{3, 0, 20}, {2, 1, 17}, {3, 0, 17}, {2, 0, 31}, {1, 0, 19}, {1, 0, 19}, {4, 1, 14}};
		int[] a = solution(data);
		

	}

}
