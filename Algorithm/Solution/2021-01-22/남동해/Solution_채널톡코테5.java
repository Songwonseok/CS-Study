package y2021.m01.d22;

public class Solution_채널톡코테5 {
	public static void main(String[] args) throws Exception {
//		int N = 5;
//		int trees[][] = {{4, 3}, {3, 1}, {2, 2}, {1, 4}};
		int N = 5;
		int trees[][] = {{3, 3}, {2, 2}, {1, 1}};
		System.out.println(solution(N, trees));
	}
	public static int di[] = {0,0,-1,1}, dj[]= {-1,1,0,0};
	public static int solution(int N, int[][] trees) {
		int answer = 0;
		boolean[][] map = new boolean[N][N];
		for(int i=0;i<trees.length;i++) {
			for(int j=trees[i][0];j<N;j++) {
				for(int k=trees[i][1];k<N;k++) {
					map[j][k]=true;
				}
			}
		}
		
		for(int i=0;i<trees.length;i++) {
			for(int d=0;d<4;d++) {
				int ni = trees[i][0]+di[d];
				int nj = trees[i][1]+dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<N) {
					if(!map[ni][nj]) {
						answer++;
						break;
					}
				}
			}
		}
		return answer;
	}
}
