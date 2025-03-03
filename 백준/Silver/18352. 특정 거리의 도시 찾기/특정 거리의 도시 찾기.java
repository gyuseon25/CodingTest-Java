import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> arr;
    static int[] check;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        check = new int[n+1];
        Arrays.fill(check, -1);
        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.get(s).add(e);
        }

        BFS(x);

        for(int i = 1; i <= n; i++) {
            if(check[i] == k) {
                answer.add(i);
            }
        }

        if(answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (Integer i : answer) {
                System.out.println(i);
            }
        }
    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        check[x]++;

        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            ArrayList<Integer> tmpList = arr.get(tmp);

            for(int i : tmpList) {
                if(check[i] == -1) {
                    check[i] = check[tmp] + 1;
                    queue.offer(i);
                }
            }
        }

    }
}
