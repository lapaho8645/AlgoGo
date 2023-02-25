import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        List<Node> list [] = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        input = br.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);
        int [][] distance = new int[N+1][N+1];
        for (int i =1; i <= N; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        int [] startSet = {1, v1, v2};
        for(int i = 0; i < startSet.length; i++){
            boolean [] visited = new boolean[N+1];
            distance[startSet[i]][startSet[i]] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(startSet[i], 0));
            while (!pq.isEmpty()){
                Node cur = pq.poll();
                visited[cur.vertex] = true;

                for (Node node : list[cur.vertex]){
                    if (!visited[node.vertex] && distance[startSet[i]][node.vertex] > node.weight + cur.weight){
                        distance[startSet[i]][node.vertex] = node.weight + cur.weight;
                        pq.add(new Node(node.vertex, distance[startSet[i]][node.vertex]));
                    }
                }
            }
        }
        if ((distance[1][v1] == Integer.MAX_VALUE || distance[v1][v2] == Integer.MAX_VALUE || distance[v2][N] == Integer.MAX_VALUE)
            && (distance[1][v2] == Integer.MAX_VALUE || distance[v2][v1] == Integer.MAX_VALUE || distance[v1][N] == Integer.MAX_VALUE)){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(distance[1][v1] + distance[v1][v2] + distance[v2][N]
                    , distance[1][v2] + distance[v2][v1] + distance[v1][N]));
        }

    }
    public static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
}