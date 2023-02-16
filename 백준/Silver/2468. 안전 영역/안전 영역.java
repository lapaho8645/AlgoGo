import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Set<Integer> set = new HashSet<>();
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                set.add(map[i][j]);
            }
        }
        List<Integer> list = new LinkedList<>(set);
        Collections.sort(list);
        int answer = 1;
        for (int i = 0; i < list.size(); i++){
            flooding(list.get(i));
            answer = Math.max(answer, safeArea());
        }
        System.out.println(answer);
    }

    public static void flooding(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != -1 && map[i][j] <= num) {
                    map[i][j] = -1;
                }
            }
        }
    }

    public static int safeArea() {
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] == -1) continue;
                cnt++;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] != -1) {
                            visited[nr][nc] = true;
                            queue.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
       return cnt;
    }
}