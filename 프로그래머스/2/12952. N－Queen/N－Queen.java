class Solution {
    
    private int[][] board;
    private int N;
    private int answer;
    
    private boolean isValidPoint(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    
    private boolean inCol(int col) {
        for (int i = 0; i < N; i++) {
            if (board[i][col] == 1) return true;
        }
        return false;
    }
    
    private boolean inCross(int x, int y) {
        for (int i = 1; i < N; i++) {
            if (isValidPoint(x - i, y - i) && board[x - i][y - i] == 1) return true;
            if (isValidPoint(x - i, y + i) && board[x - i][y + i] == 1) return true;
        }
        return false;
    }
    
    private void dfs(int r) {
        if (r == N) {
            answer++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (board[r][c] == 0 && !inCol(c) && !inCross(r, c)) {
                board[r][c] = 1;
                dfs(r + 1);
                board[r][c] = 0;
            }
        }
    }
    
    public int solution(int n) {
        board = new int[n][n];
        N = n;
        answer = 0;
        dfs(0);
        return answer;
    }
}