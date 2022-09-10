package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		// ������ ���� ����
		int [] A = new int[N];
		// NGE�� ������ �迭
		int[] NGE = new int[N];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(input[i]);

		// NGE�� �� ���ɼ��� �ִ� ���ڵ鸸
		Stack<Integer> candidate = new Stack<>();

		// ���� �����ʿ� �ִ� �� ���� NGE�� ã�� ����
		for(int i = N-1; i >= 0; i--) {
			//candidate�� ����ִٸ� A[i]���� ū ���� ���ٴ� ���̱� ������ -1�� �־���
			if(candidate.isEmpty()) {
				NGE[i] = -1;
			}else {
				while (!candidate.isEmpty()) {
					// ���� ���ʿ� �ִ� ū �� 
					if (candidate.peek() > A[i]) {
						NGE[i] = candidate.peek();
						break;
					} else {
						// A[i]���� ������ ���Ŀ��� NGE�� ���� �� ���� ������ pop, A[i]���� ū ���� ã�� �� ���� �ݺ�
						candidate.pop();
					}
				}
				//candidate�� �� ������ �����ߴ� ���� NGE�� �ʱⰪ�̶�� A[i]���� ū ���� �����ʿ� ���ٴ� ���̹Ƿ� -1�� �־���
				if (NGE[i] == 0) {
					NGE[i] = -1;
				}
			}
			//���� A[i]�� �־��ش�.
			candidate.push(A[i]);
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(NGE[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
