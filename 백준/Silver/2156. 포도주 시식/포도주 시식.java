import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] input = new int[n+1];
        int [][] dp = new int[n+1][2];
        for(int i = 1; i <= n; i++){
            input[i] = sc.nextInt();
        }
        dp[1][0] = dp[1][1] = input[1];
        int max = dp[1][0];
        for(int i = 2; i <= n; i++){
            if(i-2 <= 0){
                dp[i][0] = input[i];
                dp[i][1] = dp[i-1][0] + input[i];
                max = dp[i][1];
                continue;
            }
            dp[i][0] = Math.max(Math.max(dp[i-3][0], dp[i-3][1]) ,Math.max(dp[i-2][0], dp[i-2][1])) + input[i];   //첫번째일때
            dp[i][1] = dp[i-1][0] + input[i];         //두번째일때

            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        
        System.out.println(max);
    }
}