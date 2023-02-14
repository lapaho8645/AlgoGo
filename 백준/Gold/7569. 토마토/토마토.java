import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dh = {-1, 0, 1};
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);    //가로
        int N = Integer.parseInt(input[1]);      //세로
        int H = Integer.parseInt(input[2]);
        int[][][] box = new int[H][N][M];
        Queue<Tomato> queue = new LinkedList<>();
        int totalCnt = 0;
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                input = br.readLine().split(" ");
                for (int c = 0; c < M; c++) {
                    box[h][r][c] = Integer.parseInt(input[c]);
                    if (box[h][r][c] == 1) {
                        queue.add(new Tomato(r, c, h, 0));
                    }
                    if (box[h][r][c] == 0) {
                        totalCnt++;
                    }
                }
            }
        }
        int max = 0;
        if (totalCnt > 0) {
            while (!queue.isEmpty()) {
                Tomato cur = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && box[cur.h][nr][nc] == 0) {
                        box[cur.h][nr][nc] = 1;
                        max = Math.max(cur.day + 1, max);
                        totalCnt--;
                        queue.add(new Tomato(nr, nc, cur.h, cur.day + 1));
                    }
                }
                if (cur.h - 1 >= 0 && box[cur.h - 1][cur.r][cur.c] == 0) {
                    box[cur.h - 1][cur.r][cur.c] = 1;
                    max = Math.max(cur.day + 1, max);
                    totalCnt--;
                    queue.add(new Tomato(cur.r, cur.c, cur.h - 1, cur.day + 1));
                }
                if (cur.h + 1 < H && box[cur.h + 1][cur.r][cur.c] == 0) {
                    box[cur.h + 1][cur.r][cur.c] = 1;
                    max = Math.max(cur.day + 1, max);
                    totalCnt--;
                    queue.add(new Tomato(cur.r, cur.c, cur.h + 1, cur.day + 1));
                }
            }
        }

        if (totalCnt > 0) max = -1;
        System.out.println(max);
    }

    public static class Tomato {
        int r, c, h, day;

        Tomato(int r, int c, int h, int day) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.day = day;
        }
    }

}