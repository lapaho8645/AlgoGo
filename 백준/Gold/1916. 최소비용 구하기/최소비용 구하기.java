import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N + 1];
        int[][] graph = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j)  graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }
        String[] input;
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int dest = Integer.parseInt(input[1]);
            int fee = Integer.parseInt(input[2]);
            graph[start][dest] = Math.min(graph[start][dest] , fee);

        }
        input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int dest = Integer.parseInt(input[1]);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.vertex]) continue;
            visited[cur.vertex] = true;
            for (int i = 1; i <= N; i++) {
                if(graph[cur.vertex][i] == Integer.MAX_VALUE) continue;
                if (distance[i] > distance[cur.vertex] + graph[cur.vertex][i]) {
                    distance[i] = distance[cur.vertex] + graph[cur.vertex][i];
                    pq.add(new Node(i, distance[i]));
                }
            }

        }
        System.out.println(distance[dest]);
    }

    public static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }


    }
}