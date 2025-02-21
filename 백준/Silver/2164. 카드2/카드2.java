import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        while(deque.size() > 1) {
            deque.removeFirst();
            deque.addLast(deque.removeFirst());
        }

        System.out.println(deque.getFirst());
    }
}
