import java.util.*;

class Solution {
    boolean solution(String s) {

        int lc = 0, rc = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(st.isEmpty() && c == ')') return false;
            else if(c == ')' && st.peek() == '(') st.pop();
            else st.push(c);
        }

        return st.isEmpty();
    }
}