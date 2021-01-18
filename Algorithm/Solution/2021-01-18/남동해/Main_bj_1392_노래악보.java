package y2021.m01.d18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3 5
2
1
3
2
3
4
0
1
*/

class Main_bj_1392_노래악보 {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int Q = Integer.parseInt(st.nextToken());
    	
    	int[] B = new int[N];
    	int size = 0;
    	for(int i=0;i<N;i++) {
    		B[i]=Integer.parseInt(br.readLine());
    		size += B[i];
    	}
    	int[] time = new int[size];
    	int curr = 0;
    	for(int i=0;i<N;i++) {
    		for(int j=curr;j<curr+B[i];j++) {
    			time[j]=i+1;
    		}
    		curr+=B[i];
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<Q;i++) {
    		sb.append(time[Integer.parseInt(br.readLine())]).append("\n");
    	}
    	System.out.println(sb.toString());
	}
}
