import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int [] parent;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            int first = sc.nextInt();
            int second = sc.nextInt();
            union(first, second);
        }
        int answer = 1;
        int temp = parent[1];
        Arrays.sort(parent);
        for(int i = 2; i <= n; i++){
            if(temp != parent[i]){
                answer++;
                temp = parent[i];
            }
        }
        System.out.println(answer);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) {
            for(int i = 1; i <= n; i++){
                if(parent[i] == a)
                    parent[i] = b;
            }
        }
    }
    public static int find(int a){
        if(a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }
}