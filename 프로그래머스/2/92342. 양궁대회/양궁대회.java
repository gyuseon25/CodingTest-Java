class Solution {
    int maxDiff = 0;
    int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        dfs(0, n, info, new int[11]);
        return answer;
    }

    private void dfs(int idx, int remain, int[] info, int[] ryan) {
        if (idx == 11) {
            if (remain > 0) ryan[10] += remain;
            compare(info, ryan);
            if (remain > 0) ryan[10] -= remain;
            return;
        }

        int need = info[idx] + 1;

        if (remain >= need) {
            ryan[idx] = need;
            dfs(idx + 1, remain - need, info, ryan);
            ryan[idx] = 0;
        }

        dfs(idx + 1, remain, info, ryan);
    }

    private void compare(int[] info, int[] ryan) {
        int a = 0, r = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && ryan[i] == 0) continue;
            if (info[i] >= ryan[i]) a += 10 - i;
            else r += 10 - i;
        }

        int diff = r - a;
        if (diff <= 0) return;

        if (diff > maxDiff || (diff == maxDiff && isBetter(ryan))) {
            maxDiff = diff;
            answer = ryan.clone();
        }
    }

    private boolean isBetter(int[] ryan) {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] > answer[i]) return true;
            if (ryan[i] < answer[i]) return false;
        }
        return false;
    }
}
