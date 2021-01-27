package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2346_풍선터뜨리기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] balloons = new int[N];
		for (int i = 0; i < N; i++)
			balloons[i] = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		boolean[] visit = new boolean[N];
		int currIdx = 0;
		int count = 0;
		while (true) {
			sb.append((currIdx + 1) + " ");
			if (++count == N)
				break;

			visit[currIdx] = true;

			int move = balloons[currIdx];

			if (move > 0) {
				while (move > 0) {
					currIdx = (currIdx + 1) % N;
					if (!visit[currIdx]) {
						move--;
					}
				}
			} else {
				move = Math.abs(move);
				while (move > 0) {
					currIdx = (currIdx == 0) ? N - 1 : currIdx - 1;
					if (!visit[currIdx]) {
						move--;
					}
				}
			}
		}
		  
		System.out.println(sb);

	}

}
