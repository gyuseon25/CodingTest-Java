class Solution {
    public int solution(String number) {
        int sum = 0;
        char[] ch = number.toCharArray();
        for(char c : ch) {
            sum += (c - '0');
        }
        
        return sum % 9;
    }
}