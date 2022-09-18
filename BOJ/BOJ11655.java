package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String [] input = br.readLine().split(" ");
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[i].length(); j++) {
				char c = input[i].charAt(j);
				if('A' <= c && c <= 'Z') {
					sb.append(((char)(c + 13) > 'Z') ? (char)(c-13) : (char)(c+13));	
				}else if('a' <= c && c <= 'z') {
					sb.append(((char)(c + 13) > 'z') ? (char)(c-13) : (char)(c+13));	
				}else {
					sb.append(c);
				}
		
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

}
