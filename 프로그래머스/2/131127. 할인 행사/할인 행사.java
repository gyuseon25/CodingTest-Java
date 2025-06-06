import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        int sum = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < want.length; i++) {
            map.put(want[i], map.getOrDefault(want[i], 0) + number[i]);
            sum += number[i];
        }
        
        
        int len = discount.length - sum + 1;
        
        for(int i = 0; i < len; i++) {
            boolean flag = false;
            HashMap<String, Integer> copy = new HashMap<>(map);
            for(int j = i; j < i + sum; j++) {
                String value = discount[j];
                if(!copy.containsKey(value) || copy.get(value) < 0) {
                    flag = true;
                    break;
                }
                copy.put(value, copy.get(value) - 1);
            }
            
            Set<String> set = copy.keySet();
            
            for(String s : set) {
                if(copy.get(s) > 0) flag = true;
            }
            
            if(!flag) answer++;
        }
        
        return answer;
    }
}