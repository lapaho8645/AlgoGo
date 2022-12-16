import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int [] prevdp = triangle[0];
        for(int i = 1; i < triangle.length; i++){
            int [] dp = new int [triangle[i].length];
            dp[0] = prevdp[0] + triangle[i][0];
            for(int j = 1; j < triangle[i].length-1; j++){
                dp[j] = Math.max(prevdp[j-1] + triangle[i][j], prevdp[j] + triangle[i][j]);
            }
            dp[triangle[i].length-1] = prevdp[triangle[i].length-2] + triangle[i][triangle[i].length-1];
            prevdp = dp;
        }
        for(int i =0 ; i < prevdp.length; i++){
            answer = answer < prevdp[i] ? prevdp[i] : answer;
        }
        return answer;
    }
}
