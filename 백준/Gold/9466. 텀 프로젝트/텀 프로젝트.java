import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] input;
    static int students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            input = new int[n + 1];
            students = n;
            String[] arr = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                input[i] = Integer.parseInt(arr[i - 1]);
            }
            for (int i = 1; i <= n; i++) {
                if (input[i] == -1) continue;
                if (input[i] == i) {
                    students--;
                    input[i] = -1;
                    continue;
                }
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(input[i], 1);
                dfs(input[i], 1, map);
                input[i] = -1;
            }
            sb.append(students).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int cur, int cnt, HashMap<Integer, Integer> map) {
        if(input[cur] == -1) return;
        if(map.getOrDefault(input[cur], 0) == 0){
            map.put(input[cur], cnt+1);
            dfs(input[cur],cnt + 1, map);
        }else {
            students = students - (map.size() - map.get(input[cur]) + 1);
            for(Map.Entry<Integer, Integer> e : map.entrySet()){
                input[e.getKey()] = -1;
            }
        }
    }
}