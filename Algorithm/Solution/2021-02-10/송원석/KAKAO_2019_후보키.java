package Programmers.kakao;

import java.util.ArrayList;
import java.util.HashSet;

public class KAKAO_2019_후보키 {

	static int columnCount;
	static int count;
	static ArrayList<HashSet<Integer>> candidateKey;

	public static boolean isCandidateKey(ArrayList<Integer> columns, String[][] relation) {
		ArrayList<String>[] list = new ArrayList[relation.length];

		for (int i = 0; i < relation.length; i++) {
			list[i] = new ArrayList<String>();
			for(int j=0;j<columns.size();j++) {
				int idx = columns.get(j);
				list[i].add(relation[i][idx]);
			}
			
			ArrayList<String> curr = list[i];
			for(int j=i-1;j>=0;j--) {
				int count = 0;
				ArrayList<String> other = list[j];
				for(int z=0;z<columns.size();z++) {
					if(curr.get(z).equals(other.get(z))) {
						count++;
						if(count == columns.size()) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public static boolean isMinimality(ArrayList<Integer> columns) {
		
		for(int i=0;i<candidateKey.size();i++) {		
			int count = 0;
			
			for(int j=0;j<columns.size();j++) {
				if(candidateKey.get(i).contains(columns.get(j))) {
					count++;
					if(count == candidateKey.get(i).size()) {
						return false;
					}
				}
			}
			
		}
		return true;
	}

	public static void comb(int start, int depth, int size, boolean[] visit, String[][] relation) {
		if (depth == size) {
			ArrayList<Integer> columns = new ArrayList<>();
			for (int i = 0; i < columnCount; i++) {
				if (visit[i]) {
					columns.add(i);
				}
			}
			
			if(!isMinimality(columns)) {
				return;
			}
			
			if (isCandidateKey(columns, relation)) {
				count++;
				candidateKey.add(new HashSet<Integer>(columns));
			}
			return;
		}

		for (int i = start; i < columnCount; i++) {
			if (!visit[i]) {
				visit[i] = true;
				comb(i, depth + 1, size, visit, relation);
				visit[i] = false;
			}
		}

	}

	public static int solution(String[][] relation) {
		columnCount = relation[0].length;
		count = 0;
		candidateKey = new ArrayList<HashSet<Integer>>();

		for (int i = 1; i <= columnCount; i++) {
			comb(0, 0, i, new boolean[columnCount], relation);
		}

		return count;
	}

	public static void main(String[] args) {
		String[][] a = { { "a", "aa" }, { "aa", "a" }, { "a", "a" } };
		int answer = solution(a);
		System.out.println(answer);
	}

}
