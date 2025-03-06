import java.util.Scanner;

public class Main {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int q = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(q == 0) {
                union(a,b);
            } else {
                boolean check = checkSame(a,b);
                if (check) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) parent[fb] = fa;
    }

    static int find(int v) {
        if(v == parent[v]) {
            return v;
        } else {
            return parent[v] = find(parent[v]);
        }
    }

    static boolean checkSame(int a, int b){
        if(find(a) == find(b)) return true;
        else return false;
    }
}