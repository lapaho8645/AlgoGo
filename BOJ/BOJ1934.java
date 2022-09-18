package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1934 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String input[];
		for (int tc = 1; tc <= T; tc++) {
			input = br.readLine().split(" ");
			System.out.println(lcm(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
	}
	public static int lcm(int a, int b) {
		return (a*b) / gcd(a,b);
	}
	public static int gcd(int a, int b) {
		int r = 0;
		while(b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
