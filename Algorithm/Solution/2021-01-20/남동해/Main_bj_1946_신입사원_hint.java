package y2021.m01.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

class Main_bj_1946_신입사원_hint {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=0;tc<T;tc++) {
    		int N = Integer.parseInt(br.readLine());
    		int count = 1;
    		int[] table = new int[N];
    		for(int i=0;i<N;i++) {
    			st = new StringTokenizer(br.readLine());
    			table[Integer.parseInt(st.nextToken())-1]=Integer.parseInt(st.nextToken());
    		}
    		
    		int min = table[0];
    		for(int i=1;i<N;i++) {
    			if(table[i]>min) {
    				continue;
    			}else {
    				min=table[i];
    				count++;
    			}
    		}
    		System.out.println(count);
    	}
	}
}
