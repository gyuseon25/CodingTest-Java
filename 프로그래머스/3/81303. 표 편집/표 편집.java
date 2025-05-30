import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> deleted = new Stack<>();
        boolean[] isDeleted = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        for (String c : cmd) {
            String[] parts = c.split(" ");
            String op = parts[0];

            if (op.equals("U")) {
                int x = Integer.parseInt(parts[1]);
                for (int i = 0; i < x; i++) k = prev[k];
            } else if (op.equals("D")) {
                int x = Integer.parseInt(parts[1]);
                for (int i = 0; i < x; i++) k = next[k];
            } else if (op.equals("C")) {
                deleted.push(k);
                isDeleted[k] = true;

                if (prev[k] != -1) next[prev[k]] = next[k];
                if (next[k] != -1) prev[next[k]] = prev[k];

                k = (next[k] != -1) ? next[k] : prev[k];
            } else if (op.equals("Z")) {
                int restore = deleted.pop();
                isDeleted[restore] = false; 

                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != -1) prev[next[restore]] = restore;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(isDeleted[i] ? 'X' : 'O');
        }
        return sb.toString();
    }
}