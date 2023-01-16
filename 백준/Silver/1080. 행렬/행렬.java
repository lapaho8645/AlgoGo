import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = input.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = input.charAt(j) - '0';
            }
        }

        int cnt = 0;
        boolean check = false;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (A[i][j] != B[i][j]) {
                    A = flip(A, i, j);
                    cnt++;
                    if (isSame(A, B)) {
                        check = true;
                        break;
                    }
                }
            }
            if (check)
                break;
        }
        if(!check && isSame(A, B))
            cnt = 0;
        else if(!check || N < 3 || M < 3)
            cnt = -1;
        System.out.println(cnt);

    }

    public static int[][] flip(int[][] A, int curI, int curJ) {
        for (int i = curI; i < curI + 3; i++) {
            for (int j = curJ; j < curJ + 3; j++) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }
        return A;
    }

    public static boolean isSame(int[][] A, int[][] B) {
        boolean result = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != B[i][j]) {
                    result = false;
                    break;
                }
            }
            if (!result)
                break;
        }
        return result;
    }
}