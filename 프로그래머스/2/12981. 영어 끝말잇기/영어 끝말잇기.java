import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> set = new HashSet<>();

        char last = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            if (set.contains(word) || word.charAt(0) != last) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }

            set.add(word);
            last = word.charAt(word.length() - 1);
        }
        return answer;
    }
}
