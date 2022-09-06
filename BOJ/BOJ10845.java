package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String [] input;
		Deque<Integer> deque = new LinkedList();
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			switch(input[0]) {
			case "push":
				deque.add(Integer.parseInt(input[1]));
				break;
			case "pop":
				sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
				break;
			case "back":
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());

	}

}
