import java.util.*;

class Solution {
    
    private int answer;
    private int[][] d;
    private boolean[] visited;
    
    private void dfs(int k, int cnt) {
        for(int i = 0; i < d.length; i++) {
            if(!visited[i] && k >= d[i][0]) {
                visited[i] = true;
                dfs(k - d[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        answer = 0;
        visited = new boolean[d.length];
        
        dfs(k, 0);
        return answer;
    }
}