package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6588 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			for(int i = 0; i <= n/2; i++) {
				if(isPrime(i) && isPrime(n-i)) {
					sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
					break;
				}
				if(i == n/2) {
					sb.append("Goldbach's conjecture is wrong").append("\n");
				}
			}
			
		}
		System.out.println(sb.toString());

	}
	public static boolean isPrime(int num) {
		if(num==1)
			return false;
		if(num == 2)
			return true;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;
		
	}
}
