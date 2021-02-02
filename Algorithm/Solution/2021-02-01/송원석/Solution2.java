package Programmers.Scatterlab;

public class Solution2 {
	
	public static double solution(double C, double F, double X) {
		double efficiency = 2.0; // 1분당 닭 갯수(능률)
        double time = X / efficiency; // 현재 능률로 걸리는 시간
        double offset = 0; // 누적 시간
        
        while(time > offset + (C/efficiency) + X/(efficiency+F)) {
        	offset += C/efficiency;
        	efficiency += F;
        	time = X / efficiency + offset;
        }
        
        time = Math.round(time*1000000.0)/1000000.0;
        return time;
    }

	public static void main(String[] args) {
		double a = solution(1.0,100.0,100.0);
		System.out.println(a);
	}

}
