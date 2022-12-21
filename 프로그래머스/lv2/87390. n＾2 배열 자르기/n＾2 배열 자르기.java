import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left) + 1;
        int[] answer = new int[size];
        int cnt = 0;
        while(left <= right){
            int first = (int)(left / n);
            int second = (int)(left % n);
            answer[cnt++] = Math.max(first, second) + 1;
            left++;
        }
       
        return answer;
    }
}