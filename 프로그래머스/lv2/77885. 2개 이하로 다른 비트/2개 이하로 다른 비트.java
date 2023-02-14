import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long [numbers.length];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
            else{
                String input = "0" + Long.toBinaryString(numbers[i]);
                
                int index = input.length()-1;
                while(true){
                    if(input.charAt(index) == '0'){
                        break;
                    }
                    index--;
                }
                input = input.substring(0, index) + "10" + input.substring(index+2, input.length());
                answer[i] = Long.parseLong(input, 2);
            }
        }
        return answer;
    }
}

