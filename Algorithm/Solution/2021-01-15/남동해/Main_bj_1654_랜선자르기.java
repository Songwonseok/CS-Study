package y2021.m01.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4 11
802
743
457
539
*/

class Main_bj_1654_랜선자르기 {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int K = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	long max = 0;
    	long min = 1;
    	int[] lan = new int[K];
    	for(int i=0;i<K;i++) {
    		lan[i]=Integer.parseInt(br.readLine());
    		if(lan[i]>max) {
    			max = lan[i];
    		}
    	}
    	
    	long mid = 0;
    	while(max>=min) {
    		mid = (min+max)/2;
    		long count = 0;
    		for(int i=0;i<K;i++) {
    			count+=lan[i]/mid;
    		}
    		if(count>=N) {
    			min = mid+1;
    		}else {
    			max = mid-1;
    		}
    	}
    	System.out.println(max);
	}
}
