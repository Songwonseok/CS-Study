package Programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KAKAO_2019_길찾기게임 {
	static class Node {
		int x;
		int y;
		int number;
		Node left;
		Node right;

		Node(int number, int x, int y) {
			this.number = number;
			this.x = x;
			this.y = y;
			this.left = null;
			this.right = null;
		}

	}

	static class BinaryTree {
		Node head;

		void push(Node node) {
			if (head == null) {
				head = node;
				return;
			}

			Node curr = head;

			while (curr != null) {
				if (node.x < curr.x) {
					if (curr.left == null) {
						curr.left = node;
						return;
					}
					curr = curr.left;
				} else {
					if (curr.right == null) {
						curr.right = node;
						return;
					}
					curr = curr.right;
				}
			}

			curr = node;
		}

		void preorder(Node curr, List<Integer> result) {
			if (curr == null) {
				return;
			}

			result.add(curr.number);
			preorder(curr.left, result);
			preorder(curr.right, result);
		}

		void postorder(Node curr, List<Integer> result) {
			if (curr == null) {
				return;
			}

			postorder(curr.left, result);
			postorder(curr.right, result);
			result.add(curr.number);
		}
	}

	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][];

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.y == o2.y){
					return Integer.compare(o1.x, o2.x);
				}

				return - Integer.compare(o1.y, o2.y);
			}
		});

		BinaryTree bt = new BinaryTree();

		for (int i = 0; i < nodeinfo.length; i++) {
			Node node = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
			pq.add(node);
		}

		while(!pq.isEmpty()){
			Node node = pq.poll();
			bt.push(node);
		}

		List<Integer> preorderResult = new ArrayList<>();
		List<Integer> postorderResult = new ArrayList<>();

		bt.preorder(bt.head, preorderResult);
		bt.postorder(bt.head, postorderResult);

		answer[0] = preorderResult.stream().mapToInt(i -> i).toArray();
		answer[1] = postorderResult.stream().mapToInt(i -> i).toArray();

		return answer;
	}

	public static void main(String[] args) {
		int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
		int[][] answer = solution(nodeinfo);

		System.out.println(Arrays.toString(answer[0]));
		System.out.println(Arrays.toString(answer[1]));

	}
}
