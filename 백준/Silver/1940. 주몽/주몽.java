import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int i = 0, j = n - 1, count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int k = 0; k < n; k++) {
            a[k] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        while (i < j) {
            if (a[i] + a[j] > m) {
                j--;
            } else if (a[i] + a[j] < m) {
                i++;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
    }
}