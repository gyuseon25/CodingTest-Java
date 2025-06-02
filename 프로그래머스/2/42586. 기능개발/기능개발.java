import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int remainder = 100 - progresses[i];
            if(remainder % speeds[i] == 0) {
                queue.add(remainder / speeds[i]);
            } else {
                queue.add((remainder / speeds[i]) + 1);
            }
        }
        
        int count = 1;
        int pre = queue.poll();
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            if(pre >= tmp) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                pre = tmp;
            }
        }
        
        answer.add(count);
        
        
        int[] convert = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            convert[i] = answer.get(i);
        }
        
        return convert;
    }
}