import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] student = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] count = new int[3];
        
        for(int i = 0; i < student.length; i++ ) {
            int c = 0;
            for(int j = 0; j < answers.length; j++) {
                if(answers[j] == student[i][j % student[i].length]) c++;
            }
            count[i] = c;
        }
        
        int max = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] >= max) max = count[i];
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < count.length; i++) {
            if(count[i] == max) set.add(i + 1);
        }
        
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}