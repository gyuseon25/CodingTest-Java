import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> nickname = new HashMap<>(); 
        ArrayList<Status> recordList = new ArrayList<>();
        HashMap<String, String> convert = new HashMap<>();
        
        convert.put("Enter", "님이 들어왔습니다.");
        convert.put("Leave", "님이 나갔습니다.");

        for(String s : record) {
            String[] sp = s.split(" ");
            
            String s1 = sp[0];
            
            if(s1.equals("Enter")) {
                nickname.put(sp[1], sp[2]);
                Status status = new Status(s1, sp[1]);
                recordList.add(status);
            } else if(s1.equals("Leave")) {
                Status status = new Status(s1, sp[1]);
                recordList.add(status);
            } else {
                nickname.put(sp[1], sp[2]);
            }
        }
        
        for(Status s : recordList) {
            String status = convert.get(s.status);
            String name = nickname.get(s.uid);
            list.add(name + status);
        }
        
        String[] answer = new String[recordList.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    class Status {
        String status;
        String uid;
        
        public Status(String status, String uid) {
            this.status = status;
            this.uid = uid;
        }
    }
}