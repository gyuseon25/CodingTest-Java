import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.next(), "+-", true);

        char pre = '0';
        int sum = 0;
        sum += Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()) {
            String now = st.nextToken();
            if(now.equals("-")) {
                pre = '-';
            } else if(now.equals("+")) {
                if(pre != '-') {
                    pre = '+';
                }
            } else {
                if(pre == '-')
                    sum -= Integer.parseInt(now);
                else
                    sum += Integer.parseInt(now);
            }
        }
        System.out.print(sum);
    }
}
