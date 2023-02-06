import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char [][] map = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            boolean [] visited = new boolean[n];
            int [] removeHeight = new int[n];
            boolean [][] check = new boolean[m][n];
            int tempCnt = 0;
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    char cur = map[i][j];
                    if(cur == '0') continue;
                    if( (cur == map[i][j+1]) && (cur== map[i+1][j]) && (cur== map[i+1][j+1])){
                        if(!check[i][j]) {
                             removeHeight[j]++;
                             check[i][j] = true;
                             tempCnt++;
                        }
                        if(!check[i][j+1]) {
                            removeHeight[j+1]++;
                            check[i][j+1] = true;
                            tempCnt++;
                        }
                        if(!check[i+1][j]) {
                            removeHeight[j]++;
                            check[i+1][j] = true;
                            tempCnt++;
                        }
                        if(!check[i+1][j+1]) {
                            removeHeight[j+1]++;
                            check[i+1][j+1] = true;
                            tempCnt++;
                        }
                    }
                }
            }
            answer += tempCnt;
            if(tempCnt == 0) break;
            for(int i = m-1; i >= 0; i--){
                for(int j = 0; j < n; j++){
                    if(check[i][j]){
                         
                        int cnt = 0;
                        while(i -cnt >= 0 && check[i-cnt][j]){
                            cnt++;
                        }
                       
                          for(int k = i; k>= 0; k--){
                            if(k - cnt >= 0){
                                map[k][j] = map[k - cnt][j];
                                check[k][j] = check[k-cnt][j];
                            }else{
                                map[k][j] = '0';
                            }
                        }

                    }
                }

            }
         
        }
        return answer;
    }
}