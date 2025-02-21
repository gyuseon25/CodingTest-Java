import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        data[] sorted = new data[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sorted[i] = new data(arr[i], i);
        }
        Arrays.sort(sorted);

        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, sorted[i].index - i);
        }

        System.out.println(answer + 1);
    }

    static class data implements Comparable<data> {
        int value;
        int index;

        public data(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(data o) {
            return this.value - o.value;
        }
    }
}
