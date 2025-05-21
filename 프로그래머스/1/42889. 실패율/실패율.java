import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] 도달 = new int[N + 2];

        for (int s : stages) {
            도달[s]++;
        }

        List<Stage> 실패율리스트 = new ArrayList<>();
        int total = stages.length;

        for (int i = 1; i <= N; i++) {
            int 실패 = 도달[i];
            double 실패율 = 0;
            if (total != 0) {
                실패율 = (double) 실패 / total;
            }
            실패율리스트.add(new Stage(i, 실패율));
            total -= 실패;
        }

        Collections.sort(실패율리스트, (a, b) -> {
            if (b.rate == a.rate) return a.stage - b.stage;
            return Double.compare(b.rate, a.rate);
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = 실패율리스트.get(i).stage;
        }

        return answer;
    }

    class Stage {
        int stage;
        double rate;

        Stage(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }
}
