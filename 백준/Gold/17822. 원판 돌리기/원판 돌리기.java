import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] input = new int[n + 1][m];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        int totalSum = 0;
        int[] change = new int[n + 1];
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int d = sc.nextInt();       // 0 - 시계, 1 - 반시계
            int k = sc.nextInt();
            for (int temp = 1, j = x * temp; j <= n; j = x * ++temp) {
                change[j] += d == 0 ? k : m - k;
                change[j] %= m;

            }

            List<int[]> list = new LinkedList<>();
            for (int j = 1; j <= n; j++) {
                for (int p = 0; p < m; p++) {

                    if (input[j][(p + m - change[j]) % m] == -1) continue;
                    int cur = input[j][(p + m - change[j]) % m];
                    boolean check = false;
                    if (j < n && cur == input[j + 1][(p + m - change[j + 1]) % m]) {
                        check = true;
                        list.add(new int[]{j + 1, (p + m - change[j + 1]) % m});
                    }
                    if (cur == input[j][(p + m - change[j] + 1) % m]) {
                        check = true;
                        list.add(new int[]{j, (p + m - change[j] + 1) % m});
                    }

                    if (check) list.add(new int[]{j, (p + m - change[j]) % m});
                }
            }

            if (list.size() == 0) {
                int sum = 0;
                int cnt = 0;

                for (int j = 1; j <= n; j++) {
                    for (int p = 0; p < m; p++) {
                        if (input[j][p] != -1) {
                            sum += input[j][p];
                            cnt++;
                        }
                    }
                }
                for (int j = 1; j <= n; j++) {
                    for (int p = 0; p < m; p++) {
                        if (input[j][p] != -1) {
                            if (input[j][p] * cnt == sum) continue;
                            input[j][p] = sum < input[j][p] * cnt ? input[j][p] - 1 : input[j][p] + 1;
                        }
                    }
                }
            }
            for (int j = 0; j < list.size(); j++) {
                int[] cur = list.get(j);
                input[cur[0]][cur[1]] = -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i][j] != -1) {
                    totalSum += input[i][j];
                }
            }
        }


        System.out.println(totalSum);
    }
}