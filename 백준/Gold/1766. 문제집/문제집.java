import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        Node [] list = new Node[N+1];
        int [] inNum = new int[N+1];
        for(int i = 0; i < M; i++){
            int pre = sc.nextInt();
            int next = sc.nextInt();
            list[pre] = new Node(next, list[pre]);
            inNum[next]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            if(inNum[i] == 0){
                pq.add(i);
            }
        }

        while (!pq.isEmpty()){
            int vertex = pq.poll();
            sb.append(vertex).append(" ");
            Node cur = list[vertex];
            while(cur!= null){
                inNum[cur.vertex]--;
                if(inNum[cur.vertex] == 0){
                    pq.add(cur.vertex);
                }
                cur = cur.link;
            }
        }
        System.out.println(sb);
    }
    public static class Node{
        int vertex;
        Node link;
        Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }
}