package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10820 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			try {
				String input = br.readLine();
				if (input.length() == 0)
					break;
				int small = 0;
				int capital = 0;
				int num = 0;
				int empty = 0;
				for (int i = 0; i < input.length(); i++) {
					char c = input.charAt(i);
					if ('a' <= c && c <= 'z') {
						small++;
					} else if ('A' <= c && c <= 'Z') {
						capital++;
					} else if ('0' <= c && c <= '9') {
						num++;
					} else if (c == ' ') {
						empty++;
					}
				}
				sb.append(small).append(" ").append(capital).append(" ").append(num).append(" ").append(empty)
						.append("\n");
			} catch (Exception e) {
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
