package algo_study;

import java.util.*;
import java.io.*;

public class Main_1931_회의실배정 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			
			list.add(new int [] {startTime, endTime});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int [] o2) {
				if(o1[1] == o2[1]) 
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		int room = 0;
		int currPoint = 0;
		
		for(int i=0;i<N;i++) {
			if(currPoint <= list.get(i)[0]) { // 회의가 끝난시간 과 시작시간이 같은 회의는 바로 시작할 수 있기 때문에 <=를 사용함
				currPoint = list.get(i)[1];
				room++;
			}
		}
		
		System.out.println(room);
	}

}
