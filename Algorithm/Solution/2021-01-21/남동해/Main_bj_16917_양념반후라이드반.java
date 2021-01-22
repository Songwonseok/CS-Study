package y2021.m01.d21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
1500 2000 1600 3 2
 */


class Main_bj_16917_양념반후라이드반 {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	int X = Integer.parseInt(st.nextToken());
    	int Y = Integer.parseInt(st.nextToken());
    	int min = 0;
    	if(A+B>2*C) {
    		if(X>Y) {
    			min = 2*C*Y + (X-Y)*A;
    			if(min>C*X*2) {
    				min = C*X*2;
    			}
    		}else {
    			min = 2*C*X + (Y-X)*B;
    			if(min>C*Y*2) {
    				min = C*Y*2;
    			}
    		}
    	}else {
    		min = A*X + B*Y;
    	}
    	System.out.println(min);	
	}
}
