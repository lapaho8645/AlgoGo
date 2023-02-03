import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = br.readLine();
            if(input.equals(".")) break;
            System.out.println(check(input) ? "yes" : "no");
        }


    }
    public static boolean check(String input){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '[' || input.charAt(i) == '('){
                stack.push(input.charAt(i));
            }else if(input.charAt(i) == ']'){
                if(stack.isEmpty()) return false;
                char cur = stack.pop();
                if(cur != '[') return false;
            } else if (input.charAt(i) == ')') {
                if(stack.isEmpty()) return false;
                char cur = stack.pop();
                if(cur != '(') return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}