import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int [] dr = {0, 0, -1, 1};
    static int [] dc = {-1, 1, 0, 0};
    static int N, M, map[][], min;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int [N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = input[0].charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(min);
    }
    public static void bfs(){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int [] {0, 0, 1});
        while(!queue.isEmpty()){
            int [] cur = queue.poll();
            if(cur[0] == N-1 && cur[1] == M-1){
                min = cur[2];
                break;
            }
            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int []{nr, nc, cur[2] + 1});
                }
            }
        }
    }
}