import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        Arrays.sort(stages);
        
        int numbers = stages.length;
        int idx = 0;
        List<Stage> list = new ArrayList<>();
        
        for(int i = 1; i <= N; i++) {
            int count = 0;
            while (idx < stages.length && stages[idx] == i) {
                count++;
                idx++;
            }
            
            double p = 0;
            if (numbers != 0) {
                p = (double) count / numbers;
            }
            numbers -= count;
            
            list.add(new Stage(i, p));
        }
        
        Collections.sort(list);
        
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = list.get(i).n;
        }
        return answer;
    }
    
    class Stage implements Comparable<Stage> {
        int n; //스테이지 단계
        double p; //실패율 확률
        
        Stage (int n, double p) {
            this.n = n;
            this.p = p;
        }
        
        @Override
        public int compareTo(Stage o) {
            if(this.p == o.p) {
                return this.n - o.n; //스테이지 단계 별 오름차순
            }
            return Double.compare(o.p, this.p);  //실패율 별 내림차순
        }
    }
}