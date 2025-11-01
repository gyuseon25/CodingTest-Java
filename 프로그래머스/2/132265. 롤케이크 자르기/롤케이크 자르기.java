import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> amap = new HashMap<>();
        HashMap<Integer, Integer> bmap = new HashMap<>();
        for(int t : topping) {
            bmap.put(t, bmap.getOrDefault(t, 0) + 1);
        }
        
        for(int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            bmap.put(t, bmap.get(t) - 1);
            if (bmap.get(t) == 0) bmap.remove(t);
            amap.put(t, amap.getOrDefault(t, 0) + 1);
            if(amap.keySet().size() == bmap.keySet().size()) answer++;
        }
        
        
        return answer;
    }
}