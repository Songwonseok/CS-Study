package y2021.m02.d19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5
 */

class Main_bj_2042_구간합구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		SegmentTree segmentArr = new SegmentTree(arr, N);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==1) {
				int index = Integer.parseInt(st.nextToken());
				long data = Long.parseLong(st.nextToken());
				segmentArr.update(0, N-1, index-1, data-arr[index-1], 1);
				arr[index-1]=data;
			}else {
				int left = Integer.parseInt(st.nextToken())-1;
				int right = Integer.parseInt(st.nextToken())-1;
				sb.append(segmentArr.sum(0, N-1, left, right, 1)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static class SegmentTree {
	    long[] segmentArr;
	    SegmentTree(long[] arr, int n) {
	        segmentArr = new long[n * 4];
	        init(arr, 0, n - 1, 1);
	    }

	    long init(long[] arr, int start, int end, int node) {
	        if (start == end) {
	            return segmentArr[node] = arr[start];
	        }

	        int mid = (start + end) / 2;
	        segmentArr[node] += init(arr, start, mid, node * 2);
	        segmentArr[node] += init(arr, mid + 1, end, node * 2 + 1);
	        return segmentArr[node];
	    }
	    void data() {
	    	System.out.println(Arrays.toString(segmentArr));
	    }
	    
	    long sum(int start, int end, int left, int right, int node) {
	    	if (left > end || right < start) {
				return 0;
			}
	    	
	    	if (left <= start && end <= right) {
				return segmentArr[node];
			}
	    	int mid = (start + end) / 2;
	    	long temp = sum(start, mid, left, right, node * 2) + sum(mid + 1, end, left, right, node * 2 + 1);
	    	return temp;
	    }
	    
	    
	    void update(int start, int end, int index, long data, int node) {
	        if (start > index || index > end){
	        	return;
	        }
	        segmentArr[node] += data;
	        if(start != end) {
	            int mid = (start + end) / 2;
	            update(start, mid, index, data, node * 2);
	            update(mid + 1, end, index, data, node * 2 + 1);
	        }
	    }
	}
}