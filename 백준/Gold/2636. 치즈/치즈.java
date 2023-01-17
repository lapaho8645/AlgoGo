import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int[][] pan = new int[R][C];
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                pan[i][j] = Integer.parseInt(input[j]);
                if (pan[i][j] == 1) cnt++;
                if (i == 0 || i == R - 1) {
                    queue1.add(new int[]{i, j});
                    visited[i][j] = true;
                }
                if ((j == 0 || j == C - 1) && !visited[i][j]) {
                    queue1.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            answer++;
            while (!queue1.isEmpty()) {
                int[] cur = queue1.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
                        if (pan[nr][nc] == 1) {
                            queue2.add(new int[]{nr, nc});
                            pan[nr][nc] = 0;
                        } else {
                            queue1.add(new int[]{nr, nc});
                        }
                        visited[nr][nc] = true;
                    }
                }
            }

            if(cnt - queue2.size() == 0) break;

            cnt -= queue2.size();
            while(!queue2.isEmpty()){
                queue1.add(queue2.poll());
            }
        }
        System.out.println(answer);
        System.out.println(cnt);
    }
}