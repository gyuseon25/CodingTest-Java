import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String snum = br.readLine();

        char[] cnum = snum.toCharArray();

        for (int i = 0; i < cnum.length; i++) {
            sum += (cnum[i] - '0');
        }

        System.out.print(sum);
    }
}
