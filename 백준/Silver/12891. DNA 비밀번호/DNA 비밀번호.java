import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int[] cnt, minCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dnaLen = Integer.parseInt(st.nextToken());
        int subLen = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char[] c = new char[dnaLen];
        for(int i = 0; i < dnaLen; i++) {
            c[i] = str.charAt(i);
        }

        minCnt = new int[4];
        cnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            minCnt[i] = Integer.parseInt(st.nextToken());
        }

        for(int k = 0; k < subLen; k++) {
            switch (c[k]) {
                case 'A':
                    cnt[0]++;
                    break;
                case 'C':
                    cnt[1]++;
                    break;
                case 'G':
                    cnt[2]++;
                    break;
                case 'T':
                    cnt[3]++;
                    break;
            }
        }
        check();

        int i = 0;
        int j = subLen - 1;
        while(j < dnaLen - 1) {
            minusCount(c, i++);
            plusCount(c, ++j);
            check();
        }
        System.out.println(answer);
    }

    private static void plusCount(char[] c, int idx) {
        switch (c[idx]) {
            case 'A':
                cnt[0]++;
                break;
            case 'C':
                cnt[1]++;
                break;
            case 'G':
                cnt[2]++;
                break;
            case 'T':
                cnt[3]++;
                break;
        }
    }

    private static void minusCount(char[] c, int idx) {
        switch (c[idx]) {
            case 'A':
                cnt[0]--;
                break;
            case 'C':
                cnt[1]--;
                break;
            case 'G':
                cnt[2]--;
                break;
            case 'T':
                cnt[3]--;
                break;
        }
    }

    private static void check() {
        boolean flag = true;
        for(int i = 0; i < 4; i++) {
            if(cnt[i] < minCnt[i]) {
                flag = false;
                break;
            }
        }
        if(flag) answer++;
    }
}
