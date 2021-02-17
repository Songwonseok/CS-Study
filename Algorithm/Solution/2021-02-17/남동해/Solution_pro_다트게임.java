package y2021.m02.d17;

public class Solution_pro_다트게임 {
	public static void main(String[] args) throws Exception {
		String dartResult = "1D2S#10S";
		System.out.println(solution(dartResult));
	}
	public static int solution(String dartResult) {
        int answer = 0;
        int result[] = new int[3];
        int index = 0;
        for(int i=0;i<dartResult.length();i++) {
        	char curr = dartResult.charAt(i);
        	if(curr=='S') {
        		index++;
        	}else if(curr=='D') {
        		result[index]=result[index]*result[index];
        		index++;
        	}else if(curr=='T') {
        		result[index]=result[index]*result[index]*result[index];
        		index++;
        	}else if(curr=='*') {
        		result[index-1]*=2;
        		if(index>1) {
        			result[index-2]*=2;
        		}
        	}else if(curr=='#') {
        		result[index-1]*=-1;
        	}else if(curr=='1'&&dartResult.charAt(i+1)=='0') {
        		result[index]=10;
        		i++;
        	}else {
        		result[index]=curr-'0';
        	}
        }
        for(int i=0;i<result.length;i++) {
        	answer += result[i];
        }
		return answer;
	}
}
