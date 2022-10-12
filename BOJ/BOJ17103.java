package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17103 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(prime(N)).append("\n");
		}
		System.out.println(sb.toString());

	}

	public static int prime(int n) {
		int sum = 0;
		boolean[] arr = new boolean[n + 1];
		Arrays.fill(arr, true);
		arr[0] = arr[1] = false;
		for (int i = 2; i <= n; i++) {
			if (!arr[i])
				continue;

			for (int j = 2; j * i <= n; j++) {
				arr[j * i] = false;
			}

		}

		for (int i = 0; i <= n/2; i++) {
			if (arr[i] && arr[n - i])
				sum++;
		}
		return sum;
	}

// �ƿ� �� �����佺�׳׽��� ü�� �Ҽ��� ���Ѵ����� ���ϴ°� �� ����!
//	public static int prime(int n) {
//		int sum = 0;
//		boolean[] arr = new boolean[n + 1];
//		Arrays.fill(arr, true);
//		arr[0] = arr[1] = false;
//		for (int i = 2; i <= n / 2; i++) {
//			if (!arr[i])
//				continue;
//
//			for (int j = 2; j * i <= n ; j++) {
//				arr[j * i] = false;
//			}
//
//			if (arr[n - i] && isPrime(n - i)) {
//				sum++;
//			}
//		}
//		return sum;
//
//	}
//
//	public static boolean isPrime(int num) {
//		
//		for (int i = 3; i <= Math.sqrt(num); i++) {
//			if (num % i == 0)
//				return false;
//		}
//		return true;
//	}
}
