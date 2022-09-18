package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		LinkedList <String> suffixs = new LinkedList<>();
		for(int i = 0; i < input.length(); i++) {
			suffixs.add(input.substring(i, input.length()));
		}
		suffixs.sort(null);
		for(int i = 0 ; i< input.length(); i++) {
			sb.append(suffixs.get(i)).append("\n");
		}
		System.out.println(sb.toString());

	}

}
