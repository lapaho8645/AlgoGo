import java.util.*;
class Solution {
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        Queue<locate> queue = new LinkedList<>();
        queue.add(new locate(0,0));
        int m = maps[0].length;
        int n = maps.length;
        boolean [][] visited = new boolean[n][m];
        System.out.println("n :" + n + " m : " + m);
        boolean isPossible = false;
        while(!queue.isEmpty()){
            locate cur = queue.poll();
            visited[cur.x][cur.y] = true;
            System.out.println(cur.x + " : " + cur.y);
            answer++;
            if(cur.x == n-1 && cur.y == m-1){
                isPossible = true;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
  
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1){
                    queue.add(new locate(cur.x + dx[i],cur.y + dy[i]));
                }
            }
            
       }
        return isPossible ? answer : -1;
    }
    class locate{
        int x;
        int y;
        public locate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}