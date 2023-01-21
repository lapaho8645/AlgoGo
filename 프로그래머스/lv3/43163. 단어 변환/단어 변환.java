import java.util.*;
class Solution {
    public class wordE{
        String word;
        int cnt;
        wordE(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<wordE> queue = new LinkedList<>();
        boolean visited[] = new boolean[words.length];
        boolean check = false;
        for(int i = 0; i < words.length; i++){
            if(isPossible(begin, words[i])){
                queue.add(new wordE(words[i], 1));
            }
            if(target.equals(words[i])) check = true;
        }
        if(!check) return answer;        
        while(!queue.isEmpty()){
            wordE cur = queue.poll();
            if(cur.word.equals(target)){
                answer = cur.cnt;
                break;
            }
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && isPossible(cur.word, words[i])){
                    visited[i] = true;
                    queue.add(new wordE(words[i], cur.cnt+1));
                }
            }
        }
       
        return answer;
    }
    public boolean isPossible(String s1, String s2){
        int total = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                total++;
            }
            if(total > 1) break;
        }
        return total == 1 ? true : false;
    }
}