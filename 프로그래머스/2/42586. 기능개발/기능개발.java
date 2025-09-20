import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++) {
            int complete = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            q.addLast(complete);
        }
        
        while(!q.isEmpty()) {
            int count = 1;
            int first = q.pollFirst();
            while(!q.isEmpty() && q.peek() <= first) {
                q.pollFirst();
                count++;
            }
            list.add(count);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}