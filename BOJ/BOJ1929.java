package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 에라토스테네스의 체
 *
 */
public class BOJ1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input [] = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		boolean [] arr = new boolean[N+1];
		Arrays.fill(arr, true);
		arr[0] = arr[1] = false;
		for(int i = 2; i < N + 1; i++) {
			if(!arr[i]) continue;
			for(int j = 2; j* i< N +1; j++) {
				arr[j*i] = false;
			}
		}
		
		for(int i = M; i < N+1; i++) {
			if(arr[i])
				sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
