import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] value = new int[n];
        int[] dp = new int[100001];
        int INF = 100001;
        Arrays.fill(dp, INF);
        boolean isPossible = false;
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
            dp[value[i]] = 1;
            if (value[i] <= k) isPossible = true;
        }
        if (!isPossible) System.out.println(-1);
        else {
            Arrays.sort(value);
            for (int i = 0; i < value.length - 1; i++) {
                for (int j = value[i]; j < value[i + 1]; j++) {
                }
            }
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - value[j] >= 0 && dp[i - value[j]] != INF) {
                        dp[i] = Math.min(dp[i], dp[i - value[j]] + 1);
                    }
                }
            }
            System.out.println(dp[k] == INF ? -1 : dp[k]);
        }
    }
}