import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int start = 0, end = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > start) {
                start = arr[i];
            }
            end += arr[i];
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if(sum != 0) {
                count++;
            }
            if(count > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
