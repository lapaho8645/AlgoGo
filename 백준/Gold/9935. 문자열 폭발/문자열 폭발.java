import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb  = br.readLine();
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++){
            stack.push(input.charAt(i));

            if (stack.peek() == bomb.charAt(bomb.length()-1) && stack.size() >= bomb.length()) {
                sb = new StringBuilder();
                for (int j = 0; j< bomb.length(); j++){
                    sb.append(stack.pop());
                }
                if (!sb.reverse().toString().equals(bomb)) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.push(sb.charAt(j));
                    }
                }
            }
        }
        if (stack.isEmpty())
            System.out.println("FRULA");
        else {
            sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse());
        }

    }

}