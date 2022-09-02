package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String input;
        for(int t = 1; t <= T; t++){
            input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;
            for(int i = 0 ; i < input.length(); i++){
                if(input.charAt(i) == '('){
                    stack.push(input.charAt(i));
                }else{
                    if(stack.empty()) {
                        isVPS = false;
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }
            if(stack.empty() && isVPS)
                sb.append("YES").append("\n");
            else if(!isVPS || !stack.empty())
                sb.append("NO").append("\n");

        }
        System.out.println(sb.toString());
    }
}
