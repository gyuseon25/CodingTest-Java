import java.util.*;

class Solution {
    
    private static int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static int[][] cmaps;
    private static int answer = 0;
    private static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        cmaps = maps;
        
                
        int answer = bfs();
                                       
        return answer;
    }
    
    private static int bfs() {
        
        int[][] dist = new int[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int[] d : moves) {
                int nx = x + d[0];
                int ny = y + d[1];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(cmaps[nx][ny] == 0 || dist[nx][ny] > 0) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}