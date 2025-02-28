import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> ppq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> npq = new PriorityQueue<>();
        int zeroCount = 0;
        int oneCount = 0;

        if(n == 1) {
            System.out.print(sc.nextInt());
            return;
        }

        for(int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            if(tmp == 1) oneCount++;
            else if(tmp > 0) ppq.offer(tmp);
            else if(tmp < 0) npq.offer(tmp);
            else zeroCount++;
        }

        int data1 = 0;
        int data2 = 0;
        int sum = 0;

        while(!ppq.isEmpty()) {
            if(ppq.size() == 1){
                sum += ppq.poll();
                break;
            }
            data1 = ppq.poll();
            data2 = ppq.poll();
            sum += (data1 * data2);
        }

        while(!npq.isEmpty()) {
            if(npq.size() == 1 ) {
                if(zeroCount == 0) {
                    sum += npq.poll();
                }
                break;
            }
            data1 = npq.poll();
            data2 = npq.poll();
            sum += (data1 * data2);
        }

        sum += oneCount;

        System.out.print(sum);
    }
}
