package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		
		for(int i = 0; i < input.length(); i++) {
			int num = input.charAt(i) - '0';
			int place = 2;
			while(true) {
				if(place < 0)
					break;
				if(num == 0) {
					sb.append("0");
				}else {
					sb.append( num / (int)Math.pow(2, place));
					num = num % (int)Math.pow(2, place);
				}
				place--;
			}
		
		}		
		while(true) {
			if(sb.length() == 1) {
				break;
			}
			if(sb.charAt(0) == '0') {
				sb = new StringBuilder(sb.substring(1, sb.length()));
			}else {
				break;
			}
		}
		System.out.println(sb.toString());
		
	}

}
