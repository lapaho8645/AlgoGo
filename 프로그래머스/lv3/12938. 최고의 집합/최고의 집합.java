import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        if( s / n == 0){
            answer = new int[] {-1};
            return answer;
        }
        answer = new int[n];
        int div = s / n; // 4
        int mod = s % n; //1
        int index = 0;
        for(int i = 0; i < n - mod; i++){
            answer[index] = div;
            index++;
        }
        for(int i = 0; i < mod; i++){
            answer[index] = div + 1;
            index++;
        }
       
        return answer;
    }
}
