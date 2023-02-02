import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean [][][] map = new boolean[11][11][4];
        int r = 5;
        int c = 5;
        int nr = r;
        int nc = c;
        int dir = 0;
        int oppositeDir = 0;
        for(int i = 0; i < dirs.length(); i++){
            char command = dirs.charAt(i);
            switch(command){
                case 'U' :
                    if(r + 1 <= 10){
                        nr = r + 1;
                        dir = 0;
                        oppositeDir = 1;
                    }    
                    break;
                case 'D' :
                    if(r - 1 >= 0){
                        nr = r - 1;
                        dir = 1;
                        oppositeDir = 0;
                    }
                    break;
                case 'L' :
                    if(c - 1 >= 0){
                        nc = c - 1;
                        dir = 2;
                        oppositeDir = 3;
                    }
                    break;
                case 'R' :
                    if(c + 1 <= 10){
                        nc = c + 1;
                        dir = 3;
                        oppositeDir = 2;
                    }
                    break;
            }
            
            if(!map[nr][nc][dir]){
                answer ++;
                map[nr][nc][dir] = true;
                map[r][c][oppositeDir] = true;
            }
            r = nr;
            c = nc;
        }
        return answer;
    }
    
}