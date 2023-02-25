import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node [] list = new Node[n+1];
        String [] input;
        for(int i = 0; i < n - 1; i++){
            input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            list[parent] = new Node(child, weight, list[parent]);
            list[child] = new Node(parent, weight, list[child]);
        }
        boolean [] visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, 0, list, visited);
        max = 0;
        visited = new boolean[n+1];
        visited[totalV] = true;
        dfs(totalV, 0, list, visited);
        System.out.println(max);
    }
    static int max = 0;
    static int totalV = 0;
    public static void dfs(int vertex, int sum, Node[] list, boolean [] visited){
        if (max < sum){
            max = sum;
            totalV = vertex;
        }
        Node cur = list[vertex];
        while (cur != null){
            if (!visited[cur.vertex]){
                visited[cur.vertex] = true;
                dfs(cur.vertex, sum+ cur.weight , list, visited);
                visited[cur.vertex] = false;
            }
            cur = cur.link;
        }

    }
    public static class Node{
        int vertex;
        int weight;
        Node link;
        Node(int vertex, int weight, Node link){
            this.vertex = vertex;
            this.weight = weight;
            this.link = link;
        }
    }
}