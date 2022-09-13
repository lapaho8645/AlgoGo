package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * 
 * 각 연산자의 우선순위를 생각하고, 현재들어온 연산자보다 우선순위가 높은 것이 stack에 있다면 다 꺼내기
 *
 */
public class BOJ1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> operator = new Stack<>();

		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			switch (c) {
			case '+':
			case '-':
				while (!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/'
						|| operator.peek() == '+' || operator.peek() == '-')) {
					char cur = operator.pop();
					if (cur == '(') {
						break;
					}
					sb.append(cur);
				}
				operator.push(c);
				break;
			case '*':
			case '/':
				while (!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')) {
					char cur = operator.pop();
					if (cur == '(') {
						break;
					}
					sb.append(cur);
				}
				operator.push(c);
				break;
			case '(':
				operator.push(c);
				break;
			case ')':
				while (!operator.isEmpty()) {
					char cur = operator.pop();
					if (cur != '(') {
						sb.append(cur);
					}else {
						break;
					}
				}
				break;
			default:
				sb.append(c);
				break;
			}
		}

		while (!operator.isEmpty()) {
			char cur = operator.pop();
			if (cur != '(') {
				sb.append(cur);
			}
		}
		System.out.println(sb.toString());
	}
}
