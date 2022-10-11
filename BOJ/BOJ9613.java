package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9613 {
	static int [] selected;
	static int sum, n, numbers [];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			sum = 0;
			String input [] = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			numbers = new int[n];
			selected = new int[2];
			for(int i = 1; i < input.length; i++) {
				numbers[i-1] = Integer.parseInt(input[i]);
			}
			comb(0,0);
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == 2) {
			sum += gcd(selected[0], selected[1]);
			return;
		}
		
		for(int i = start; i < n; i++) {
			selected[cnt] = numbers[i];
			comb(cnt + 1, i+1);
		}
	}
	
	public static int gcd (int a, int b) {
		int r = 0;
		while(b != 0) {
				r = a % b;
				a = b;
				b = r;	
		}
		return a;
	}
}
