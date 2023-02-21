import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "0";
        String [] input = new String[numbers.length];
        for(int i = 0; i < input.length; i++){
            input[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(input, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        
        if(input[input.length-1].equals("0")) return answer;
        
        StringBuilder sb = new StringBuilder();
        for(int i = input.length-1; i >= 0; i--){
            sb.append(input[i]);
        }
        answer = sb.toString();
        return answer;
    }
}
