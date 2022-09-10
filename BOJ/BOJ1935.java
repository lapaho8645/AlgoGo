package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class BOJ1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] operand = new int [N];
		String input = br.readLine();
		for (int i = 0; i < N; i++) {
			operand[i] = Integer.parseInt(br.readLine());
		}

		Stack <Double> stack = new Stack<>();
		HashMap<Character, Integer> map = new HashMap<>();
		int operandNum = 0;
		for(int i = 0; i < input.length(); i++) {
			double first = 0.0;
			double second = 0.0;
			switch(input.charAt(i)) {
			case '*':
				first = stack.pop();
				second = stack.pop();
				stack.push((double)(second * first));
				break;
			case '/':
				first = stack.pop();
				second = stack.pop();
				stack.push((double)(second / first));
				break;
			case '-':
				first = stack.pop();
				second = stack.pop();
				stack.push((double)(second - first));
				break;		
			case '+':
				first = stack.pop();
				second = stack.pop();
				stack.push((double)(second + first));
				break;
			default :
				if(map.containsKey(input.charAt(i))) {
					stack.push((double)map.get(input.charAt(i)));
				}else {
					map.put(input.charAt(i), operand[operandNum]);
					stack.push((double)map.get(input.charAt(i)));
					operandNum ++;
				}
				break;
			}
		}
		System.out.printf("%.2f", stack.pop());
	}

}
