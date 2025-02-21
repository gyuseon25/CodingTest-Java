import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int n1 = Math.abs(o1);
            int n2 = Math.abs(o2);
            if(n1 == n2) {
                if(o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return n1 - n2;
            }
        });

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++) {
            int req = Integer.parseInt(br.readLine());
            if(req == 0) {
                if(pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()+"\n");
                }
            } else {
                pq.offer(req);
            }
        }

        System.out.print(sb);
    }
}
