import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void perm(int depth, int N, int M, int[] result, boolean[] visit) {
		if(depth == M) {
			System.out.println(
				Arrays.stream(result)
				.mapToObj(String::valueOf)
					.collect(Collectors.joining(" "))
			);
			return;
		}

		for(int i = 1; i <= N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = i;
				perm(depth + 1, N, M, result, visit);
				visit[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		perm(0, N, M, new int[M], new boolean[N + 1]);
	}
}