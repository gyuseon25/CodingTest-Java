import java.util.*;

class Solution {
    // 전역: 조합 빈도를 저장하는 맵
    Map<String, Integer> comboMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        // 주문마다 처리
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr); // 알파벳 정렬 (일관성 유지)
            String sorted = new String(arr);

            // 각 코스 길이에 대해 조합 생성
            for (int len : course) {
                if (len <= sorted.length()) {
                    dfs(sorted.toCharArray(), 0, 0, len, new StringBuilder());
                }
            }
        }

        // 코스 길이별 최대 빈도 조합만 추출
        for (int len : course) {
            int max = 0;
            for (String key : comboMap.keySet()) {
                if (key.length() == len && comboMap.get(key) >= 2) {
                    max = Math.max(max, comboMap.get(key));
                }
            }

            for (String key : comboMap.keySet()) {
                if (key.length() == len && comboMap.get(key) == max) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer); // 사전순 정렬
        return answer.toArray(new String[0]);
    }

    // 조합 만들기 (DFS)
    private void dfs(char[] arr, int start, int depth, int target, StringBuilder sb) {
        if (depth == target) {
            String combo = sb.toString();
            comboMap.put(combo, comboMap.getOrDefault(combo, 0) + 1);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            sb.append(arr[i]);
            dfs(arr, i + 1, depth + 1, target, sb);
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
    }
}