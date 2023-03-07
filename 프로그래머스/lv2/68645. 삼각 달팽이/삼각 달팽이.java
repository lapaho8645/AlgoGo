import java.util.*;
class Solution {
    static int [] dr = {0, 1, 0, -1};   //좌하우상
    static int [] dc = {-1, 0, 1, 0};
    public int[] solution(int n) {
        int total = 0;
        for(int i = 1; i <= n; i++){
            total += i;
        }
        int row = 1;
        int col = n;
        int dir = 0;
        int [][] block = new int [n+1][n+1];
        int[] answer = new int[total];
        int [] count = new int [n+1];
        for(int i = 1; i <= total; i++){
            block[row][col] = i;
            count[row]++;
            if(row + dr[dir] < 1 || row + dr[dir] > n || 
               col + dc[dir] < 1 || col + dc[dir] > n || count[row] >= row){
                dir = (dir + 1) % 4;
            }
            if(row + dr[dir]>= 1 && row + dr[dir]<= n && col >=1 && row <= n && count[row + dr[dir]] == row + dr[dir]){
                dir = 1;
            }
            
            row += dr[dir];
            if(dir == 1)
                col -= 1;
            else{
                 col += dc[dir];
            }
           
            if(row >= 1 && row <= n && col >=1 && row <= n && block[row][col] != 0){
                row -= dr[dir];
                col += 1;
                dir = (dir + 1) % 4;
                row += dr[dir];
                col += dc[dir];
            }
           
            
        }
        int index = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(block[i][j] != 0){
                    answer[index++] = block[i][j];
                }
            }
        }
        
        return answer;
    }
}
