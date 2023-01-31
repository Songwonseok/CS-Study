import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] DIR_ROW = {-1, 1, 0, 0}, DIR_COL = {0, 0, -1, 1}; // 상하좌우
	static int paintSize;
	public static void findPaint(int[][] board, int r, int c) {
		paintSize++;
		board[r][c] = 0;

		int maxRow = board.length;
		int maxCol = board[0].length;

		for(int i = 0; i < 4; i++) {
			int nr = r + DIR_ROW[i];
			int nc = c + DIR_COL[i];

			if(nr < 0 || nr >= maxRow || nc < 0 ||nc == maxCol || board[nr][nc] == 0) {
				continue;
			}

			findPaint(board, nr, nc);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		int maxSize = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(board[i][j] == 1) {
					count++;
					paintSize = 0;
					findPaint(board, i, j);
					maxSize = Math.max(paintSize, maxSize);
				}
			}
		}

		System.out.println(count + "\n" + maxSize);
	}
}