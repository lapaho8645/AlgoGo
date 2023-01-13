import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] tri = new int [n][n];
        int [][] dp = new int [n][n];

        String [] input = br.readLine().split(" ");
        tri[0][0] = Integer.parseInt(input[0]);
        dp[0][0] = tri[0][0];
        int max = dp[0][0];
        for(int i = 1; i < n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < input.length; j++){
                tri[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = dp[i-1][j] + tri[i][j];
                if(j-1 >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + tri[i][j]);
                }
                if(i == n - 1){
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        
        System.out.println(max);

        // i+1, j or j+1, j+1
    }
}