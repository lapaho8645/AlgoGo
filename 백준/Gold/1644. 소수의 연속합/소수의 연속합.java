import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean [] notPrime = new boolean[N+1];
        int [] prime = new int[N];
        int index = 0;
        notPrime[1] = true;
        for(int i = 2; i <= N; i++){
            if(!notPrime[i]){
                prime[index++] = i;
                for(int j = 2; i * j <= N; j++){
                    notPrime[i * j] = true;
                }
            }
        }

        int cnt = 0;
        int sum = 0;
        int size = 1;
        int first = 0;
        for (int i = 0; i < index; i++){
            sum += prime[i];
            while(sum > N){
                sum -= prime[first];
                first++;
            }
            if (sum == N) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}