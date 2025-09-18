import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> basket = new Stack<>();
        
        for(int m : moves) {
            for(int i = 0; i < board.length; i++) {
                int doll = board[i][m-1];
                if(doll != 0) {
                    board[i][m-1] = 0;
                    if(!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(doll);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}