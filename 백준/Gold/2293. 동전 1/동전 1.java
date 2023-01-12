import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] input = new int [n];
        int [] dp = new int [k+1];
        for(int i = 0; i < n; i++){
            input[i] = sc.nextInt();
        }
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k; j++){
                if(j-input[i] < 0)
                    continue;
                dp[j] += dp[j-input[i]];
            }
        }

        System.out.println(dp[k]);
    };

}