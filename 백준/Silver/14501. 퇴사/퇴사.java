import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int time = sc.nextInt();
            int profit = sc.nextInt();
            dp[i] = Math.max(dp[i - 1], dp[i]);
            if (i + time - 1 > N) continue;
            dp[i + time - 1] = Math.max(dp[i + time - 1], dp[i - 1] + profit);
        }

        System.out.println(dp[N]);
    }
}