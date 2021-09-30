import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 앱 {

    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][100001];
        int answer = Integer.MAX_VALUE;

        int[] costs = new int[N];
        int[] memory = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st1.nextToken());
            costs[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cost = costs[i];
            int mem = memory[i];

            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= cost) dp[i][j] = mem;
                } else {
                    if (j >= cost) dp[i][j] = Math.max(dp[i - 1][j - cost] + mem, dp[i - 1][j]);
                    else dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j] >= M) answer = Math.min(answer, j);
            }
        }
        System.out.println(answer);
    }
}
