package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input.split(" ")[0]);
		int m = Integer.parseInt(input.split(" ")[1]);
		int nm = n - m;
		// 1~n까지의 5의 배수 개수 구하기
		int n5 = 0;
		int tempn = n;
		while (true) {
			if (tempn < 5)
				break;
			n5 += tempn / 5;
			tempn = tempn / 5;
		}

		// 1~n까지의 2의 배수 개수 구하기
		int n2 = 0;
		tempn = n;
		while (true) {
			if (tempn < 2)
				break;
			n2 += tempn / 2;
			tempn = tempn / 2;
		}

		// 1~m까지의 5의 배수 개수 구하기
		int tempm = m;
		int m5 = 0;
		while (true) {
			if (tempm < 5)
				break;
			m5 += tempm / 5;
			tempm = tempm / 5;
		}

		// 1~m까지의 2의 배수 개수 구하기
		int m2 = 0;
		tempm = m;
		while (true) {
			if (tempm < 2)
				break;
			m2 += tempm / 2;
			tempm = tempm / 2;
		}
		// 1~(n-m)까지의 5의 배수 개수 구하기
		int tempnm = nm;
		int nm5 = 0;
		while (true) {
			if (tempnm < 5)
				break;
			nm5 += tempnm / 5;
			tempnm = tempnm / 5;
		}

		// 1~(n-m)까지의 2의 배수 개수 구하기
		tempnm = nm;
		int nm2 = 0;
		while (true) {
			if (tempnm < 2)
				break;
			nm2 += tempnm / 2;
			tempnm = tempnm / 2;
		}
		
	
		if((n5-m5-nm5) >= (n2-m2-nm2)){
			System.out.println(n2 - m2 - nm2);
		}else  {
			System.out.println(n5 - m5 - nm5);
		}
		
	}
}
