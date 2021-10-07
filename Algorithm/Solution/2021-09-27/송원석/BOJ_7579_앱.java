package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7579_앱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] m = new int[N + 1];
		int[] c = new int[N + 1];

		StringTokenizer mToken = new StringTokenizer(br.readLine());
		StringTokenizer cToken = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			m[i] = Integer.parseInt(mToken.nextToken());
			c[i] = Integer.parseInt(cToken.nextToken());
		}

		int minTime = Arrays.stream(c).sum();

		int[][] dp = new int[N+1][minTime+1];

		for (int n = 1; n <= N; n++) {
			for (int t = 0; t <= minTime; t++) {
				if (c[n] > t) {
					dp[n][t] = dp[n - 1][t];
					continue;
				}

				dp[n][t] = Math.max(dp[n - 1][t], dp[n - 1][t - c[n]] + m[n]);

				if (dp[n][t] >= M && minTime > t) {
					minTime = t;
				}
			}
		}

		System.out.println(minTime);
	}
}
