import java.util.*;

class Solution {
    
    class Node {
        int dest;
        int time;
        
        public Node(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        
        for(int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int time = r[2];
            
            adjList[a].add(new Node(b, time));
            adjList[b].add(new Node(a, time));
        }
        
        int[] times = new int[N + 1];
        Arrays.fill(times, Integer.MAX_VALUE);
        
        times[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(times[now.dest] < now.time) continue;
            
            for(Node next : adjList[now.dest]) {
                if(times[next.dest] > now.time + next.time) {
                    times[next.dest] = now.time + next.time;
                    pq.add(new Node(next.dest, times[next.dest]));
                }
            }
        }
        
        int answer = 0;
        for(int t : times) {
            if(t <= K) answer++;
        }
        
        return answer;
    }
}