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
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        for(int i = 1; i <= n; i++) {
            Collections.sort(arr[i]);
        }
        DFS(v);
        System.out.println();
        Arrays.fill(visited, false);
        BFS(v);
    }

    static void DFS(int v) {
        System.out.print(v + " ");
        visited[v] = true;
        for(int i : arr[v]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        while(!q.isEmpty()) {
            int tmp = q.poll();
            System.out.print(tmp + " ");
            for(int i : arr[tmp]) {
                if(!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
