import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        if (N > K) {
            System.out.println(N - K);
            return;
        }
        int[] dp = new int[K * 2 + 1];
        int INF = 1000001;
        Arrays.fill(dp, INF);
        dp[N] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur * 2 <= K * 2 && dp[cur * 2] == INF) {
                dp[cur * 2] = dp[cur];
                queue.add(cur * 2);
            }
            if (cur - 1 >= 0 && dp[cur - 1] == INF) {
                dp[cur - 1] = dp[cur] + 1;
                queue.add(cur - 1);
            }
            if (cur + 1 <= K * 2 && dp[cur + 1] == INF) {
                dp[cur + 1] = dp[cur] + 1;
                queue.add(cur + 1);
            }
        }
        System.out.println(dp[K]);
    }
}