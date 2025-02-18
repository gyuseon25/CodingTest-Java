import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int dnum = Integer.parseInt(st.nextToken());
        int qnum = Integer.parseInt(st.nextToken());

        int[] a = new int[dnum];
        int[] s = new int[dnum];

        str = br.readLine();
        st = new StringTokenizer(str);

        for (int i = 0; i < dnum; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                s[i] = a[i];
            } else {
                s[i] = a[i] + s[i - 1];
            }
        }

        for (int i = 0; i < qnum; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if (first == 1) {
                System.out.println(s[second - 1]);
            } else {
                System.out.println(s[second - 1] - s[first - 2]);
            }
        }
    }
}