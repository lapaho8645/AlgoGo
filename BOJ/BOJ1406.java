package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();		//100000을 넘지않음
		int M = Integer.parseInt( br.readLine());
		Stack <Character> front = new Stack<>();
		Stack <Character> back = new Stack<>();
		for(int i = 0; i < input.length(); i++) {
			front.push(input.charAt(i));
		}
		String [] command;
		for (int i = 0; i < M; i++) {
			command = br.readLine().split(" ");
			switch (command[0].charAt(0)) {
			case 'L':
				if(!front.isEmpty())
					back.push(front.pop());
				break;
			case 'D':
				if(!back.isEmpty())
					front.push(back.pop());
				break;
			case 'B':
				if(!front.isEmpty())
					front.pop();
				break;
			case 'P':
				front.push(command[1].charAt(0));
				break;
			}
		}
		while(!front.isEmpty()) {
			back.push(front.pop());
		}
		while(!back.isEmpty()) {
			sb.append(back.pop());
		}
		System.out.println(sb.toString());
		
	}

}
