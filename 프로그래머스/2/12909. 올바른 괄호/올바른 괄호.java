class Solution {
    boolean solution(String s) {

        int count = 0;
        for(int i = 0;  i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(tmp == '(') {
                count++;
            } else {
                count--;
            }
            
            if(count < 0) {
                return false;
            }
        }
        
        if(count != 0) {
            return false;
        }
        return true;
    }
}