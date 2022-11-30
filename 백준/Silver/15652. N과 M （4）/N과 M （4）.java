import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int m, n;
	static int [] input, numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		n = sc.nextInt();
		m = sc.nextInt();
		input = new int[n];
		numbers = new int[m];
	
		for(int i = 0; i < n; i++) {
			input[i] = i+1;
		}
		permu(0, 0);
		System.out.println(sb.toString());
		
	}
	public static void permu(int start, int cnt) {
		if(cnt == m) {
			for(int i = 0; i < m; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < n; i++) {
			numbers[cnt] = input[i];
			permu(i, cnt+1);
		}
	}

}