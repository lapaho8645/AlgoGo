import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = recur(p);
        return answer;
    }
    public String recur(String input){
        int index = 0;
        int cnt = 0;
        
        for(; index < input.length(); index++){
            char cur = input.charAt(index);
            if(index != 0 && cnt == 0) break;
            if(cur == '('){
                cnt++;
            }else {
                cnt--;
            }
        }
        String u = input.substring(0, index);
        if(u.equals(input) && check(u)) return input;
        String v = input.substring(index, input.length());
       
        if(check(u)){       //올바른 괄호 문자열
            return u += recur(v);
        }else{
            String temp = "(";
            temp += recur(v);
            temp += ")";
            u = u.substring(1, u.length() - 1);
            for(int i = 0; i < u.length(); i++){
                temp += u.charAt(i) == '(' ? ')' : '(';    
            }
            return temp;
        }
    }
    public boolean check(String p){
        Stack <Character> stack = new Stack<>();
        boolean result = true;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(')
                stack.push(p.charAt(i));
            else{
                if(stack.isEmpty()){
                    result = false;
                    break;
                }
                stack.pop();
            }
        } 
        if(!stack.isEmpty()) result = false;
        return result; 
    }
}