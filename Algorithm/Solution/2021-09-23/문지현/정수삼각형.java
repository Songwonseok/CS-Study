public class 정수삼각형 {

    public static void main(String[] args) {
        정수삼각형 num1 = new 정수삼각형();
        System.out.println(num1.solution(
                new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}
        ));
    }

    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j==0) triangle[i][j] += triangle[i-1][j];
                else if (j==i) triangle[i][j] += triangle[i-1][j-1];
                else {
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
            }
        }

        for (int i = 0; i < triangle.length; i++) {
            if(answer < triangle[triangle.length-1][i]) {
                answer = triangle[triangle.length-1][i];
            }
        }

        return answer;
    }
}
