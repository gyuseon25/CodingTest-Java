import java.util.*;

class Solution {
    
    private boolean isValid(int x, int y) {
        return x >= -5 && x <= 5 && y >= -5 && y <= 5;
    }
    
    public int solution(String dirs) {
        int x = 0, y = 0;
        HashSet<String> answer = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++) {
            int dx = 0, dy = 0;
            char dir = dirs.charAt(i);
    
            if (dir == 'U') dy = 1;
            else if (dir == 'D') dy = -1;
            else if (dir == 'R') dx = 1;
            else if (dir == 'L') dx = -1;

            int nx = x + dx;
            int ny = y + dy;
            
            if (!isValid(nx, ny)) continue;

            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            x = nx;
            y = ny;
        }
        return answer.size() / 2;
    }
    
}