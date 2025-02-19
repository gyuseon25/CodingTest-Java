import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<Node> dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && dq.getLast().value > now) {
                dq.removeLast();
            }
            dq.addLast(new Node(i, now));
            if(dq.getFirst().index <= i - l) {
                dq.removeFirst();
            }
            bw.write(dq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        int index, value;

        public Node(int index, int num) {
            this.index = index;
            this.value = num;
        }
    }
}