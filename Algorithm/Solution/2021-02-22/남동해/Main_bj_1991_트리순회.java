package y2021.m02.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
26
A . B
B . C
C . D
D . E
E . F
F . G
G . H
H . I
I . J
J . K
K . L
L . M
M . N
N . O
O . P
P . Q
Q . R
R . S
S . T
T . U
U . V
V . W
W . X
X . Y
Y . Z
Z . .
 */

class Main_bj_1991_트리순회 {
	public static int N, tree[][];
	public static StringBuilder pre, in, post;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[N+1][2];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			int parent = input.charAt(0)-'A'+1;
			int c1 = input.charAt(2)-'A'+1;
			int c2 = input.charAt(4)-'A'+1;
			if(c1!=-18) {
				tree[parent][0]=c1;
			}
			if(c2!=-18) {
				tree[parent][1]=c2;
			}
		}
		pre = new StringBuilder();
		in = new StringBuilder();
		post = new StringBuilder();
		order(1);
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}
	private static void order(int parent) {
		pre.append((char)(parent+'A'-1));
		if(tree[parent][0]!=0) {
			order(tree[parent][0]);
		}
		in.append((char)(parent+'A'-1));
		if(tree[parent][1]!=0) {
			order(tree[parent][1]);
		}
		post.append((char)(parent+'A'-1));
	}
}