package Programmers.practice;

public class Programmers_정수삼각형 {
	public int solution(int[][] triangle) {
		int height = triangle.length;

		for(int h = height - 1; h > 0 ; h--) {
			for(int w = 0; w < triangle[h].length - 1; w++) {
				triangle[h - 1][w] += Math.max(triangle[h][w], triangle[h][w+1]);
			}
		}

		return triangle[0][0];
	}
	public static void main(String[] args) {
		Programmers_정수삼각형 test = new  Programmers_정수삼각형();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

		System.out.println(test.solution(triangle));
	}

}
