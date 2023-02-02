import java.util.Scanner;

public class Main {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] map, dp;
    static int n, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 1)
                    max = Math.max(max, dfs(i, j));
            }
        }

        System.out.println(max);
    }

    public static int dfs(int r, int c) {
        if (dp[r][c] > 1) return dp[r][c];

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (map[r][c] < map[nr][nc]) {
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
            }
        }
        return dp[r][c];
    }
}
