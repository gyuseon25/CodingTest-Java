import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> charArr = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0, idx = 0, num = 1;
        while(cnt < n) {
            if(arr[idx] > num) {
                stack.push(num++);
                charArr.add('+');
            } else if(arr[idx] == num) {
                stack.push(num++);
                charArr.add('+');
                stack.pop();
                charArr.add('-');
                cnt++;
                idx++;
            } else {
                if(arr[idx] == stack.peek()) {
                    stack.pop();
                    charArr.add('-');
                    cnt++;
                    idx++;
                } else {
                    System.out.print("NO");
                    return;
                }
            }
        }

        for (Character c : charArr) {
            System.out.println(c);
        }
    }
}
