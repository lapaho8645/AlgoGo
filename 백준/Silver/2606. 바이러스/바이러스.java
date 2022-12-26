import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        boolean [] visited = new boolean[N+1];
        Node [] list = new Node[N+1];
        for(int i = 0; i < E; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from] = new Node(to, list[from]);
            list[to] = new Node(from, list[to]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int cnt = 0;
        while(!queue.isEmpty()){
            Node cur = list[queue.poll()];
            while(cur != null){
                if(!visited[cur.vertex]){
                    visited[cur.vertex] = true;
                    queue.add(cur.vertex);
                    cnt++;
                }
                cur = cur.link;
            }
        }
        System.out.println(cnt);
    }
    public static class Node{
        int vertex;
        Node link;
        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }
}