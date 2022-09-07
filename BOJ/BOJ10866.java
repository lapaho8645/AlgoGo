package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Deque <Integer> deque = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		String [] input;
		for(int i = 0; i < N ; i ++) {
			input = br.readLine().split(" ");
			switch(input[0]) {
			case "push_front" :
				deque.addFirst(Integer.parseInt(input[1]));
				break;
			case "push_back" :
				deque.addLast(Integer.parseInt(input[1]));
				break;
			case "pop_front" :
				if(!deque.isEmpty())
					sb.append(deque.pollFirst()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			case "pop_back" :
				if(!deque.isEmpty())
					sb.append(deque.pollLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			case "size" :
				sb.append(deque.size()).append("\n");
				break;
			case "empty" :
				if(!deque.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
				break;
			case "front" :
				if(!deque.isEmpty())
					sb.append(deque.peekFirst()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			case "back" :
				if(!deque.isEmpty())
					sb.append(deque.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
