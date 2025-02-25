import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arrive = false;
        visited = new boolean[n];
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        
        for(int i = 0; i < n; i++) {
           DFS(i, 1); 
        }
        
        if(arrive) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    static void DFS(int num, int depth) {
        if(depth == 5) {
            arrive = true;
            return;
        }
        visited[num] = true;
        for(int i : arr[num]) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(i, depth+1);
            }
        }
        visited[num] = false;
    }
}
