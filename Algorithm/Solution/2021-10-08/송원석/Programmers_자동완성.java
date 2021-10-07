package Programmers.kakao;

import java.util.HashMap;

public class Programmers_자동완성 {
	class Node {
		Node parent;
		HashMap<Character, Node> children;
		boolean isLastCharacter;

		Node(Node parent) {
			this.parent = parent;
			children = new HashMap<>();
		}
	}

	class Trie {
		Node root;

		Trie() {
			root = new Node(null);
		}

		void insert(String word) {
			Node currNode = root;

			for (int i = 0; i < word.length(); i++) {

				char alphabet = word.charAt(i);

				Node parent = currNode;
				currNode = currNode.children.computeIfAbsent(alphabet, k -> new Node(parent));
			}

			currNode.isLastCharacter = true;
		}

		// 존재하는 단어를 검색한다는 전제
		Node getNode(String word) {
			Node currNode = root;

			for (int i = 0; i < word.length(); i++) {
				currNode = currNode.children.get(word.charAt(i));
			}

			return currNode;
		}

		int getCount(String word) {
			Node currNode = getNode(word);
			int count = word.length();

			if (currNode.children.size() > 0) {
				return count;
			}

			while (currNode.parent != null) {
				if (currNode.parent.isLastCharacter || currNode.parent.children.size() > 1) {
					return count;
				}

				currNode = currNode.parent;
				count--;
			}

			return count;
		}

	}

	public int solution(String[] words) {
		int answer = 0;
		Trie trie = new Trie();

		for (String word : words) {
			trie.insert(word);
		}

		for (String word : words) {
			answer += trie.getCount(word);
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] words = {"word", "war", "warrior", "world"};

		Programmers_자동완성 test = new Programmers_자동완성();

		int answer = test.solution(words); // 정답 : 7

		System.out.println(answer);
	}
}
