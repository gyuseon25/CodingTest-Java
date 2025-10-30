import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < answer.length; i++) {
            int[] arr = commands[i];
            int[] tmp = new int[arr[1] - arr[0] + 1];
            int idx = 0;
            for(int j = arr[0] - 1; j < arr[1]; j++) {
                tmp[idx++] = array[j];
            } 
            Arrays.sort(tmp);
            answer[i] = tmp[arr[2] - 1];
        }
        
        return answer;
    }
}