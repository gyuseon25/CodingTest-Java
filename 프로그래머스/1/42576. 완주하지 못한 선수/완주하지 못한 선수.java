import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for(String s : participant) {
            if(!map.containsKey(s) || map.get(s) == 0){
                return s;
            }
            if(map.containsKey(s)) {
                map.put(s, map.get(s) - 1); 
            }
        }
        
        return null;
    }
}