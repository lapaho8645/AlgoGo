import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int [] dr = {0, 0, -1, 1, -1, -1, 1, 1};
    static int [] dc = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int w, h, map[][];
    static boolean visited[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0) break;
            visited = new boolean[h][w];
            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void dfs(int r, int c){
        visited[r][c] = true;
        for(int d= 0; d < 8; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1){
                dfs(nr, nc);
            }
        }
    }
}