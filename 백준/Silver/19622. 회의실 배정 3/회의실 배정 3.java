import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] dp = new int [N+1];
        Meeting [] input = new Meeting[N+1];
        for(int i = 1; i <= N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int num = sc.nextInt();
            input[i] = new Meeting(start, end, num);
        }
        dp[1] = input[1].num;
        for(int i = 2; i <= N; i++){
            dp[i] = Math.max(input[i].num + dp[i-2], dp[i-1]);
        }
        System.out.println(dp[N]);
    }
    public static class Meeting{
        public int start, end, num;
        public Meeting(int start, int end, int num){
            this.start = start;
            this.end = end;
            this.num = num;
        }
    }
}