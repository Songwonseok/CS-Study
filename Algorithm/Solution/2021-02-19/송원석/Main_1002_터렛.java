package baek;

import java.io.*;
import java.util.*;

public class Main_1002_터렛 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			int differ_r = Math.abs(r1 - r2);
			
			if (distance == 0 && r1 == r2) {
				answer.append(-1).append("\n");
			} else if (r1 + r2 == distance || differ_r == distance) {
				answer.append(1).append("\n");
			} else if (distance > r1 + r2 || distance < differ_r) {
				answer.append(0).append("\n");
			} else {
				answer.append(2).append("\n");
			}
		}

		System.out.println(answer);
	}

}
