import java.util.*;
class Solution {
    
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            boolean check = true;
            for(int j = i; j < s.length() + i; j++){
                index = (j + s.length()) % s.length();
                char cur = s.charAt(index);
                if(cur == '[' || cur == '(' || cur == '{'){
                    stack.push(cur);
                }else{
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }
                    char prev = stack.pop();
                    if((cur == ']' && prev != '[') || (cur == '}' && prev != '{') || (cur == ')' && prev != '(')){
                        check = false;
                        break;
                    }
                }
            }
            if(check  && stack.isEmpty()){
                answer++;
            }
        }
        
        
        return answer;
    }
   
}
