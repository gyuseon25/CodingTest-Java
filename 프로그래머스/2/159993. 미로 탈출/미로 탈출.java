import java.util.*;

class Solution {
    static int r, c;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(String[] maps) {
        r = maps.length;
        c = maps[0].length();
        
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') { 
                    sx = i; sy = j; 
                }
                if (c == 'L') { 
                    lx = i; ly = j; 
                }
                if (c == 'E') { 
                    ex = i; ey = j; 
                }
            }
        }

        // S → L 최단 거리
        int dist1 = bfs(maps, sx, sy, 'L');
        if (dist1 == -1) return -1; // 레버 도달 불가 → 종료

        // L → E 최단 거리
        int dist2 = bfs(maps, lx, ly, 'E');
        if (dist2 == -1) return -1; // 출구 도달 불가 → 종료

        // 두 거리 합이 전체 이동 거리
        return dist1 + dist2;
    }

    // BFS로 목표 문자(target)까지 최단 거리 계산
    private int bfs(String[] maps, int sx, int sy, char target) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        int[][] dist = new int[r][c];
        
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            if (maps[x].charAt(y) == target) {
                return dist[x][y];
            }

            for (int[] move : moves) {
                int nx = x + move[0];
                int ny = y + move[1];
                
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx].charAt(ny) == 'X') continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        
        return -1;
    }
}
