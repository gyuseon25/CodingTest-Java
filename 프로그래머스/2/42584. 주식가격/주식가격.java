import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Stock> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            Stock stock = new Stock(i, prices[i]);
            while(!stack.isEmpty() && stack.peek().price > prices[i]) {
                Stock top = stack.pop();
                answer[top.minute] = i - top.minute;
            }
            stack.push(stock);
        }
        
        while(!stack.isEmpty()) {
            Stock top = stack.pop();
            answer[top.minute] = prices.length - 1 - top.minute;
        }
        
        return answer;
    }
}
class Stock { 
    int minute;
    int price;
    public Stock (int minute, int price) {
        this.minute = minute;
        this.price = price;
    }
}