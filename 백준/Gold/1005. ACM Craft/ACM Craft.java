import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++){
            String [] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            int time [] = new int[N+1];
            input = br.readLine().split(" ");
            int [] sum = new int[N+1];
            for (int i = 1; i <= N; i++){
                time[i] = Integer.parseInt(input[i-1]);
                sum[i] = time[i];
            }
            int [] inCount = new int[N+1];
            Node [] list = new Node[N+1];
            for (int i = 0; i < K; i++){
                input = br.readLine().split(" ");
                int first = Integer.parseInt(input[0]);
                int second = Integer.parseInt(input[1]);
                list[first] = new Node(second, list[first]);
                inCount[second]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++){
                if (inCount[i] == 0){
                    queue.add(i); //vertex, depth
                }
            }
            int W = Integer.parseInt(br.readLine());

            while (!queue.isEmpty()){
                int cur = queue.poll();

                Node curNode = list[cur];
                while (curNode != null){
                    sum[curNode.vertex] = Math.max(sum[curNode.vertex], sum[cur] + time[curNode.vertex]);
                    if(--inCount[curNode.vertex] == 0){
                        queue.add(curNode.vertex);
                    }
                    curNode = curNode.link;
                }
            }
            System.out.println(sum[W]);
        }

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
