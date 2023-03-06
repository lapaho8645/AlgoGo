import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int remain = number.length() - k - 1;
        int cut = number.length() - k;
        int start = 0;
        for(int i = 0; i < number.length() - k; i++){
            int max = -1;
            int index = 0;
            for(int j = start; j < number.length() - remain; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    index = j;
                }
                if(max == 9) break;
            }
            start = index + 1;
            remain--;
            answer += Integer.toString(max);
            
        }
        
        return answer;
    }
}
