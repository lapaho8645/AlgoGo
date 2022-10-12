package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2089 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int input = Integer.parseInt(br.readLine());
		if (input != 0) {
			while (true) {
				if (input == 0) {
					break;
				}
				if (input % (-2) == 0) {
					sb.append("0");
					input = input / (-2);
				} else {
					sb.append("1");
					input = (input - 1) / (-2);
				}

			}
			sb = new StringBuilder(sb.reverse());
			while (true) {
				if (sb.length() == 1) {
					break;
				}
				if (sb.charAt(0) == '0') {
					sb = new StringBuilder(sb.substring(1, sb.length()));
				} else {
					break;
				}
			}
			System.out.println(sb.toString());
		} else {
			System.out.println(0);
		}

	}
}
