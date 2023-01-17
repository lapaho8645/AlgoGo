import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int [] parent = new int[n+1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);
            int first = Integer.parseInt(input[1]);
            int second = Integer.parseInt(input[2]);
            if(command == 0){
                union(parent, first, second);
            }else{
                sb.append(isUnion(parent, first, second) ? "YES" : "NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean isUnion(int [] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        if(a == b)
            return true;
        return false;
    }
    public static int find(int [] parent, int a){
        if(a == parent[a])
            return a;

        return parent[a] = find(parent, parent[a]);
    }

    public static void union(int [] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        if(a == b)
            return;
        parent[a] = b;
    }
}