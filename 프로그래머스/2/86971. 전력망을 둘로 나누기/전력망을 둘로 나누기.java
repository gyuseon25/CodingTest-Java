class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] wires) {
        
        parent = new int[n + 1];
        
        int answer = Integer.MAX_VALUE;
        
        for(int[] w1 : wires) {
            init(n);
            int a = w1[0];
            int b = w1[1];
            
            for(int[] w2 : wires) {
                int a2 = w2[0];
                int b2 = w2[1];
                if(a == a2 && b == b2) continue;
                
                union(a2, b2);
            }
            
            int ac = 1, bc = 0;
            int pa = find(1);
            int pb = Integer.MAX_VALUE;
            for(int i = 2 ; i <= n; i++) {
                if(find(i) != pa) pb = find(i);
                
                if(find(i) == pa) ac++;
                if(find(i) == pb) bc++;
            }
            answer = Math.min(Math.abs(ac - bc), answer);
        }
        
        return answer;
    }
    
    private void init(int n) {
        for(int i = 1; i <= n ; i++) {
            parent[i] = i;
        }
    }
    
    private int find(int x) {
        if(parent[x] == x) return x;
        
        parent[x] = find(parent[x]);
        
        return parent[x];
    }
    
    private void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        parent[root2] = root1;
    }
}