import java.util.*;
class Solution {
    public int solution(int n) {
        // 15-3 = 12 
        // 12 % 2 == 0? 0이면 answer 증가시키기
        // 15-6 == 9
        // 9 % 3 == 0? 0이면 answer증가시키기
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