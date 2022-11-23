import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int arr1C = arr1[0].length;     // 2
        int arr1R = arr1.length;        // 3
        int arr2C = arr2[0].length;     //2
        int arr2R = arr2.length;        //2
     
        int[][] answer = new int [arr1R][arr2C];
     
        for(int i = 0; i < arr1R; i++){
            for(int j = 0; j < arr2C; j++){
                int sum = 0;
                for(int k = 0; k < arr1C; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }
                 answer[i][j] = sum;
            }
        }
        return answer;
    }
}

