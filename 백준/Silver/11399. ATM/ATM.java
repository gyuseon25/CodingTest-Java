import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++) {
            int insert_Idx = 0;
            int num = arr[i];

            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < num) {
                    insert_Idx = j+1;
                    break;
                }
            }
            for(int j = i; j > insert_Idx; j--) {
                arr[j] = arr[j-1];
            }
            arr[insert_Idx] = num;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                sum += arr[j];
            }
        }

        System.out.print(sum);

    }
}
