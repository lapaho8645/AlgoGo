import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Edge[] list = new Edge[M];

        long[] distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int dest = sc.nextInt();
            int time = sc.nextInt();
            list[i] = new Edge(start, dest, time);
        }

        for (int i = 1; i <= N; i++) {
            for (Edge edge : list) {
                if (distance[edge.start] != Long.MAX_VALUE) {
                    if (distance[edge.dest] > distance[edge.start] + edge.time) {
                        if (i == N) {
                            System.out.println(-1);
                            return;
                        }
                        distance[edge.dest] = distance[edge.start] + edge.time;
                    }
                }

            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(distance[i] == Long.MAX_VALUE ? -1 : distance[i]);
        }
    }

    public static class Edge {
        int start;
        int dest;
        int time;

        Edge(int start, int dest, int time) {
            this.start = start;
            this.dest = dest;
            this.time = time;
        }
    }
}