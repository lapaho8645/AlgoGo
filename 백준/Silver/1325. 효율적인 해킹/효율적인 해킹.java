import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] hackingCom;
    static int max;

    static boolean[] visited;
    static ArrayList<Integer> [] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
        }
        hackingCom = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        for (int i = 1; i <= N; i++){
            if (max == hackingCom[i])
                sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int vertex) {
        visited[vertex] = true;
        for (int next : list[vertex]){
            if (!visited[next]) {
                hackingCom[next]++;
                max = Math.max(hackingCom[next], max);
                dfs(next);
            }

        }
    }

}