package Programmers.kakao;

public class KAKAO_2017_보행자천국 {
	static int MOD = 20170805;
	static int[] dx = {0, -1}, dy = {-1, 0}; // 좌, 상

	public static int getPathCount(int x, int y, int[][] cityMap, int[][] memo, int dir){
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		while(nx >= 0 && ny >= 0){
			if(cityMap[nx][ny] == 0){
				return memo[nx][ny];
			}

			if(cityMap[nx][ny] == 1){
				return 0;
			}

			nx += dx[dir];
			ny += dy[dir];
		}

		return 0;
	}

	public static int solution(int m, int n, int[][] cityMap) {
		int[][] memo = new int[m][n];

		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if(x == 0 && y == 0){
					memo[0][0] = 1;
					continue;
				}
				// 1. 좌, 상 값을 더하면 현재 위치 경우의 수
				// 2. 좌, 상의 값이 2인 경우 같은 방향으로 한칸 더 가야함
				memo[x][y] = getPathCount(x,y, cityMap, memo, 0)
					+ getPathCount(x,y, cityMap, memo, 1);
				memo[x][y] %= 20170805;
			}
		}

		return memo[m-1][n-1];
	}

	public static void main(String[] args) {
		int m = 3, n= 6;
		int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};

		System.out.println(solution(m,n,cityMap));
	}
}
