package algo_study;

import java.util.*;
import java.io.*;

public class Main_1697_숨바꼭질 {
	static Queue<int[]> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		if(M>N)
			System.out.println(solve(N,M));
		else
			System.out.println(N-M);
	}

	public static int solve(int N, int M) {
		int answer = 0;
		q = new LinkedList<>();
		boolean [] v = new boolean [100001];
		v[N] = true;
		q.offer(new int[] {N,0});
		while(!q.isEmpty()) {
			int [] curr = q.poll();
			int front = curr[0]+1;
			int back = curr[0]-1;
			int tele = curr[0]*2;
			int time = curr[1];
			if(front == M || back == M || tele == M) {
				answer = time+1;
				return answer;
			}
			if(front <= 100000 && !v[front]) {
				q.offer(new int [] {front, time + 1});
				v[front] = true;
			}
			if(back > -1 && !v[back]) {
				q.offer(new int [] {back, time + 1});
				v[back] = true;
			}
			if(tele <= 100000 && !v[tele]) {
				q.offer(new int [] {tele, time + 1});
				v[tele] = true;
			}
		}
		return answer;
	}
}
