package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17087 {
	//최대 공약수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int S = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int [] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Math.abs(Integer.parseInt(input[i]) - S);
		}
		
		if(N == 1) {
			System.out.println(A[0]);
		}else {
			int tempa = gcd(A[0], A[1]);
			for(int i = 2; i < N; i++) {
				tempa = gcd(tempa, A[i]);
			}
			System.out.println(tempa);
		}
	
	}
	
	public static int gcd(int a, int b) {
		int r = a;
		while(b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
