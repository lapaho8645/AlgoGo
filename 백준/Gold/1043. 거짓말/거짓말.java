import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        boolean [] people = new boolean [N+1];
        Node [] list = new Node[N+1];
        Node [] store = new Node[M];
        input = br.readLine().split(" ");
        int trueMem = Integer.parseInt(input[0]);
        int [] trueMems = new int [trueMem];
        for(int i = 1; i <= trueMem; i++){
            people[Integer.parseInt(input[i])] = true;
            trueMems[i-1] = Integer.parseInt(input[i]);
        }
        int cnt = 0;
        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int partyNum = Integer.parseInt(input[0]);
            for(int j = 1; j <= partyNum; j++){
                store[i] = new Node(Integer.parseInt(input[j]), store[i]);
                for(int k = j+1; k <= partyNum; k++){
                    list[Integer.parseInt(input[j])] = new Node(Integer.parseInt(input[k]), list[Integer.parseInt(input[j])]);
                    list[Integer.parseInt(input[k])] = new Node(Integer.parseInt(input[j]), list[Integer.parseInt(input[k])]);
                }
            }
        }
        for (int i = 0; i < trueMem; i++){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(trueMems[i]);
            while(!queue.isEmpty()){
                int cur = queue.poll();
                Node curNode = list[cur];
                while(curNode!=null){
                    if(!people[curNode.vertex])
                        queue.add(curNode.vertex);
                    people[curNode.vertex] = true;
                    curNode = curNode.link;

                }
            }
        }
        for(int i = 0; i < M; i++){
            boolean check = false;
            Node cur = store[i];
            while(cur!=null){
                if(people[cur.vertex]){
                    check = true;
                    break;
                }
                cur = cur.link;
            }
            if(!check){
                cnt++;
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

        @Override
        public String toString() {
            return "[ " + this.vertex + " : " + this.link + " ]";
        }
    }
}