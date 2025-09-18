import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length - 1; i++) {
            int p = prices[i];
            int idx = 0;
            for(int k = i + 1; k < prices.length; k++) {
                if(p > prices[k] || k == prices.length - 1) {
                    idx = k;
                    break;                    
                }
            }
            answer[i] = idx - i;
        }
        
        return answer;
    }
}