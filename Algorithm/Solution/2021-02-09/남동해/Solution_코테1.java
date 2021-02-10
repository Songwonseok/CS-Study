package y2021.m02.d09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution_코테1 {
	public static void main(String[] args) throws Exception {
		String holidays[] = {"01/14","01/15","01/18","01/22","01/23","01/29","02/01","02/03","02/07"};
		int k = 5;
		System.out.println(solution(holidays,k));
	}
	public static int[] month = {0,0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static int solution(String[] holidays,int k) {
        int answer = 0;
        boolean[] day = new boolean[366];
        for(int i=3;i<day.length;i+=7) {
        	day[i-1]=true;
        	day[i]=true;
        }
        int sum =0;
        for(int i=0;i<month.length;i++) {
        	sum+=month[i];
        	month[i]=sum;
        }
        for(int i=0;i<holidays.length;i++) {
        	String[] curr = holidays[i].split("/");
        	int currday = month[Integer.parseInt(curr[0])] + Integer.parseInt(curr[1]);
        	day[currday]=true;
        }
        int daysum=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<day.length;i++) {
        	if(day[i]==true) {
        		daysum++;
        	}else {
        		set.add(daysum);
        		daysum=0;
        	}
        }
        int[] holi = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        for(int i=0;i<set.size();i++) {
        	holi[i]=iter.next();
        }
        Arrays.sort(holi);
        answer = holi[holi.length-k];
        return answer;
    }
}
