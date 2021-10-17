package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word1 = br.readLine();
		String word2 = br.readLine();

		int[][] lcs = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 1; i <= word1.length(); i++) {
			char alphabet1 = word1.charAt(i-1);

			for (int j = 1; j <= word2.length(); j++) {
				char alphabet2 = word2.charAt(j-1);

				if(alphabet1 == alphabet2) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
					continue;
				}

				lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}

		System.out.println(lcs[word1.length()][word2.length()]);
	}
}
