import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        String num [] = expression.split("\\+|\\-|\\*");
        
        answer = Math.max(answer, maxValue(new char[]{'*' , '+', '-'}, expression, num));
        answer = Math.max(answer, maxValue(new char[]{'*' , '-', '+'}, expression, num));
        answer = Math.max(answer, maxValue(new char[]{'+' , '*', '-'}, expression, num));
        answer = Math.max(answer, maxValue(new char[]{'+' , '-', '*'}, expression, num));
        answer = Math.max(answer, maxValue(new char[]{'-' , '+', '*'}, expression, num));
        answer = Math.max(answer, maxValue(new char[]{'-' , '*', '+'}, expression, num));
        return answer;
    }
    
    public long maxValue(char [] priority, String expression, String [] num){
        int index = 0;
        Deque <String> deque = new ArrayDeque<>();
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == priority[0]) {
                deque.add(num[index++]);
                deque.add(String.valueOf(priority[0]));
            }
            else if(expression.charAt(i) == priority[1]) {
                deque.add(num[index++]);
                deque.add(String.valueOf(priority[1]));
            }
            else if(expression.charAt(i) == priority[2]) {
                deque.add(num[index++]);
                deque.add(String.valueOf(priority[2]));
            }
        }
        deque.add(num[index]);
        for(int i = 0; i < 3; i++){
            int temp = deque.size();
            while(temp-- > 0){
                String cur = deque.pollFirst();
                if(cur.equals(String.valueOf(priority[i]))){
                    temp -= 1;
                   
                    switch(cur){
                        case "*":
                            deque.addLast(
                        String.valueOf(Long.parseLong(deque.pollLast()) * Long.parseLong(deque.pollFirst())));
                            break;
                        case "-":
                            deque.addLast(
                        String.valueOf(Long.parseLong(deque.pollLast()) - Long.parseLong(deque.pollFirst())));
                            break;
                        case "+":
                            deque.addLast(
                        String.valueOf(Long.parseLong(deque.pollLast()) + Long.parseLong(deque.pollFirst())));
                    }
                    
                 }else{
                        deque.addLast(cur);
                }
                
            }   
        }
     
        return Math.abs(Long.parseLong(deque.poll()));
    }
}