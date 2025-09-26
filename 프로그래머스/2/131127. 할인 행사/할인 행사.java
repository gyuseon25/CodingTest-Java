import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = 0;
        HashMap<String, Integer> wm = new HashMap<>();
        HashMap<String, Integer> dm = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            wm.put(want[i], number[i]);
            len += number[i];
        }
        
        for(int i = 0; i < len; i++) {
            dm.put(discount[i], dm.getOrDefault(discount[i], 0) + 1);
        }
        
        if(wm.equals(dm)) answer++;
        
        
        for(int i = len; i < discount.length; i++) {
            
            dm.put(discount[i], dm.getOrDefault(discount[i], 0) + 1);
            if(dm.get(discount[i - len]) == 1) {
                dm.remove(discount[i - len]);
            } else {
                dm.put(discount[i - len], dm.get(discount[i - len]) - 1);
            }
            
            if(wm.equals(dm)) answer++;
        } 
        
        return answer;
    }
}