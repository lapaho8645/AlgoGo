package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * push하는 순서는 반드시 오름차순 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로
 * push와 pop 연산을 수행해야 할까?
 *
 */
public class BOJ1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] sequence = new int[n];
		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(br.readLine());
		}
		int current = 0;
		for (int i = 1; i <= n; i++) {

			while (!stack.isEmpty() && stack.peek() == sequence[current]) {
				stack.pop();
				current++;
				sb.append("-").append("\n");
			}

			stack.push(i);
			sb.append("+").append("\n");
			if (stack.peek() == sequence[current]) {
				stack.pop();
				current++;
				sb.append("-").append("\n");
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == sequence[current]) {
				stack.pop();
				current++;
				sb.append("-").append("\n");
			} else {
				stack.pop();
			}
		}

		if (current == n) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}
