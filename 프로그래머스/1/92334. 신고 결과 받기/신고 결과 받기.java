import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashMap<String, List<String>> record = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        
        for(String str : report) {
            String[] split = str.split(" ");
            
            String 신고인 = split[0];
            String 피신고인 = split[1];
            
            if(record.get(신고인) == null) {
                record.put(신고인, new ArrayList<String>());
            }
            
            if(record.get(신고인).contains(피신고인)){
                 continue;   
            }            
            
            count.put(피신고인, count.getOrDefault(피신고인, 0) + 1);
            record.get(신고인).add(피신고인);
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < answer.length; i++) { 
            int tmp = 0;
            String id = id_list[i];
            
            List<String> ls = record.getOrDefault(id, null);
            if(ls != null) {
             for(String s : ls) {
                if(count.getOrDefault(s, 0) >= k){
                    tmp++;
                }
            }   
            }
            answer[i] = tmp;
        }
        
        return answer;
    }
}