import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] NGE = new int[n];
        Arrays.fill(NGE, -1);
        Stack<Integer> stack = new Stack<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                NGE[i] = -1;
                stack.push(arr[i]);
                continue;
            }
            NGE[i] = stack.peek();
            stack.push(arr[i]);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(NGE[i]).append(" ");
        }
        System.out.println(sb);
    }
}
