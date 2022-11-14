import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		int [] LIS = new int[N];
		int max = 0;
		String input []= br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);	
		}
		
		for(int i = 0; i < N;i++) {
			LIS[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			max = max < LIS[i] ? LIS[i] : max;
		}
		System.out.println(max);
	}

}
