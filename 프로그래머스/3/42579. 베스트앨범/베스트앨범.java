import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, List<IndexAndPlays>> info = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            map.put(genre, map.getOrDefault(genre, 0) + plays[i]);
            
            IndexAndPlays tmp = new IndexAndPlays(i, plays[i]);
            List<IndexAndPlays> list = info.getOrDefault(genre, new ArrayList<IndexAndPlays>());
            list.add(tmp);
            info.put(genre, list);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        for(String genre : keySet) {
            List<IndexAndPlays> list = info.get(genre);
            Collections.sort(list);
            
            for (int i = 0; i < Math.min(2, list.size()); i++) {
                answer.add(list.get(i).idx);
            }
        }
            
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
    
    class IndexAndPlays implements Comparable<IndexAndPlays> {
        int idx;
        int play;
        public IndexAndPlays(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }

        @Override
        public int compareTo(IndexAndPlays o) {
            if (this.play == o.play) {
                return this.idx - o.idx;
            }
            return o.play - this.play;
        }
    }
}