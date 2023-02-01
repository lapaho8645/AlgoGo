import java.util.*;
class Solution {
    static long mod = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] map = new int[n+1][m+1];
        for(int i = 0; i < puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = 1;
        }
        long [][] dp = new long [n+1][m+1];
        
        for(int i = 1; i <= n; i++){
            if(map[i][1] != 1) dp[i][1] = 1;
            else break;
        }
        for(int j = 1; j <= m; j++){
            if(map[1][j] != 1) dp[1][j] = 1;
            else break;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= m; j++){
                if(map[i][j] == 1) continue;
                if(map[i-1][j] == 0 && map[i][j-1] == 0){
                    dp[i][j] = ((dp[i-1][j] % mod)+ (dp[i][j-1] % mod))% mod;
                }
                else if(map[i-1][j] == 0){
                    dp[i][j] = dp[i-1][j] % mod;
                }
                else if(map[i][j-1] == 0){
                    dp[i][j] = dp[i][j-1] % mod;
                }
            }
        }
        
        answer = (int)dp[n][m];
        return answer;
    }
}

// 0 0 0 0
// 0 1 0 0
// 0 0 0 0

// 0 1 1 1
// 1 - 1 2
// 1 1 2 4