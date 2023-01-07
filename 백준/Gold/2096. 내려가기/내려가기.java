import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[][] map = new int[N][3];
        int[][][] memo = new int[N][3][2];
        int[][] result = new int[3][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        // 0 -> 0, 1
        // 1 -> 0, 1, 2
        // 2 - > 1, 2
        int[][] possible = {{0, 1}, {0, 1, 2}, {1, 2}};
        for (int i = 0; i < 3; i++) {
            memo[0][i][0] = map[0][i];
            memo[0][i][1] = map[0][i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                memo[i][j][0] = memo[i - 1][possible[j][0]][0] + map[i][j];
                memo[i][j][1] = memo[i - 1][possible[j][0]][1] + map[i][j];
                for (int k = 1; k < possible[j].length; k++) {
                    memo[i][j][0] = Math.min(memo[i][j][0], memo[i - 1][possible[j][k]][0] + map[i][j]);
                    memo[i][j][1] = Math.max(memo[i][j][1], memo[i - 1][possible[j][k]][1] + map[i][j]);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, memo[N - 1][i][0]);
            max = Math.max(max, memo[N - 1][i][1]);
        }
        System.out.println(max + " " + min);
    }
}