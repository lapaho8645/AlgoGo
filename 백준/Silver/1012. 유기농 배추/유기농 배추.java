import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] check;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] input;
        for (int tc = 1; tc <= T; tc++) {
            input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);
            map = new int[N][M];
            check = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < K; i++) {
                input = br.readLine().split(" ");
                map[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
            }
            Queue<int[]> queue = new LinkedList<int[]>();
            int[] cur;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !check[i][j]) {
                        cnt++;
                        queue.add(new int[]{i, j});
                        check[i][j] = true;
                        while (!queue.isEmpty()) {
                            cur = queue.poll();
                            for (int d = 0; d < 4; d++) {
                                int nr = cur[0] + dr[d];
                                int nc = cur[1] + dc[d];
                                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !check[nr][nc]) {
                                    check[nr][nc] = true;
                                    queue.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }

    }
}