package baek;

import java.util.*;
import java.io.*;

public class Main_19238_스타트택시 {
	static int N, M, gas;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int[][] board;
	static Taxi taxi;
	static HashMap<Integer, Integer> map;

	public static class Taxi {
		public int x, y, gas;

		Taxi(int x, int y, int gas) {
			this.x = x;
			this.y = y;
			this.gas = gas;
		}
	}

	static boolean goToDestination(int endX, int endY) {
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] { taxi.x, taxi.y, 0 });

		boolean[][] visit = new boolean[N][N];

		visit[taxi.x][taxi.y] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			if (curr[2] > taxi.gas)
				return false;

			if (curr[0] == endX && curr[1] == endY) {
				taxi.x = curr[0];
				taxi.y = curr[1];
				taxi.gas += curr[2];
				return true;
			}

			for (int dir = 0; dir < dx.length; dir++) {
				int nx = curr[0] + dx[dir];
				int ny = curr[1] + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1 || visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				queue.add(new int[] { nx, ny, curr[2] + 1 });
			}
		}

		return false;
	}

	static boolean findPassenger() {
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] { taxi.x, taxi.y, 0 });

		int find = -1;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) {
					return a[1] - b[1];
				}
				return a[0] - b[0];
			}
		});
		boolean[][] visit = new boolean[N][N];

		visit[taxi.x][taxi.y] = true;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			if (pq.size() == map.size())
				break;

			if (find != -1 && curr[2] > find)
				break;

			if (curr[2] > taxi.gas)
				return false;

			if (map.containsKey(curr[0] * N + curr[1])) {
				find = curr[2];
				pq.add(new int[] { curr[0], curr[1], curr[2] });
			}

			for (int dir = 0; dir < dx.length; dir++) {
				int nx = curr[0] + dx[dir];
				int ny = curr[1] + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1 || visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				queue.add(new int[] { nx, ny, curr[2] + 1 });
			}
		}

		if (pq.size() == 0) {
			return false;
		}

		int[] passenger = pq.poll();
		int key = passenger[0] * N + passenger[1];

		int destination = map.get(key);
		map.remove(key);

		taxi.x = passenger[0];
		taxi.y = passenger[1];
		taxi.gas -= passenger[2];
		return goToDestination(destination / N, destination % N);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		gas = Integer.parseInt(st.nextToken());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;

		taxi = new Taxi(x, y, gas);
		map = new HashMap();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken()) - 1;
			int startY = Integer.parseInt(st.nextToken()) - 1;
			int endX = Integer.parseInt(st.nextToken()) - 1;
			int endY = Integer.parseInt(st.nextToken()) - 1;
			map.put(startX * N + startY, endX * N + endY);
		}

		boolean check = true;

		for (int i = 0; i < M; i++) {
			if (!findPassenger()) {
				check = false;
				break;
			}
		}

		if (check) {
			System.out.println(taxi.gas);
		} else {
			System.out.println(-1);
		}

	}

}
