package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		int[] count = new int[26];
		for (int i = 0; i < input.length(); i++) {
			count[(int)input.charAt(i) - 97]++;
			
		}
		for (int i = 0; i < 26; i++) {
			sb.append(count[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
