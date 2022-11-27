import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] input = new int[N+1];
		int [][] dp = new int[N+1][2];
		for(int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		dp[1][0] = input[1];
		for(int i = 2; i <= N; i++) {
			if(i == 2) {
				dp[i][0] = dp[i-1][0] + input[i];
				dp[i][1] = input[2];
				continue;
			}
			dp[i][0] = dp[i-1][1] + input[i];
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + input[i];
		}
		System.out.println(Math.max(dp[N][0], dp[N][1]));  

	}

}
