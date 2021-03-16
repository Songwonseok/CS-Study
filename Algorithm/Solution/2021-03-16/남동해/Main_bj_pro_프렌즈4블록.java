package y2021.m03.d17;

class Main_bj_pro_프렌즈4블록 {
	public static void main(String[] args) throws Exception {
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(m,n,board));
	}
	public static char[][] map;
    public static boolean[][] visit;
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j]=board[i].charAt(j);
            }
        }
        boolean flag = false;
        while(!flag){
            visit = new boolean[m][n];
            flag = true;
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(map[i][j]!='*'&&map[i][j]==map[i+1][j]&&map[i][j]==map[i][j+1]&&map[i][j]==map[i+1][j+1]){
                        visit[i][j]=true;
                        visit[i+1][j]=true;
                        visit[i][j+1]=true;
                        visit[i+1][j+1]=true;
                    }
                }
            }
            for(int i=0;i<n;i++){
                int t = m-1;
                for(int j=m-1;j>=0;j--){
                    if(!visit[j][i]){
                        map[t][i]=map[j][i];
                        t--;
                    }
                }
                for(int j=t;j>=0;j--){
                    map[j][i]='*';
                    answer++;
                    flag=false;
                }
            }
        }
        return answer;
    }
}