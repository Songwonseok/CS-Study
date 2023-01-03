package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1911_흙길보수하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1});
		}

		int answer = 0;
		int offset = 0;

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			if (offset > curr[1]) {
				continue;
			}

			int dif = curr[1] - offset + 1;

			if (curr[0] > offset) {
				dif = curr[1] - curr[0] + 1;
				offset = curr[0];
			}

			int count = dif / L;

			if(dif % L > 0) {
				count++;
			}

			offset += L * count;

			answer += count;

		}

		System.out.println(answer);

	}
}