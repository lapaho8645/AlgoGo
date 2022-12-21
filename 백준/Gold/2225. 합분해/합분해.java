import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mod = 1000000000;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [][] dp = new int [N+1][K+1];
        for(int i = 1; i <= N; i++){
           dp[i][1] = 1;
        }
        for(int i = 1; i <= K; i++){
            dp[1][i] = i;
        }
        for(int i = 2; i <= N; i++){
            for(int j = 2; j <= K; j++){
                dp[i][j] = (dp[i-1][j] % mod + dp[i][j-1] % mod) % mod;
            }
        }
        System.out.println(dp[N][K]);
    }
}