package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17299 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		// 수열의 수를 저장
		int[] A = new int[N];
		// NGF를 저장할 배열
		int[] NGF = new int[N];
		int[] F = new int[1000001];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
			F[Integer.parseInt(input[i])]++;
		}
		// NGF가 될 가능성이 있는 숫자들만
		Stack<Integer> candidate = new Stack<>();

		// 가장 오른쪽에 있는 수 부터 NGF를 찾기 위함
		for (int i = N - 1; i >= 0; i--) {
			// candidate가 비어있다면 F[A[i]]보다 큰 수가 없다는 뜻이기 때문에 -1을 넣어줌
			if (candidate.isEmpty()) {
				NGF[i] = -1;
			} else {
				while (!candidate.isEmpty()) {
					// 가장 왼쪽에 있는 큰 수
					if (F[candidate.peek()] > F[A[i]]) {
						NGF[i] = candidate.peek();
						break;
					} else {
						// F[A[i]]보다 작으면 이후에도 NGF로 쓰일 수 없기 때문에 pop, F[A[i]]보다 큰 수를 찾을 때 까지 반복
						candidate.pop();
					}
				}
				// candidate가 빌 떄까지 진행했는 데도 NGF이 초기값이라면 F[A[i]]보다 큰 수가 오른쪽에 없다는 뜻이므로 -1을 넣어줌
				if (NGF[i] == 0) {
					NGF[i] = -1;
				}
			}
			// 현재 A[i]를 넣어준다.
			candidate.push(A[i]);
		}

		for (int i = 0; i < N; i++) {
			sb.append(NGF[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
