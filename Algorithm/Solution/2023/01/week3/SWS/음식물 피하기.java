import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] DIR_ROW = {-1, 1, 0, 0}, DIR_COL = {0, 0, -1, 1}; // 상하좌우
	static int size;

	public static void findWaste(boolean[][] path, int r, int c) {
		size++;
		path[r][c] = false;

		int maxRow = path.length;
		int maxCol = path[0].length;

		for(int i = 0; i < 4; i++) {
			int nr = r + DIR_ROW[i];
			int nc = c + DIR_COL[i];

			if(nr < 0 || nr >= maxRow || nc < 0 ||nc == maxCol || !path[nr][nc]) {
				continue;
			}

			findWaste(path, nr, nc);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[][] path = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			path[r][c] = true;
		}

		int maxSize = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(path[i][j]) {
					size = 0;
					findWaste(path, i, j);
					maxSize = Math.max(size, maxSize);
				}
			}
		}

		System.out.println(maxSize);
	}
}