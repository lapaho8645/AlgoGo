import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] adjMatrix = new int[n+1][n+1];

        for (int i = 1; i <= n; i++){
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0;
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adjMatrix[a][b] = Math.min(adjMatrix[a][b], c);
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                if(k == i) continue;
                for(int j = 1; j <= n; j++){
                    if(k == j || i == j) continue;
                    if (adjMatrix[i][k] != Integer.MAX_VALUE && adjMatrix[k][j] != Integer.MAX_VALUE)
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j] , adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sb.append(adjMatrix[i][j] == Integer.MAX_VALUE ? 0 : adjMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}