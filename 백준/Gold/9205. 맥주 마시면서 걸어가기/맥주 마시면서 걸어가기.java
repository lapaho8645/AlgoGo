import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int [][] conv = new int [N][2];
            int hx = sc.nextInt();
            int hy = sc.nextInt();
            for(int i = 0; i < N; i++){
                conv[i][0] = sc.nextInt();
                conv[i][1] = sc.nextInt();
            }
            int fx = sc.nextInt();
            int fy = sc.nextInt();
            boolean check = false;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{hx, hy});
            while(!queue.isEmpty()){
                int [] cur = queue.poll();
                if(Math.abs(cur[0] - fx) + Math.abs(cur[1] - fy) <= 1000){
                    check = true;
                    break;
                }
                for(int i = 0; i < N; i++){
                    if(Math.abs(cur[0] - conv[i][0]) + Math.abs(cur[1] - conv[i][1]) <= 1000){
                        queue.add(new int[] {conv[i][0], conv[i][1]});
                        conv[i][0] = -99999;
                        conv[i][1] = -99999;
                    }
                }
            }
            
            System.out.println(check ? "happy" : "sad");
        }
    }
}