import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int [][] map, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		map = new int [n][m];
		dp = new int [n][m];
		for(int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				map[i][j] = input[0].charAt(j) - '0';
			}
		}
		for(int j = 0; j < m; j++) {
			dp[0][j] = map[0][j];
		}
		for(int i = 0; i < n; i++) {
			dp[i][0] = map[i][0];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				if(map[i][j] == 0)
					continue;
				if(map[i-1][j] > 0 && map[i][j-1] > 0 && map[i-1][j-1] > 0) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
				}else {
					dp[i][j] = map[i][j];
				}
			}
		}
	
		int max = 0;
		for(int i = 0; i < n; i++) {
			Arrays.sort(dp[i]);
			max = Math.max(max, dp[i][m-1]);
		}
		
		System.out.println(max * max);
		
	}

}