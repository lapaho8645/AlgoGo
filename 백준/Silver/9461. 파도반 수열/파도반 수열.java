import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            long [] memo = new long[N+1];
            memo[1] = 1;
            for (int i = 2; i <= N; i++){
                if (i <= 3){
                    memo[i] = 1;
                    continue;
                }
                memo[i] = memo[i-3] + memo[i-2];
            }
            System.out.println(memo[N]);
        }

    }
}