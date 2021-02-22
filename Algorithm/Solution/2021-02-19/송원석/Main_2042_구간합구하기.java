package baek;

import java.io.*;
import java.util.*;

public class Main_2042_구간합구하기 {
	
	public static double log2(int num) {
		return Math.log10(num) / Math.log10(2);
	}
	
	public static long init(long[] tree, long[] arr, int[] nodeNumbers, int node, int start, int end) {
		if(start == end) {
			nodeNumbers[start] = node;
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;
		
		return tree[node] = init(tree,arr,nodeNumbers,node*2,start,mid) + init(tree,arr,nodeNumbers,node*2+1, mid+1, end);
	}
	
	public static void update(long[] tree, int index, long differ) {
		for(int i=index;i>=1;i/=2) {
			tree[i] += differ;
		}
	}
	
	public static long sum(long[] tree, int node, int start, int end, int sumStart, int sumEnd) {
		if(sumStart > end || sumEnd < start) {
			return 0;
		}
		else if(sumStart <= start && end <= sumEnd) {
			return tree[node];
		}else {
			int mid = (start + end) / 2;
			return sum(tree, node*2 ,start, mid, sumStart, sumEnd) + sum(tree, node*2+1, mid+1, end, sumStart, sumEnd);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int height = (int)Math.ceil(log2(N));
		int treeSize = 1 <<(height+1);
		long[] tree = new long[treeSize];
		long[] arr = new long[N];
		int[] nodeNumbers = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(tree,arr,nodeNumbers,1,0,N-1);
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			
			if(command == 1) {
				int index = Integer.parseInt(st.nextToken()) -1;
				long change = Long.parseLong(st.nextToken());
				long differ = change - arr[index];
				arr[index] = change;
				int node = nodeNumbers[index];
				update(tree, node, differ);
			}else {
				int sumStart = Integer.parseInt(st.nextToken()) -1; 
				int sumEnd = Integer.parseInt(st.nextToken()) -1;
				
				long result = sum(tree,1,0,N-1,sumStart,sumEnd);
				sb.append(result).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
