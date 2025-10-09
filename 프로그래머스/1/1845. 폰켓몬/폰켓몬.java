import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        int answer = nums.length / 2;
        
        return Math.min(answer, set.size());
    }
}