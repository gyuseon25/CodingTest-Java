import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();


        long count = gcd(b, a);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < count; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    static long gcd(long a, long b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
