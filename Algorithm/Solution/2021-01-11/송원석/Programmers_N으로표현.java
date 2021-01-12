package Programmers.practice;

import java.util.*;

public class DP_N으로표현 {
	public static void DP(HashSet<Integer> lSet, HashSet<Integer> rSet, HashSet<Integer> acc){
        for(Integer l : lSet){
            for(Integer r : rSet){
                acc.add(l+r);
                acc.add(l-r);
                acc.add(l*r);
                if(r != 0)
                    acc.add(l/r);
            }
        }
    }
    
    public static int solution(int N, int number) {
        HashSet<Integer>[] set = new HashSet[9];
        
        for(int i=1;i<=8;i++){
            set[i] = new HashSet<Integer>();
            StringBuffer sb = new StringBuffer();
            for(int j=1; j<=i;j++)
                sb.append(1);
            set[i].add(Integer.parseInt(sb.toString()) * N);
        }
        
        for(int i=1;i<=8;i++){
            for(int j=1;j<i;j++){
                DP(set[j], set[i-j], set[i]);
            }
            if(set[i].contains(number)){
                return i;
            }
        }
        return -1;
    }
    
	public static void main(String[] args) {
		int answer = solution(5,31168);
		System.out.println(answer);
	}

}
