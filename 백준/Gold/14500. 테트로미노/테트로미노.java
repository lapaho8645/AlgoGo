import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, map[][], max;
    static int[][][] tetromino = {{{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},

            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
            {{0, 0}, {1, 0}, {1, -1}, {1, -2}},
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
            
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 0}, {1, 0}, {1, -1}, {0, 1}},

            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int t = 0; t < tetromino.length; t++) {
                    boolean isPossible = true;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + tetromino[t][d][0];
                        int nj = j + tetromino[t][d][1];
                        if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                            isPossible = false;
                            break;
                        }
                    }
                    if (isPossible) {
                        int sum = 0;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + tetromino[t][d][0];
                            int nj = j + tetromino[t][d][1];
                            sum += map[ni][nj];
                        }
                        max = Math.max(max, sum);
                    }
                }

            }
        }
        System.out.println(max);
    }

}