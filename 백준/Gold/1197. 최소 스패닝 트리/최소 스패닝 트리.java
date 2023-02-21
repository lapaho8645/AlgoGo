import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int [] parents;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Edge [] list = new Edge[e];
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[i] = new Edge(a, b, c);
        }
        Arrays.sort(list);

        parents = new int[v+1];
        for(int i = 1; i <= v; i++){
            parents[i] = i;
        }

        int result = 0, cnt = 0;
        for(Edge edge : list){
            if(isUnion(edge.start, edge.end)){
                result += edge.weight;
                if(++cnt == v-1) break;
            }
        }
        System.out.println(result);
    }
    public static boolean isUnion(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parents[b] = a;
        return true;
    }
    public static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    public static class Edge implements Comparable<Edge>{
        int start, end, weight;
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            if(this.weight < o.weight){
                return -1;
            }else if(this.weight > o.weight){
                return 1;
            }else{
                return 0;
            }
        }
    }
}