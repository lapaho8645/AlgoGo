import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int [][] result = new int[land.length][land[0].length];
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(i == 0) result[i][j] = land[i][j];
                else{
                    result[i][j] = land[i][j];
                    for(int k = 1; k < land[0].length; k++){
                        result[i][j] = Math.max(result[i][j], result[i-1][(j+k)%land[0].length] + land[i][j]);
                    }
                }
                answer = Math.max(answer, result[i][j]);
            }
        }
    
        return answer;
    }
}