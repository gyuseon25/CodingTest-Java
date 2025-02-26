import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            String str = br.readLine();
            for(int j = 1; j <= m; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        BFS(1,1);
        System.out.print(arr[n][m]);

    }

    static void BFS(int x, int y) {
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Coordinate tmp = q.poll();
            visited[tmp.x][tmp.y] = true;
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    if(arr[nx][ny] != 0 && !visited[nx][ny]){
                        q.offer(new Coordinate(nx, ny));
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[tmp.x][tmp.y] + 1;
                    }
                }
            }
        }
    }

    static class Coordinate {
        int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
