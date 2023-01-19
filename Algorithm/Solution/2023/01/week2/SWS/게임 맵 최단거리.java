import java.util.*;

class Solution {
    static final int[] DIR_ROW = {-1, 1, 0, 0}, DIR_COLUMN = {0,0, -1, 1}; // 상하좌우
    int N,M;
    
    public int bfs(int[][] maps, boolean[][] visit) {
        Queue<int[]> queue = new LinkedList();
        
        queue.offer(new int[] {0, 0, 1}); // 행, 열, 지나간 칸
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for(int dir = 0; dir < 4; dir++) {
                int r = curr[0] + DIR_ROW[dir];
                int c = curr[1] + DIR_COLUMN[dir];
                int count = curr[2] + 1;
                
                if(r < 0 || r >= N || c < 0 || c >= M || maps[r][c] == 0|| visit[r][c]) {
                    continue;
                }
                
                if(r == N - 1 && c == M - 1) {
                    return count;
                }
                
                visit[r][c] = true;
                queue.offer(new int[] {r, c, count});
            }
            
        }
        
        return -1;
    }
    
    public int dfs(int[][] maps, boolean[][] visit, int r, int c, int count) {
        if(r == N - 1 && c == M - 1) {
            return count;
        }
        
        int result = Integer.MAX_VALUE;
        
        for(int dir = 0; dir < 4; dir++) {
            int nr = r + DIR_ROW[dir];
            int nc = c + DIR_COLUMN[dir];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= M  || maps[nr][nc] == 0|| visit[nr][nc]) {
                continue;
            }
                
            visit[nr][nc] = true;
            result = Math.min(result, dfs(maps, visit, nr, nc, count + 1));
            visit[nr][nc] = false;
        }
        
        return result;
    }
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        // BFS
        int answer = bfs(maps, new boolean[N][M]); 
        
        // //DFS
        // int answer = dfs(maps, new boolean[N][M], 0, 0, 1); 
        // if(answer == Integer.MAX_VALUE) {
        //     return -1;
        // }
        
        return answer;
    }
    
    
}