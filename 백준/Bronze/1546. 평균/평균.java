import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int max = 0;
        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n > max)
                max = n;
            sum += n;
        }

        System.out.println((float) sum / max * 100 / num);

    }
}