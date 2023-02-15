import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int diff = Math.abs(sc.nextInt() - sc.nextInt());
            int cnt = 0;
            int k = 1;
            while (diff > 0) {
                cnt++;
                diff -= k;
                if (diff - k >= 0) {
                    cnt++;
                    diff -= k;
                }
                k++;
            }
            System.out.println(cnt);
        }
    }
}