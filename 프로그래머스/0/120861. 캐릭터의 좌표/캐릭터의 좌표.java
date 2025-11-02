class Solution {
    
    int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0, nx = 0, ny = 0;
        int sx = board[0] / 2;
        int sy = board[1] / 2;
        
        for(String s : keyinput) {
            if(s.equals("up")) {
                nx = x + moves[0][0];
                ny = y + moves[0][1];
            } else if(s.equals("down")) {
                nx = x + moves[1][0];
                ny = y + moves[1][1];
            } else if(s.equals("left")) {
                nx = x + moves[2][0];
                ny = y + moves[2][1];
            } else {
                nx = x + moves[3][0];
                ny = y + moves[3][1];
            }
            
            if(nx > sx || nx < -sx || ny > sy || ny < -sy) continue;
            
            x = nx;
            y = ny;
        }
        
        return new int[]{x, y};
    }
}