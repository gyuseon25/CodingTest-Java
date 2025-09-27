import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> record = new HashMap<>();
        HashMap<String, Integer> counts = new HashMap<>();
        
        for(int i = 0; i < report.length; i++) {
            String[] sp = report[i].split(" ");
            String from = sp[0];
            String to = sp[1];
            record.putIfAbsent(from, new HashSet<>());
            HashSet<String> set = record.get(from);
            if(set.contains(to)) {
                continue;
            } else {
                set.add(to);
                counts.put(to, counts.getOrDefault(to, 0) + 1);
            }
        }
        
        int[] answer = new int[id_list.length];    

        for(int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            int count = 0;
            
            HashSet<String> set = record.get(id);
            if(set == null) continue;
            for(String s : set) {
                if(counts.getOrDefault(s, 0) >= k) count++;
            }
            answer[i] = count;
        }
        
    
        return answer;
    }
}