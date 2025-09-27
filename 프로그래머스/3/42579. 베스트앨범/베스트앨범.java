import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        TreeSet<Genre> genreSet = new TreeSet<>();
        HashMap<String, ArrayList<Music>> musicMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            int uid = i;
            
            map.put(genre, map.getOrDefault(genre, 0) + play);
            
            Music music = new Music(uid, play);
            musicMap.putIfAbsent(genre, new ArrayList<>());
            musicMap.get(genre).add(music);
        }
        
        for(String s : map.keySet()) {
            Genre genre = new Genre(s, map.get(s));
            genreSet.add(genre);
        }
        
        for(Genre g : genreSet) {
            String genreName = g.name;
            ArrayList<Music> list = musicMap.get(genreName);
            Collections.sort(list);
            int count = 0;
            for(Music m : list) {
                if(count >= 2) break;
                answer.add(m.uid);
                count++;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Genre implements Comparable<Genre> {
        String name;
        int total;
        
        public Genre(String name, int total) {
            this.name = name;
            this.total = total;
        }
        
        @Override
        public int compareTo(Genre o) {
            return o.total - this.total;
        }
    }
    
    class Music implements Comparable<Music> {
        int uid;
        int play;
        
        public Music(int uid, int play) {
            this.uid = uid;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music o) {
            if(this.play == o.play) return this.uid - o.uid;
            return o.play - this.play;
        }
    }
}