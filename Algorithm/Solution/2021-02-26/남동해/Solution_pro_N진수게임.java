package y2021.m02.d26;

/*
 */

public class Solution_pro_N진수게임 {
	public static void main(String[] args) throws Exception {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
				
		System.out.println(solution(n,t,m,p));
	}
	public static char[] co ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String s = "0";
        int num = 1;
        while(s.length()<t*m) {
        	s+=changeNumber(n,num);
        	num++;
        }
        for(int i=0;i<t;i++) {
        	answer+=s.charAt(i*m+p-1);
        }
		return answer;
	}
	private static String changeNumber(int n, int num) {
		String s = "";
		while(true) {
			if(num>=n) {
				s=co[num%n]+s;
				num/=n;
			}else {
				s=co[num]+s;
				break;
			}
		}
		return s;
	}
}
