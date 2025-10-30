import java.util.*;

class Solution {
    public long solution(long n) {
        
        char[] ch = Long.toString(n).toCharArray();
        Arrays.sort(ch);
        String str = new StringBuilder(new String(ch)).reverse().toString();
        return Long.parseLong(str);
    }
}