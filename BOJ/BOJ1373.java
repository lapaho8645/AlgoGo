package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1373 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		int N = (int)Math.ceil(input.length()/(double)3);
		int toOct [] = new int[N];
		int place = N-1;
		for(int i = input.length() - 1; i >= 0; i = i - 3) {
			if(i - 2 < 0) {
				int temp2 = 0;
				int sum = 0;
				for(int j = i; j >= 0; j--) {
					sum = sum + (int)Math.pow(2, temp2) * (input.charAt(j) - '0');
					temp2 ++;
				}
				toOct[place] = sum;
			}else {
			toOct[place] = 
				((input.charAt(i) - '0') + 2 * (input.charAt(i-1) - '0') +  2 * 2 * (input.charAt(i-2) - '0'));
			}
			place --;
		}
		for(int i = 0; i < N; i++) {
			sb.append(toOct[i]);
		}
		System.out.println(sb.toString());
	}

}
