import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int n = sc.nextInt();
            int cnt = 0;
            for(int i = 0; i < n; i++){
                int cx = sc.nextInt();
                int cy = sc.nextInt();
                int r = sc.nextInt();
                int distance1 = (int)(Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2));
                int distance2 = (int)(Math.pow(cx - x2, 2) + Math.pow(cy - y2, 2));
                if (distance1 <= Math.pow(r, 2) && distance2 > Math.pow(r,2)
                        || distance2 <= Math.pow(r, 2) && distance1 > Math.pow(r,2)){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}