package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		boolean isTag = false;
		for(int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if(c == ' ' && !isTag) {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			}else if(c == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				queue.add('<');
				isTag = true;
			}else if(c == '>') {
				while(!queue.isEmpty()) {
					sb.append(queue.poll());
				}
				sb.append('>');
				isTag = false;
			}else {
				if(isTag) {
					queue.add(c);
				}else {
					stack.add(c);
				}
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
		
	}
}
