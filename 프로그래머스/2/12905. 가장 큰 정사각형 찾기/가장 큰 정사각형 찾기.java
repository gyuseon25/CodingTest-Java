class Solution
{
    public int solution(int [][]board)
    {
        int r = board.length;
        int c = board[0].length;
                
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                
                if(board[i][j] == 1) {
                    int up = board[i - 1][j];
                    int left = board[i][j - 1];
                    int upLeft = board[i - 1][j - 1];

                    board[i][j] += Math.min(up, Math.min(left, upLeft));
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }
        
        return answer * answer;
    }
}