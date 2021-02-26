package y2021.m02.d24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
5
-1 0 0 1 1
2
 */

class Main_bj_1068_트리 {
	public static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] tree = new ArrayList[N];
		for(int i=0;i<N;i++) {
			tree[i] = new ArrayList<>();
		}
		int root = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int curr = Integer.parseInt(st.nextToken());
			if(curr==-1) {
				root = i;
			}else {
				tree[curr].add(i);
			}
		}
		int del = Integer.parseInt(br.readLine());
		if(del==root) {
			System.out.println(0);
		}else {
			dfs(tree,root,del);
			System.out.println(answer);
		}
	}

	private static void dfs(ArrayList<Integer>[] tree, int node, int del) {
		for(int i=0;i<tree[node].size();i++) {
			int curr = tree[node].get(i);
			if(curr==del) {
				if(tree[node].size()==1) {
					answer++;
				}
				continue;
			}
			if(tree[curr].size()==0) {
				answer++;
			}else {
				dfs(tree,curr,del);
			}
		}
	}
}