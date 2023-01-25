import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] input = new int[N + 1];
        int[][] dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            input[i] = sc.nextInt();
            dp[i][0] = input[i];
            dp[i][1] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] += dp[i - 1][0];
            dp[i][1] = dp[i - 1][1] + 1;
            while (dp[i][0] - input[i - dp[i][1] + 1] >= S) {
                dp[i][0] -= input[i - dp[i][1]  + 1];
                dp[i][1] --;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if(dp[i][0] >= S && dp[i][1] <= result)
                result = dp[i][1];
        }
        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
// dp
// (5,1) (6,2) (9,3), (14,4), (15, 2), (17,2) (21, 3), (20, 3), (15, 3), (19,3)