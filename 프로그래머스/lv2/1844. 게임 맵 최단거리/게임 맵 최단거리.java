import java.util.*;
class Solution {
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    public int solution(int[][] maps) {
        int answer = 0;
        
        Queue<locate> queue = new LinkedList<>();
        queue.add(new locate(0,0));
        int m = maps[0].length;
        int n = maps.length;
        int [][] visited = new int[n][m];
        visited[0][0] = 1;
        boolean isPossible = false;
        while(!queue.isEmpty()){
            locate cur = queue.poll();
        
            if(cur.x == n-1 && cur.y == m-1){
                isPossible = true;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] > 0 || maps[nx][ny] == 0)
                    continue;

                queue.add(new locate(cur.x + dx[i],cur.y + dy[i]));
                visited[nx][ny] = visited[cur.x][cur.y] + 1;
               
            }
            
       }
        return isPossible ? visited[n-1][m-1] : -1;
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