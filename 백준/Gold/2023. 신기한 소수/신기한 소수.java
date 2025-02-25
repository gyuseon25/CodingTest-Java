import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int n;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 9; i++) {
            if(isPrime(i)) {
                DFS(i, 1);
            }
        }
        bw.flush();
        bw.close();
    }

    static void DFS(int num, int cnt) throws IOException {
        if(cnt == n) {
            bw.write(num + "\n");
            return;
        }
        for(int i = 1; i <= 9; i++) {
            int tmp = Integer.parseInt(String.valueOf(num).concat(String.valueOf(i)));
            if(isPrime(tmp)) {
                DFS(tmp, cnt+1);
            }
        }
    }

    static boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }
        for(int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
