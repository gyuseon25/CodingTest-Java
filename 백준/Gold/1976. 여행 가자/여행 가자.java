import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dosi = new int[n+1][n+1];

        parent = new int[n+1];
        for(int i = 0; i <= n ; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dosi[i][j] = sc.nextInt();
            }
        }
        int[] route = new int[m+1];
        for(int i = 1; i <= m; i++) {
            route[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(dosi[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int idx = find(route[1]);
        for(int i = 2; i <= m; i++) {
            if(idx != find(route[i])) {
                System.out.print("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) {
            parent[fb] = fa;
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        else {
            return parent[a] = find(parent[a]);
        }
    }

}
