import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Node[] list = new Node[N+1];
        String [] input;
        for (int i = 0; i < N - 1; i++) {
            input = br.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);
            list[first] = new Node(second, list[first]);
            list[second] = new Node(first, list[second]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int [] arr = new int[N+1];
        arr[1] = 1;
        queue.add(1);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            Node cur = list[vertex];
            while(cur != null){
                if(arr[cur.vertex] == 0){
                    arr[cur.vertex] = vertex;
                    queue.add(cur.vertex);
                }
                cur = cur.link;
            }
        }
        for (int i = 2; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static class Node{
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }

    }
}