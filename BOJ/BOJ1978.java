package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String [] input = br.readLine().split(" ");
		int num = 0;
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(input[i]);
			if(isPrime(n))
				num++;
		}
		System.out.println(num);
	}
	public static boolean isPrime(int n) {
		if(n==1)
			return false;
		if(n == 2)
			return true;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
}
