package y2021.m01.d22;

import java.util.Arrays;

public class Solution_채널톡코테1 {
	public static void main(String[] args) throws Exception {
//		int matrix[][] = {{1,19,20,8,25},{21,4,3,17,24},{12,5,6,16,15},{11,18,10,9,23},{7,13,14,22,2}};
		int matrix[][] = {{4,2,9},{1,3,5},{6,8,7}};
		System.out.println(solution(matrix));
	}
	public static boolean visit[][];
	public static int solution(int[][] matrix) {
		int answer = 0;
		int N = matrix.length;
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			int temp[] = matrix[i].clone();
			Arrays.sort(temp);
			for(int j=0;j<N;j++) {
				if(temp[N/2]==matrix[i][j]) {
					visit[i][j]=true;
					break;
				}
			}
		}
		for(int i=0;i<N;i++) {
			int temp[] = new int[N];
			for(int j=0;j<N;j++) {
				temp[j]=matrix[j][i];
			}
			Arrays.sort(temp);
			for(int j=0;j<N;j++) {
				if(temp[N/2]==matrix[j][i]&&visit[j][i]) {
					answer++;
					break;
				}
			}
		}
        return answer;
    }
}
