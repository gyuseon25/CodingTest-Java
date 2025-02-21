import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int[] arr = new int[len];

        for(int i = 0; i < len; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        for(int i = 0; i < len; i++) {
            int idx = 0;
            int max = Integer.MIN_VALUE;
            for(int j = i; j < len; j++) {
                if(max < arr[j]) {
                    idx = j;
                    max = arr[j];
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        StringBuffer sb = new StringBuffer();
        for(int i : arr) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}
