import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] ch = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for(char c : ch) {
            deque.offerLast(c);
        }
        for(int i = 0; i < ch.length; i++) {
            if(check(new LinkedList<>(deque))) {
                answer++;
            }
            deque.offerLast(deque.pollFirst());
        }
        return answer;
    }
    
    private boolean check(Deque<Character> deque) {
        Stack<Character> stack = new Stack<>();


        while (!deque.isEmpty()) {
        char c = deque.pollFirst();
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((c == ')' && top != '(') ||
                (c == '}' && top != '{') ||
                (c == ']' && top != '[')) {
                return false;
                }
            }
        }
        return stack.isEmpty();
    }
}