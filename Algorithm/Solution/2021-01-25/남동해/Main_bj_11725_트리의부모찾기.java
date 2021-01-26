package y2021.m01.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7
1 6
6 3
3 5
4 1
2 4
4 7
 */


class Main_bj_11725_트리의부모찾기 {
	public static int result[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		result = new int[N+1];
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(map.get(x)==null) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(y);
				map.put(x, al);
			}else {
				ArrayList<Integer> al = map.get(x);
				al.add(y);
				map.put(x, al);
			}
			if(map.get(y)==null) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(x);
				map.put(y, al);
			}else {
				ArrayList<Integer> al = map.get(y);
				al.add(x);
				map.put(y, al);
			}
		}
		bfs(map,1);
		for(int i=2;i<result.length;i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(HashMap<Integer, ArrayList<Integer>> map, int root) {
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int curr = q.poll();
			ArrayList<Integer> al = map.get(curr);
			for(int i=0;i<al.size();i++) {
				int child = al.get(i);
				if(result[child]==0) {
					result[child]=curr;
					q.add(child);
				}
			}
		}
	}
}
