import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int num : moves) {
            int col = num - 1, doll = 0;
            for(int i = 0; i < n; i++) {
                if(board[i][col] != 0) {
                    doll = board[i][col];
                    board[i][col] = 0;
                    break;
                }
            }
            
            if (doll == 0) continue;

            if (!stack.isEmpty() && stack.peek() == doll) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(doll);
            }
        }
        
        return answer;
    }
}