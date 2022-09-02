package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        String[] input;
        String command = "";
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            command = input[0];
            if (input.length == 1) {
                if (command.equals("pop") && !stack.empty()) {
                    sb.append(stack.pop()).append("\n");
                } else if (command.equals("size")) {
                    sb.append(stack.size()).append("\n");
                } else if (command.equals("empty")) {
                    sb.append(stack.empty() ? 1 : 0).append("\n");
                } else if (command.equals("top") && !stack.empty()) {
                    sb.append(stack.peek()).append("\n");
                } else if (stack.empty() && (command.equals("pop") || command.equals("top"))) {
                    sb.append(-1).append("\n");
                }
            } else {
                stack.add(Integer.parseInt(input[1]));
            }
        }
        System.out.println(sb.toString());
    }
}
