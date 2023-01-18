import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        boolean [][] visit = new boolean [N][M];
        
        int [] di = {-1,1,0,0}, dj = {0,0,-1,1};
        
        Queue<int[]> q = new LinkedList<>();
        
        visit[0][0] = true;
        q.offer(new int [] {0,0,1});
        
        while(!q.isEmpty())
        {
            int [] curr = q.poll();
            
            for(int d=0;d<4;d++)
            {
                int ni = curr[0] + di[d];
                int nj = curr[1] + dj[d];
                int cnt = curr[2];
                
                if(ni < 0 || nj < 0 || ni > N-1 || nj > M-1 || maps[ni][nj] == 0 || visit[ni][nj]) 
                    continue;
                
                visit[ni][nj] = true;
                
                
                if(ni == N-1 && nj == M-1)
                    return cnt+1;
                
                q.offer(new int [] {ni, nj, cnt+1});
            }
        }
        
        
        return -1;
    }
}
