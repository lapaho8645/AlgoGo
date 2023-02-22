import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, map[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        int cnt = 0;
        while (true) {
            cnt++;
            boolean[][] visited = new boolean[N][N];
            int num = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    bfs(i, j, L, R, visited);
                    num++;
                }
            }
            if (num == N * N) break;

        }
        System.out.println(cnt - 1);
    }

    public static void bfs(int r, int c, int L, int R, boolean[][] visited) {
        ArrayList<int[]> arr = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{r, c});
        int sum = 0;
        int cnt = 0;
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            arr.add(new int[]{cur[0], cur[1]});
            sum += map[cur[0]][cur[1]];
            cnt++;
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                int diff = Math.abs(map[cur[0]][cur[1]] - map[nr][nc]);
                if (diff >= L && diff <= R && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }

        }
        for (int i = 0; i < arr.size(); i++) {
            map[arr.get(i)[0]][arr.get(i)[1]] = sum / cnt;
        }

    }
}
// L <= 인구 차이 <= R
// bfs 현재 위치에서 오른쪽, 아래만 고려
// list에 담아놓고