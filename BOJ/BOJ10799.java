package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * 
 * 레이저가 쏴졌을 때 왼쪽에 생기는 막대의 개수를 생각해야함
 * 처음에는 각 막대에 대해 몇개의 레이저가 쏴지는 지를 생각해서 시간초과가 남
 *
 */
public class BOJ10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		//레이저를 다른 문자로 바꿔주기
		input = input.replace("()", "-");
		//총 쇠막대기 조각 개수
		int count = 0;
		
		Stack <Character> stack = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				stack.push(input.charAt(i));
			}else if(input.charAt(i) == '-') {
				//레이저면 레이저에 의해 쏴지는 쇠막대기가 몇개인지를 넣음
				count += stack.size();
			}else if(input.charAt(i) == ')'){
				//막대기의 오른쪽 끝이면 (를 빼주고, 쇠막대기 개수를 하나 더해줌 (쇠막대기에 쏴지는 레이저가 3개면 쇠막대기는 4개의 조각으로 나눠지기 떄문)
				count += 1;
				stack.pop();
			}
		}
		System.out.println(count);
	}

}
