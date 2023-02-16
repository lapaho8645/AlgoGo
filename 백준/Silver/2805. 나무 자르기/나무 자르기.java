import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] trees = new long[N];
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
        }
        Arrays.sort(trees);
        long high = trees[N - 1];
        long low = 0;
        long middle = 0;

        while (low < high) {
            long sum = 0;
            middle = (low + high) / 2;
            for (int i = N - 1; i >= 0; i--) {
                if (trees[i] - middle < 0) break;
                sum += trees[i] - middle;
            }
            if (sum > M) {       // 더 높이 잘라도된다.
                low = middle + 1;
            } else {          // 더 아래를 잘라야 한다.
                high = middle;
            }
            
        }
        int answer = (int)high;

        int sum = 0;
        for(; answer >= high; answer--){
            for (int j = N - 1; j >= 0; j--) {
                if (trees[j] - answer < 0) break;
                sum += trees[j] - answer;
            }
            if(sum >= M) break;
        }
        System.out.println(answer);
    }
}
