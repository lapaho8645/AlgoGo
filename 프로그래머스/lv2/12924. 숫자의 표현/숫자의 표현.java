import java.util.*;
class Solution {
    public int solution(int n) {
        
        int sub = 3;
        int plusNum = 3;
        int seq = 2;
        int answer = 1;
        
        while(n >= sub){
            if((n - sub) % seq == 0)
                answer++;
            sub += plusNum;
            plusNum++;
            seq++;
        }
        
        return answer;
    }
}