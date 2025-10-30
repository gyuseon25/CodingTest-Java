import java.util.*;

class Solution {
    
    int n;
    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private class Node {
        int r, c, cost;
        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        n = land.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(visited[now.r][now.c]) continue;
            
            visited[now.r][now.c] = true;
            
            answer += now.cost;
            
            for(int[] move : moves) {
                int nr = now.r + move[0];
                int nc = now.c + move[1];
                
                if(!valid(nr, nc)) continue;
                
                int tempCost = Math.abs(land[now.r][now.c] - land[nr][nc]);
                int newCost = tempCost > height ? tempCost : 0;
                pq.add(new Node(nr, nc, newCost));
            }
        }
        
        
        return answer;
    }
    
    private boolean valid(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}