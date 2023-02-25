import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String [] input;
        Edge [] list = new Edge[M];
        for (int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            list[i] = new Edge(a, b, c);
        }
        Arrays.sort(list);
        parents = new int[N+1];
        for (int i = 1; i <= N; i++){
            parents[i] = i;
        }
        int cnt = 0, result = 0;
        for (Edge edge : list){
            if (union(edge.start, edge.end)){
                result += edge.weight;
                cnt++;
            }
            if (cnt == N) break;
        }
        System.out.println(result);
    }
    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parents[b] = a;
        return true;
    }
    public static int find(int a){
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    public static class Edge implements Comparable<Edge> {
        int start, end, weight;
        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
}