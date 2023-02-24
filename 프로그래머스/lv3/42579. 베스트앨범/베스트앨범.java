import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> songs = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            
            if(songs.get(genres[i]) == null){
                PriorityQueue<Song> pq = new PriorityQueue<>();
                songs.put(genres[i], pq);
            }
            PriorityQueue<Song> curPq = songs.get(genres[i]);
            curPq.add(new Song(plays[i], i));
            songs.put(genres[i], curPq);
        }
    
        List<String> keySet = new LinkedList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        List<Integer> answerList = new LinkedList<>();
        for(int i = 0; i < keySet.size(); i++){
            PriorityQueue<Song> curPq = new PriorityQueue<>();
            curPq = songs.get(keySet.get(i));
            int cnt = 0;
            while(!curPq.isEmpty() && cnt < 2){
                answerList.add(curPq.poll().index);
                cnt++;
            }
        
        }
        int[] answer = new int [answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public class Song implements Comparable<Song>{
        int plays;
        int index;
        Song(int plays, int index){
            this.plays = plays;
            this.index = index;
        }
        @Override
        public int compareTo(Song o){
            return o.plays - this.plays;
        }
        
    }
}