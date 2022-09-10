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
		// ������ ���� ����
		int[] A = new int[N];
		// NGF�� ������ �迭
		int[] NGF = new int[N];
		int[] F = new int[1000001];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
			F[Integer.parseInt(input[i])]++;
		}
		// NGF�� �� ���ɼ��� �ִ� ���ڵ鸸
		Stack<Integer> candidate = new Stack<>();

		// ���� �����ʿ� �ִ� �� ���� NGF�� ã�� ����
		for (int i = N - 1; i >= 0; i--) {
			// candidate�� ����ִٸ� F[A[i]]���� ū ���� ���ٴ� ���̱� ������ -1�� �־���
			if (candidate.isEmpty()) {
				NGF[i] = -1;
			} else {
				while (!candidate.isEmpty()) {
					// ���� ���ʿ� �ִ� ū ��
					if (F[candidate.peek()] > F[A[i]]) {
						NGF[i] = candidate.peek();
						break;
					} else {
						// F[A[i]]���� ������ ���Ŀ��� NGF�� ���� �� ���� ������ pop, F[A[i]]���� ū ���� ã�� �� ���� �ݺ�
						candidate.pop();
					}
				}
				// candidate�� �� ������ �����ߴ� ���� NGF�� �ʱⰪ�̶�� F[A[i]]���� ū ���� �����ʿ� ���ٴ� ���̹Ƿ� -1�� �־���
				if (NGF[i] == 0) {
					NGF[i] = -1;
				}
			}
			// ���� A[i]�� �־��ش�.
			candidate.push(A[i]);
		}

		for (int i = 0; i < N; i++) {
			sb.append(NGF[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
