package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * 
 * �� �������� �켱������ �����ϰ�, ������� �����ں��� �켱������ ���� ���� stack�� �ִٸ� �� ������
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
