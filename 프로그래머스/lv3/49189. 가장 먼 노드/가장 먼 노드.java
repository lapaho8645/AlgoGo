import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Node [] list = new Node[n+1];
        for(int i = 0; i < edge.length ; i++){
            int first = edge[i][0];
            int second = edge[i][1];
            list[first] = new Node(second, list[first]);
            list[second] = new Node(first, list[second]);
        }
      
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int []{1, 0});
        boolean [] visited = new boolean[n+1];
        int [] distance = new int[n+1];
        int max = 0;
        while(!queue.isEmpty()){
            int [] cur = queue.poll();
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            distance[cur[0]] = cur[1];
            max = Math.max(max, cur[1]);
            Node linkNode = list[cur[0]];
            while(linkNode != null){
                queue.add(new int [] {linkNode.vertex, cur[1] + 1});
                linkNode = linkNode.link;
            }
        }
        for(int i = 1; i <= n; i++){
            if(max == distance[i]) answer++;
        }
        return answer;
    }
    public class Node{
        int vertex;
        Node link;
        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }
}