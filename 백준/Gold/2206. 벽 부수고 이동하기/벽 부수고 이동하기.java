import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M, min = Integer.MAX_VALUE, map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[0].charAt(j) - '0';
            }
        }
        boolean[][][] check = new boolean[2][N][M];
        check[0][0][0] = true;
        check[1][0][0] = true;
        Queue<Place> queue = new LinkedList<>();
        queue.add(new Place(0, 0, 1, false));
        while (!queue.isEmpty()) {
            Place cur = queue.poll();
            if (cur.r == N - 1 && cur.c == M - 1) {
                min = cur.cnt;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0) {
                        if (!cur.chance && !check[0][nr][nc]) {
                            check[0][nr][nc] = true;
                            queue.add(new Place(nr, nc, cur.cnt + 1, cur.chance));
                        } else if (cur.chance && !check[1][nr][nc]) {
                            check[1][nr][nc] = true;
                            queue.add(new Place(nr, nc, cur.cnt + 1, cur.chance));
                        }
                    } else if (!cur.chance && !check[1][nr][nc]) {
                        check[1][nr][nc] = true;
                        queue.add(new Place(nr, nc, cur.cnt + 1, true));
                    }
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static class Place {
        int r;
        int c;
        int cnt;
        boolean chance;

        public Place(int r, int c, int cnt, boolean chance) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.chance = chance;
        }
    }
}