import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        int an = a;
        int bn = b;
        
        
        while(true) {
            
            if( ((an + 1) / 2) == ((bn + 1) / 2) ) {
                break;
            }
            
            an = (an + 1) / 2;
            bn = (bn + 1) / 2;
            
            answer++;
        }

        return answer;
    }
}