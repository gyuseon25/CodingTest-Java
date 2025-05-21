import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == student1[i % 5]) map.put(1, map.getOrDefault(1, 0) + 1);
            if(answers[i] == student2[i % 8]) map.put(2, map.getOrDefault(2, 0) + 1);
            if(answers[i] == student3[i % 10]) map.put(3, map.getOrDefault(3, 0) + 1);
        }
        
        int max = 0; 
        TreeSet<Integer> results = new TreeSet<>();
        for(int i = 1; i <= 3; i++) {
            max = Math.max(map.getOrDefault(i, 0), max);
        }
        for(int i = 1; i <= 3; i++) {
            if(max == map.getOrDefault(i,0)) {
                results.add(i);
            }
        }
        
        int[] answer = new int[results.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = results.pollFirst();
        }
        return answer;
    }
}