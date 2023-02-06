import java.util.Scanner;

public class Main {
    static Node[] list;
    static int max, num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        list = new Node[V + 1];
        for (int i = 0; i < V; i++) {
            int vertex = sc.nextInt();
            int otherV, distance;
            while (true) {
                otherV = sc.nextInt();
                if (otherV == -1) break;
                distance = sc.nextInt();
                list[vertex] = new Node(otherV, distance, list[vertex]);
            }
        }
        for (int i = 1; i <= V; i++) {
            list[i] = new Node(i, 0, list[i]);
        }

        boolean[] visited = new boolean[V + 1];
        visited[1] = true;
        dfs(list[1], 0, visited);

        visited = new boolean[V + 1];
        visited[num] = true;
        dfs(list[num], 0, visited);
        System.out.println(max);
    }

    public static void dfs(Node cur, int sum, boolean[] visited) {
        if (max < sum) {
            num = cur.vertex;
            max = sum;
        }

        while (cur != null) {
            if (!visited[cur.vertex]) {
                visited[cur.vertex] = true;
                dfs(list[cur.vertex], sum + cur.distance, visited);
                visited[cur.vertex] = false;
            }
            cur = cur.link;
        }
    }

    public static class Node {
        int vertex;
        int distance;
        Node link;

        Node(int vertex, int distance, Node link) {
            this.vertex = vertex;
            this.distance = distance;
            this.link = link;
        }
    }
}