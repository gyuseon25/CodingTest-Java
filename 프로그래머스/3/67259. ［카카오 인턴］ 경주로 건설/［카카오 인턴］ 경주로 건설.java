import java.util.*;

class Solution {
    
    private static int[][] moves = {{1, 0, 0}, {0, 1, 1}, {-1, 0, 2}, {0, -1, 3}}; // 남, 동, 북, 서 순서
    
    class Node {
        int x;
        int y;
        int d; // direction, 0 -> 남, 1 -> 동, 2 -> 북, 3 -> 서
        int c; // cost
        public Node(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        int answer = bfs(board, n);
        return answer;
    }
    
    private int bfs(int[][] board, int n) {
        
        // dist[dir][x][y] : dir 방향으로 (x, y)에 도착했을 때 최소비용
        int[][][] dist = new int[4][n][n];
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[d][i], Integer.MAX_VALUE);
            }
        }        
        Queue<Node> q = new ArrayDeque<>();
        if (board[1][0] == 0) { // 남
            dist[0][1][0] = 100;
            q.offer(new Node(1, 0, 0, 100));
        }
        if (board[0][1] == 0) { // 동
            dist[1][0][1] = 100;
            q.offer(new Node(0, 1, 1, 100));
        }
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            for(int[] move : moves) {
                int nx = now.x + move[0];
                int ny = now.y + move[1];
                int nd = move[2];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) continue;

                // 다음 비용 계산 (직진 100, 코너 600)
                int nextCost = now.c + (now.d == nd ? 100 : 600);

                // 더 적은 비용으로 갱신될 때만 큐에 추가
                if (dist[nd][nx][ny] > nextCost) {
                    dist[nd][nx][ny] = nextCost;
                    q.offer(new Node(nx, ny, nd, nextCost));
                }
            }
        }
        
        return Math.min(
            Math.min(dist[0][n-1][n-1], dist[1][n-1][n-1]),
            Math.min(dist[2][n-1][n-1], dist[3][n-1][n-1])
        );
    }
}