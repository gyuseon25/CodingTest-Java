import java.util.*;

class Solution {
    
    private static int[] parent;
    public int solution(int n, int[][] computers) {
        
        parent = new int[n];        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < computers.length; i++) {
            int[] arr = computers[i];
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                else if(arr[j] == 1) {
                    if(find(i) == find(j)) continue;
                    else {
                        union(i, j);
                    }
                }
            }    
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(find(i));
        }
        
        return set.size();
    }
    
    private void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
    
    private int find(int x) {
        if(x == parent[x]) return x;
        
        parent[x] = find(parent[x]);
        
        return parent[x];
    }
}