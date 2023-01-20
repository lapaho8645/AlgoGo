import java.util.*;
class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++){
            if(k >= dungeons[i][0]){
                boolean [] visited = new boolean [dungeons.length];
                visited[i] = true;
                move(k-dungeons[i][1], 1, dungeons, visited);
            }
        }
        
        int answer = max;
        return answer;
    }
    public void move(int remain, int cnt, int [][] dungeons, boolean [] visited){
       
            int sum = 0; 
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) sum++;
            }
            max = Math.max(max, sum);
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && remain >= dungeons[i][0]){
                visited[i] = true;
                move(remain - dungeons[i][1], cnt+1, dungeons, visited);
                visited[i] = false;
            }
        }
    }
    
    
}