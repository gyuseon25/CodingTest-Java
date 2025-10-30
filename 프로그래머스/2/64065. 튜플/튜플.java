import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 2);
        s = s.replace("{" , "");
        String[] arr = s.split("},");
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            String[] nums = arr[i].split(",");
            for(String num : nums) {
                if(!set.contains(num)) {
                    answer[i] = Integer.parseInt(num);
                    set.add(num);
                }
            }
        }
    
        return answer;
    }
}