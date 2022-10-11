package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int zeroNum = 0;
		while(true) {
			if(N < 5 )
				break;
			zeroNum += N/5;
			N /= 5;
		}
		System.out.println(zeroNum);
	}
	

}
