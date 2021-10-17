package baek;

import java.io.*;
import java.util.*;

public class BOJ_1062_가르침 {
	static int N, K, answer;
	static ArrayList<HashSet> needList;
	static HashSet<Character> combResult;
	static char[] targetChars;

	public static void comb(int depth, int start) {
		if (depth == K) {
			int result = 0;

			for(HashSet<Character> set : needList) {
				int matchCount = 0;

				for(char c : set) {
					if(combResult.contains(c)) {
						matchCount++;
					}
				}

				if(matchCount == set.size()) {
					result++;
				}
			}

			answer = Math.max(answer, result);
			return;
		}

		for (int i = start; i < targetChars.length; i++) {
			if (!combResult.contains(targetChars[i])) {
				combResult.add(targetChars[i]);
				comb(depth + 1, i+1);
				combResult.remove(targetChars[i]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 5; // 접두, 접미사 배울때 필요한 K를 미리 제거
		answer = 0;

		if (K < 0) {
			System.out.println(answer);
			return;
		}

		HashSet<Character> baseSet = new HashSet<>(Arrays.asList('a', 'c', 'i', 'n', 't'));
		HashSet<Character> targetSet = new HashSet<>(baseSet);

		needList = new ArrayList<>(); // 각 단어별로 배워야되는 글자를 담는 리스트

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			HashSet<Character> need = new HashSet<>();

			for (int j = 4; j < word.length() - 4; j++) {
				char alphabet = word.charAt(j);

				if (baseSet.contains(alphabet)) {
					continue;
				}

				need.add(alphabet);
				targetSet.add(alphabet);
			}

			if (need.size() <= K) { // 배워야 되는 글자가 K보다 적은 경우
				needList.add(need);
			}
		}

		int size = targetSet.size();

		if(size <= K + 5) {
			System.out.println(N);
			return;
		}

		targetChars = new char[targetSet.size()];
		combResult = new HashSet<>(baseSet);

		int index = 0;
		for(char c : targetSet) {
			targetChars[index++] = c;
		}

		comb(0, 0);

		System.out.println(answer);
	}
}
