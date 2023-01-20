import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();
        if (N > K) {
            for (int i = N; i >= K; i--) {
                sb.append(i).append(" ");
            }
            System.out.println(N - K);
        } else {
            int[] map = new int[200001];
            Arrays.fill(map, -1);
            map[N] = K;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, N});
            while (true) {
                int[] cur = queue.poll();
                if (cur[1] == K) {
                    System.out.println(cur[0]);
                    int num = K;
                    sb.append(num);
                    while (map[num] != K) {
                        sb.insert(0, " ");
                        sb.insert(0, map[num]);
                        num = map[num];
                    }

                    break;
                }
                if (cur[1] - 1 >= 0 && map[cur[1] - 1] == -1) {
                    map[cur[1] - 1] = cur[1];
                    queue.add(new int[]{cur[0] + 1, cur[1] - 1});
                }
                if (cur[1] + 1 < 200001 && map[cur[1] + 1] == -1) {
                    map[cur[1] + 1] = cur[1];
                    queue.add(new int[]{cur[0] + 1, cur[1] + 1});
                }
                if (cur[1] > 0 && cur[1] * 2 < 200001 && map[cur[1] * 2] == -1) {
                    map[cur[1] * 2] = cur[1];
                    queue.add(new int[]{cur[0] + 1, cur[1] * 2});
                }

            }
        }
        System.out.println(sb);

    }
}