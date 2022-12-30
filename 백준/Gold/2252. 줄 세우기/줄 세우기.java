import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [] countArr = new int [N+1];
        Node [] list = new Node[N+1];
        for (int i = 0; i < M; i++) {
            int prev = sc.nextInt();
            int next = sc.nextInt();
            countArr[next]++;
            list[prev] = new Node(next, list[prev]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(countArr[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            sb.append(vertex).append(" ");
            Node cur = list[vertex];
            while(cur != null){
                countArr[cur.value]--;
                if(countArr[cur.value] == 0){
                    queue.add(cur.value);
                }
                cur = cur.link;
            }

        }
        System.out.println(sb.toString());
    }
    public static class Node{
        int value;
        Node link;
        Node(int value, Node link){
            this.value = value;
            this.link = link;
        }
    }
}