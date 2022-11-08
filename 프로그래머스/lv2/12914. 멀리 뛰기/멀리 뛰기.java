class Solution {
    public long solution(int n) {
        long dp [] = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2 ; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}
// 1 -> 1칸
// 2 -> 1 + 1
//    -> 2
// 3 -> dp[n-1] + dp[n-2];
//   -> 1 + 2;
//    -> 1 + 1 + 1
//    -> 2 + 1
// 4 -> 1 + 1 + 1 +1
//        2 + 1 + 1
//        1 + 2 + 1
//        1 + 1 + 2
//        2 + 2