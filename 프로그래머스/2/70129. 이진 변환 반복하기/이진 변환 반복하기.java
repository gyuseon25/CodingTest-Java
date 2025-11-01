import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int cnt = 0;
        int zeroCount = 0;
        
        while(!s.equals("1")) {
            int preLen = s.length();
            s = s.replace("0", "");
            int postLen = s.length();
            zeroCount += (preLen - postLen);
            s = Integer.toBinaryString(s.length());
            cnt++;
        }
        
        int[] answer = {cnt, zeroCount};

        return answer;
    }
}