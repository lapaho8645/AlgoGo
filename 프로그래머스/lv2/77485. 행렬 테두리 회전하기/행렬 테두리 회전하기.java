import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int [][] map = new int [rows+1][columns+1];
      
  
        for(int i= 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                map[i][j] = ((i-1) * columns + j);
            }
        }
    
        for(int i = 0; i < queries.length; i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            int firstNum = map[x1][y1];
            int temp1 = map[x1][y2];
            
            int min = Integer.MAX_VALUE;
            min = Math.min(min, map[x1][y2]);
            
            for(int j = y2; j > y1; j--){
                map[x1][j] = map[x1][j-1]; 
                min = Math.min(min, map[x1][j]);
            }
           
            int temp2 = map[x2][y2];
            min = Math.min(min, map[x2][y2]);
            for(int j = x2; j > x1; j--){
                map[j][y2] = map[j-1][y2];
                min = Math.min(min, map[j][y2]);
            }
           
        
            int temp3 = map[x2][y1];
            min = Math.min(min, map[x2][y1]);
            for(int j = y1; j < y2; j++){
                map[x2][j] = map[x2][j+1]; 
                min = Math.min(min, map[x2][j]);
            }
            
           
            for(int j = x1; j < x2; j++){
                map[j][y1] = map[j+1][y1];
                min = Math.min(min, map[j][y1]);
            }
            
          
             map[x1+1][y2] = temp1;
             map[x2][y2-1] = temp2;
             map[x2-1][y1] = temp3;
             answer[i] = min;
        }
        return answer;
    }
}