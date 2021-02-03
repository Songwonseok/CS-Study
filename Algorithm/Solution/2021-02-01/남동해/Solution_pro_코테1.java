package y2021.m02.d01;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_코테1 {
	public static class Day implements Comparable<Day>{
		int day;
		int priority;
		int temp;
		int weather;
		int rain;
		int score;
		boolean bad;
		public Day(int day,int priority, int temp, int weather, int rain, int score, boolean bad) {
			this.day = day;
			this.priority = priority;
			this.temp = temp;
			this.weather = weather;
			this.rain = rain;
			this.score = score;
			this.bad = bad;
		}
		@Override
		public String toString() {
			return "Day [day=" + day + ", priority=" + priority + ", temp=" + temp + ", weather=" + weather + ", rain="
					+ rain + ", score=" + score + ", bad=" + bad + "]";
		}
		@Override
		public int compareTo(Day o) {
			if(o.score>this.score) {
				return 1;
			}else if(this.score==o.score) {
				return this.priority-o.priority;
			}
			return -1;
		}
	}
	public static int[] prior= {6,5,3,4,1,0,2}, wea={0,20,20,17,10,5,14};
	public static void main(String[] args) throws Exception {
		int data[][] = {{1,0,11},{3,1,15},{2,0,16},{4,0,17},{2,0,15},{2,1,14},{2,0,12}};
//		int data[][] = {{4,0,12},{1,0,16},{3,0,18},{3,0,17},{2,0,15},{3,2,22},{2,1,17}};
		
		System.out.println(Arrays.toString(solution(data)));
	}
	public static int[] solution(int[][] data) {
		Day[] today = new Day[7];
		for(int i=0;i<data.length;i++) {
			today[i]=new Day(i,prior[i], data[i][2], data[i][0], data[i][1], 20-Math.abs(22-data[i][2]), false);
			if(today[i].rain==0) {
				today[i].score+=wea[today[i].weather];
			}else {
				today[i].score+=wea[4+today[i].rain];
			}
			if(today[i].weather==4||today[i].rain==1||today[i].temp<=0||today[i].temp>=30) {
				today[i].bad=true;
			}
		}
		Arrays.sort(today);
		for(int i=0;i<today.length;i++) {
			System.out.println(today[i]);
		}
		int[] answer = new int[2];
		answer[0]=today[0].day;
		answer[1]=-1;
		for(int i=today.length-1;i>=0;i--) {
			if(today[i].bad) {
				answer[1]=today[i].day;
				break;
			}
		}
		return answer;
	}
}
