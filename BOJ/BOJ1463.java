package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] dp = new int[N+1];
		dp[1] = 0;
		for(int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			min = Math.min(min, dp[i-1] + 1);
			if(i % 2 == 0) {
				min = Math.min(min, dp[i/2] + 1); 
			}
			if(i%3 == 0) {
				min = Math.min(min, dp[i/3] + 1);
			}
			dp[i] = min;
		}
		System.out.println(dp[N]);
	}

}

