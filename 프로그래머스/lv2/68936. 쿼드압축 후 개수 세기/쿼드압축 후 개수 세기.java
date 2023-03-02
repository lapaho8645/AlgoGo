import java.util.*;
class Solution {
    boolean [][] finish;
    int [] answer = new int[2];
    public int[] solution(int[][] arr) {
        finish = new boolean[arr.length][arr[0].length];
        dfs(arr.length, 0, 0, arr);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(!finish[i][j]){
                    answer[arr[i][j]]++;
                }
            }
        }
        return answer;
    }
    
    public void dfs(int size, int r, int c, int [][] arr){
        if(size == 1) return;
       
        boolean check = true;
        int cur = arr[r][c];
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(cur != arr[i][j]){
                    dfs(size / 2, r, c, arr);
                    dfs(size / 2, r + size/2, c, arr);
                    dfs(size / 2, r, c + size/2, arr);
                    dfs(size / 2, r + size/2, c + size/2, arr);
                    check = false;
                    break;
                }
            }
            if(!check) break;
        }
        if(check){
            answer[cur]++;
            for(int i = r; i < r + size; i++){
                for(int j = c; j < c + size; j++){
                    finish[i][j] = true;
                }
            }
        }
    }
}