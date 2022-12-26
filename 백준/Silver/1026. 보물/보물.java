import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N];
        int [] B = new int [N];
        String [] input = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            B[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        for(int i = 0; i < N; i++){
            answer += A[i] * B[N-i-1];
        }
        System.out.println(answer);
    }
}