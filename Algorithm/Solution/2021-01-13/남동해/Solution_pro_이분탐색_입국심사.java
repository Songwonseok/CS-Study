package y2021.m01.d13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_이분탐색_입국심사 {
	public static void main(String[] args) throws Exception {
		int n = 6;
		int times[] = {7,10};
		
		System.out.println(solution(n, times));
	}
	public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long min = 0;
        long mid = 0;
        long max = 0;
        for(int i=0;i<times.length;i++){
            if(times[i]>max){
                max = times[i];
            }
        }
        max = max*n;
        while(min<=max){
        	long count = 0;
        	mid = (max + min) / 2;
            for(int i=0;i<times.length;i++){
                count+=mid/times[i];
            }
            if(count<n){  
            	min = mid+1;
            }else{
            	if(answer>mid) {
            		answer = mid;
            	}
                max = mid-1;
            }
        }
        return answer;
    }
}
