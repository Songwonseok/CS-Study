package baek;

import java.io.*;
import java.util.*;

public class Main_1991_트리순회 {

	static class Node {
		public String name;
		public Node parent;
		public Node left;
		public Node right;

		public Node(String name) {
			this.name = name;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
	}

	public static void preorder(StringBuilder sb, Node curr) {
		sb.append(curr.name);
		if(curr.left != null) {
			preorder(sb, curr.left);
		}
		if(curr.right != null) {
			preorder(sb, curr.right);
		}
	}

	public static void inorder(StringBuilder sb, Node curr) {
		if(curr.left == null && curr.right == null) {
			sb.append(curr.name);
			return;
		}
		
		if(curr.left != null) {
			inorder(sb, curr.left);
		}
		sb.append(curr.name);
		if(curr.right != null) {
			inorder(sb, curr.right);
		}
		
	}

	public static void postorder(StringBuilder sb, Node curr) {
		if(curr.left == null && curr.right == null) {
			sb.append(curr.name);
			return;
		}
		
		if(curr.left != null) {
			postorder(sb, curr.left);
		}
		if(curr.right != null) {
			postorder(sb, curr.right);
		}
		sb.append(curr.name);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Node> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			if (!map.containsKey(root)) {
				map.put(root, new Node(root));
			}

			if (!left.equals(".")) {
				if (!map.containsKey(left)) {
					map.put(left, new Node(left));
				}
				map.get(left).parent = map.get(root);
				map.get(root).left = map.get(left);
			}

			if (!right.equals(".")) {
				if (!map.containsKey(right)) {
					map.put(right, new Node(right));
				}

				map.get(right).parent = map.get(root);
				map.get(root).right = map.get(right);
			}
		}
		Node root = map.get("A");
		
		StringBuilder answer = new StringBuilder();
		StringBuilder preSB = new StringBuilder();
		StringBuilder inSB = new StringBuilder();
		StringBuilder postSB = new StringBuilder();
		preorder(preSB, root);
		inorder(inSB, root);
		postorder(postSB, root);
		answer.append(preSB.toString()+"\n").append(inSB.toString()+"\n").append(postSB.toString());
		
		System.out.println(answer);
		
	}

}
