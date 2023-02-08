import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][] combi = new int[m+1][n+1];

            for(int i = 0; i <= m; i++){
                for(int j = 0; j <= Math.min(i, n); j++){
                    if(j == 0 || i == j) {
                        combi[i][j] = 1;
                    }
                    else{
                        combi[i][j] = combi[i-1][j-1] + combi[i-1][j];
                    }
                }
            }

            System.out.println(combi[m][n]);
        }
    }

}