package baek;

import java.io.*;
import java.util.*;

public class Main_1931_회의실배정 {
	public static class Meet implements Comparable<Meet> {
		public int start;
		public int end;
		Meet(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Meet o) {
			if(this.end == o.end)
				return Integer.compare(this.start, o.start);
			return Integer.compare(this.end, o.end);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count =0;
		Meet[] schedule = new Meet[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			schedule[i] = new Meet(start,end);
		}
		
		Arrays.sort(schedule);
		
		int prevEnd = 0;
		
		for(Meet m : schedule) {
			if(m.start >= prevEnd) {
				prevEnd = m.end;
				count++;
			}
		}
		System.out.println(count);
	}

}


