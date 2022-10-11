package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10872 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int fac = 1;
		if(N == 0)
			fac = 1;
		else {
			for(int i = 1; i <= N; i++) {
				fac = fac * i;
			}
		}
		System.out.println(fac);
	}

}
