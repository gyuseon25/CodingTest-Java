import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int msize = Integer.parseInt(st.nextToken());
        int qnum = Integer.parseInt(st.nextToken());

        int[][] a = new int[msize + 1][msize + 1];
        int[][] d = new int[msize + 1][msize + 1];

        for (int i = 1; i <= msize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= msize; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= msize; i++) {
            for (int j = 1; j <= msize; j++) {
                d[i][j] = d[i][j - 1] + d[i - 1][j] - d[i - 1][j - 1] + a[i][j];
            }
        }

        for (int i = 0; i < qnum; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = d[x2][y2] - d[x1 - 1][y2] - d[x2][y1 - 1] + d[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}
