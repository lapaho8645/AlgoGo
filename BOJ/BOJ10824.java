package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10824 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		
		String AB = input[0] + input[1];
		String CD = input[2] + input[3];
		System.out.println(Long.parseLong(AB) + Long.parseLong(CD));

	}

}
