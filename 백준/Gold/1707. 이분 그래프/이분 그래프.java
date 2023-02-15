import java.util.Scanner;

public class Main {
    static boolean check = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int tc = 1; tc <= k; tc++){
            check = true;
            int v = sc.nextInt();
            int e = sc.nextInt();
            int [] visited = new int [v+1];
            Node [] list = new Node[v+1];
            for(int i = 0; i < e; i++){
                int first = sc.nextInt();
                int second = sc.nextInt();
                list[first] = new Node(second, list[first]);
                list[second] = new Node(first, list[second]);
            }

            for(int i = 1; i <= v; i++){
                if (visited[i] != 0) continue;
                dfs(list, visited, 1, i);
                if(!check) break;
            }
            System.out.println(check ? "YES" : "NO");

        }

    }
    public static void dfs(Node [] list, int [] visited, int value, int vertex){
        if(!check) return;

        Node cur = list[vertex];
        visited[vertex] = value;

        while(cur != null){
            if(visited[cur.vertex] == 0){
                dfs(list, visited, -1*value, cur.vertex);
            }else if (visited[cur.vertex] == visited[vertex]){
                check = false;
                return;
            }
            cur = cur.link;
        }

    }
    public static class Node {
        int vertex;
        Node link;
        Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }
}