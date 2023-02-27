import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int totalIce;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] != 0) totalIce++;
            }
        }
        int answer = 0;
        while (true) {
            if (totalIce == 0) {
                answer = 1;
                break;
            }
            answer++;
            int check = 0;
            for (int i = 0; i < N; i++) {
                int[] result = new int[]{-1, 0};
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        check++;
                        result = bfs(i, j, new boolean[N][M]);
                        totalIce -= result[1];
                    }
                    if (result[0] == totalIce + result[1]) break;
                }
                if (result[0] == totalIce + result[1]) break;
            }
            if (check >= 2) break;
        }

        System.out.println(answer - 1);
    }

    public static int[] bfs(int r, int c, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> temp = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        int iceCnt = 0;
        int zeroCnt = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (!visited[nr][nc] && map[nr][nc] <= 0)
                    cnt++;
                else if (!visited[nr][nc] && map[nr][nc] > 0) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
            temp.add(new int[]{cur[0], cur[1], cnt});
            iceCnt++;
        }
        while (!temp.isEmpty()) {
            int[] cur = temp.poll();
            map[cur[0]][cur[1]] -= cur[2];
            if (map[cur[0]][cur[1]] <= 0) {
                zeroCnt++;
            }
        }
        return new int[]{iceCnt, zeroCnt};
    }
}