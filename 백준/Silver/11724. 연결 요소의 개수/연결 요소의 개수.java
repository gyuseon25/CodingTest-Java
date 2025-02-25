import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int j = 1; j <= m; j++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.print(count);
    }

    static void DFS(int v){
        if(visited[v]) return;
        visited[v] = true;
        for(int i : arr[v]) {
            if(!visited[i])
                DFS(i);
        }
    }
}
