import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        HashMap<String, String> tree = new HashMap<>();
        HashMap<String, Integer> idx = new HashMap<>();
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++) {
            idx.put(enroll[i], i);
        }
        
        for(int i = 0; i < referral.length; i++) {
            String parent = referral[i];
            String sell = enroll[i];            
            tree.put(sell, parent);
        }
        
        for(int i = 0; i < seller.length; i++) {
            int total = amount[i] * 100;
            String sell = seller[i];
            
            String parent = tree.get(sell);
            while(true) {
                int sellerIdx = idx.get(sell);
                answer[sellerIdx] += total - total / 10;
                total /= 10;

                if (parent.equals("-") || total == 0) break;

                sell = parent;
                parent = tree.get(parent);
            }
        }
        
        
        return answer;
    }
}