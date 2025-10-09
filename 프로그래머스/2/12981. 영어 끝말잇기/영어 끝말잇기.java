import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};

        HashSet<String> set = new HashSet<>();
        
        int count = 1;
        char last = words[0].charAt(0);
        
        for(String word : words) {
            if(word.charAt(0) != last || set.contains(word)) {
                if(count % n == 0) {
                    answer[0] = n;
                } else {
                    answer[0] = count % n;
                }
                answer[1] = (int) Math.ceil((double) count / n);
                break;
            }
            
            set.add(word);
            count++;
            last = word.charAt(word.length() - 1);
        }

        return answer;
    }
}