import java.util.*;

class Solution {
    
    List<Node> nodes;
    int len;
    
    private class Node implements Comparable<Node> {
        int num, x, y;
        Node left, right;
        
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
            left = null;
            right = null;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.y ==  o.y) return this.x - o.x;
            return o.y - this.y;
        }
    }
    
    
    public int[][] solution(int[][] nodeinfo) {
        len = nodeinfo.length;
        nodes = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            int[] info = nodeinfo[i];
            nodes.add(new Node(i+1, info[0], info[1]));
        }
        
        Collections.sort(nodes);
        
        Node root = nodes.get(0);
        
        for (int i = 1; i < len; i++) {
            insert(root, nodes.get(i));
        }
        
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        preorder(root, pre);
        postorder(root, post);

        return new int[][]{
            pre.stream().mapToInt(Integer::intValue).toArray(),
            post.stream().mapToInt(Integer::intValue).toArray()
        };
    }
    
    private void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    // 가 -> 왼 -> 오
    private void preorder(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.num);
        preorder(node.left, result);
        preorder(node.right, result);
    }
    
    // 왼 -> 오 -> 가
    private void postorder(Node node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.num);
    }
    
}