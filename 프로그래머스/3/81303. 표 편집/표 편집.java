import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] deleted = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        int cur = k;

        for (String c : cmd) {
            char op = c.charAt(0);

            if (op == 'U' || op == 'D') {
                int x = Integer.parseInt(c.substring(2));
                while (x-- > 0) {
                    cur = (op == 'U') ? prev[cur] : next[cur];
                }
            } 
            else if (op == 'C') {
                stack.push(cur);
                deleted[cur] = true;

                if (prev[cur] != -1) next[prev[cur]] = next[cur];
                if (next[cur] != -1) prev[next[cur]] = prev[cur];

                cur = (next[cur] != -1) ? next[cur] : prev[cur];
            } 
            else if (op == 'Z') {
                int restore = stack.pop();
                deleted[restore] = false;

                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != -1) prev[next[restore]] = restore;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(deleted[i] ? 'X' : 'O');
        }
        return sb.toString();
    }
}