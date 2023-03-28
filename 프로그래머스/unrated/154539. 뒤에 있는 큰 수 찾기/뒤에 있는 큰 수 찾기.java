import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int [] answer = new int [length];
        Stack<Integer> stack = new Stack<>();
        for(int i = length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                answer[i] = -1;
            }else{
                while(!stack.isEmpty()){
                    if(stack.peek() > numbers[i]){
                        answer[i] = stack.peek();
                        break;
                    }else{
                        stack.pop();
                    }
                }
                if(answer[i] == 0)
                    answer[i] = -1;
            }
            stack.push(numbers[i]);
        }
        
        
        return answer;
    }
}