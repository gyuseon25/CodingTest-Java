import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge>[] arr;
    static boolean[] visited;
    static int[] distance;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        arr = new ArrayList[v+1];
        for(int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            ArrayList<Edge> tmp = arr[now];
            while(true) {
                int node = Integer.parseInt(st.nextToken());
                if(node == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                tmp.add(new Edge(node, cost));
            }
        }

        visited = new boolean[v+1];
        distance = new int[v+1];
        BFS(1);
        int idx = 0;
        for(int i = 1; i <= v; i++) {
            if(distance[i] > max) {
                max = distance[i];
                idx = i;
            }
        }

        visited = new boolean[v+1];
        distance = new int[v+1];
        BFS(idx);
        for(int i : distance) {
            max = Math.max(max, i);
        }

        System.out.print(max);
    }

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.offer(v);
        while(!q.isEmpty()) {
            int tmp = q.poll();
            ArrayList<Edge> tmpList = arr[tmp];
            for(Edge e : tmpList) {
                if(!visited[e.node]) {
                    visited[e.node] = true;
                    distance[e.node] = distance[tmp] + e.cost;
                    q.offer(e.node);
                }
            }
        }
    }

    static class Edge {
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
