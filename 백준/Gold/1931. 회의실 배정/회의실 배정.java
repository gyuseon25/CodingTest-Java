import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Meeting[] arr = new Meeting[n];

        for(int i = 0; i < n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[i] = new Meeting(s, e);
        }

        Arrays.sort(arr);

        int count = 0;

        int end = -1;

        for(int i = 0; i < n; i++) {
            int start = arr[i].start;
            if(start >= end) {
                end = arr[i].end;
                count++;
            }
        }

        System.out.print(count);
    }

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }
}
