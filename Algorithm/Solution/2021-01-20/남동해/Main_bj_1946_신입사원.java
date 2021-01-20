package y2021.m01.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
2
5
3 2
1 4
4 1
2 3
5 5
7
3 6
7 3
4 2
1 4
5 7
2 5
6 1
*/

class Main_bj_1946_신입사원 {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=0;tc<T;tc++) {
    		int N = Integer.parseInt(br.readLine());
    		int count = 1;
    		int[][] table = new int[N][2];
    		for(int i=0;i<N;i++) {
    			st = new StringTokenizer(br.readLine());
    			table[i][0]=Integer.parseInt(st.nextToken());
    			table[i][1]=Integer.parseInt(st.nextToken());
    		}
    		
    		Arrays.sort(table,new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
    		
    		int min = table[0][1];
    		for(int i=1;i<N;i++) {
    			if(table[i][1]>min) {
    				continue;
    			}else {
    				min=table[i][1];
    				count++;
    			}
    		}
    		System.out.println(count);
    	}
	}
}
