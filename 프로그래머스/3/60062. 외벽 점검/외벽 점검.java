import java.util.*;

class Solution {
    
    private int answer = Integer.MAX_VALUE;
    private int[] dist;

    public int solution(int n, int[] weak, int[] dist) {
        this.dist = dist;

        // 1. weak 배열을 2배로 늘려 원형 → 선형으로 변환
        int len = weak.length;
        int[] extended = new int[len * 2];
        for (int i = 0; i < len; i++) {
            extended[i] = weak[i];
            extended[i + len] = weak[i] + n;
        }

        // 2. dist의 모든 순열 생성 후 검사
        permutation(new ArrayList<>(), new boolean[dist.length], extended, len);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void permutation(List<Integer> list, boolean[] visited, int[] extended, int len) {
        // 친구 순열 완성 시 검사
        if (list.size() == dist.length) {
            checkCoverage(extended, len, list);
            return;
        }

        // 친구 순서 순열 DFS
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(dist[i]);
                permutation(list, visited, extended, len);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    private void checkCoverage(int[] extended, int len, List<Integer> order) {
        // weak[i]를 출발점으로 시도
        for (int start = 0; start < len; start++) {
            int count = 1; // 사용한 친구 수
            int position = extended[start] + order.get(count - 1); // 첫 친구가 커버할 최대 거리

            boolean success = true;

            // start부터 len개의 weak 지점 탐색
            for (int i = start; i < start + len; i++) {
                if (extended[i] > position) { // 현재 친구가 커버 불가
                    count++;
                    if (count > order.size()) { // 친구를 다 써도 덮지 못함
                        success = false;
                        break; // 친구 다 썼으면 중단
                    }
                    position = extended[i] + order.get(count - 1);
                }
            }

            if (success) {
                answer = Math.min(answer, count);
            }
        }
    }
}