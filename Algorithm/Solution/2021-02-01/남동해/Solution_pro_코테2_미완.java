package y2021.m02.d01;


/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_코테2 {
	public static void main(String[] args) throws Exception {
		double C = 1.0;
		double F = 100.0;
		double X = 100.0;
//		double C = 30.5;
//		double F = 3.14159;
//		double X = 1999.1999;
//		double C = 500.0;
//		double F = 4.0;
//		double X = 2000.0;
		System.out.println(solution(C,F,X));
	}
	public static double min;
	private static double solution(double C, double F, double X) {
		double answer = 0.0;
		min=X/2.0;
		dfs(C,F,X,2.0,0.0);
		String temp = String.format("%.6f", min);
		answer=Double.parseDouble(temp);
		return answer;
	}
	private static double dfs(double C, double F, double X, double output, double time) {
		if(time>min) {
			return time;
		}
		double ntime = dfs(C,F,X,output+F,time+C/output);
		if(ntime<min) {
			min=ntime;
		}
		System.out.println(ntime);
		return time+X/output;
	}
}
