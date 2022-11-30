import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char [][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		board = new char [N][M];
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				// W면 1, B이면 0
				board[i][j] = input[0].charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N - 8 + 1 ; i++) {		// 0 1 2
			for(int j = 0 ; j < M - 8 + 1; j++) {
				min = Math.min(min, checkboard(i, j));
			}
		}
		System.out.println(min);
	}
	
	public static int checkboard(int startR, int startC) {
		int sum1 = 0;
		int sum2 = 0;
		// startColor i와 j의 합이 홀수
		
		char startColor = 'B';
		for(int i = startR; i < startR + 8; i++) {
			for(int j = startC; j < startC + 8; j++) {
				if((i + j) % 2 == 1) {		//startColor와 일치하면 안됨, 일치하면 뒤집어야 하는 것
					sum1 += board[i][j] == startColor ? 1 : 0; 
				}else {		//startColor와 일치해야함, 일치하지 않으면 뒤집어야 하는 것
					sum1 += board[i][j] != startColor ? 1 : 0;
				}
			}
		}
		startColor = 'W';
		for(int i = startR; i < startR + 8; i++) {
			for(int j = startC; j < startC + 8; j++) {
				if((i + j) % 2 == 1) {		//startColor와 일치하면 안됨, 일치하면 뒤집어야 하는 것
					sum2 += board[i][j] == startColor ? 1 : 0; 
				}else {		//startColor와 일치해야함, 일치하지 않으면 뒤집어야 하는 것
					sum2 += board[i][j] != startColor ? 1 : 0;
				}
			}
		}
		return Math.min(sum1 , sum2);
	}

}