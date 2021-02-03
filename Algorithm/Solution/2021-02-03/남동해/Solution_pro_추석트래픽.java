package y2021.m02.d03;

import java.util.StringTokenizer;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_추석트래픽 {
	public static void main(String[] args) throws Exception {
		String lines[] =  {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
//		String lines[] = {"2016-09-15 03:10:33.020 0.011s"};
		
		System.out.println(solution(lines));
	}
	public static int time[][];
	public static int solution(String[] lines) {
        int answer = 0;
        time = new int[lines.length][2];
        for(int i=0;i<lines.length;i++) {
        	changeTime(lines[i],i);
        }
        
        for(int i=0;i<time.length;i++) {
        	int count = 0;
        	int start = time[i][1];
        	int end = time[i][1]+1000;
        	for(int j=0;j<time.length;j++) {
        		if(time[j][1]>=start&&time[j][0]<end) {
        			count++;
        		}
        	}
        	if(count>answer) {
        		answer=count;
        	}
        }
        
        return answer;
    }
	private static void changeTime(String input, int co) {
		StringTokenizer st = new StringTokenizer(input);
		st.nextToken();
		String stime = st.nextToken();
		String sdelay = st.nextToken();
		String[] splittime = stime.split(":");
		int hour = Integer.parseInt(splittime[0]);
		int min=Integer.parseInt(splittime[1]);
		double second = Double.parseDouble(splittime[2])*1000;
		sdelay=sdelay.replace("s", "");
		double delay = Double.parseDouble(sdelay)*1000;
		time[co][0]=hour*3600*1000+min*60*1000+(int)second-(int)delay+1;
		time[co][1]=hour*3600*1000+min*60*1000+(int)second;
	}
}
