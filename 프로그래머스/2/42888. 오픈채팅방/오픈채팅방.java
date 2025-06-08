import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        HashMap<String, String> map = new HashMap<>();
        for(String s : record) {
            String[] str = s.split(" ");
            if(str[0].equals("Enter")) {
                map.put(str[1], str[2]);
            } else if(str[0].equals("Change")) {
                map.put(str[1], str[2]);
            }
        }
        
        for(String s : record) {
            String[] str = s.split(" ");
            if(str[0].equals("Enter")) {
                answer.add(map.get(str[1]) + "님이 들어왔습니다.");
            } else if(str[0].equals("Leave")) {
                answer.add(map.get(str[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] result = new String[answer.size()];
        for(int i = 0 ; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}