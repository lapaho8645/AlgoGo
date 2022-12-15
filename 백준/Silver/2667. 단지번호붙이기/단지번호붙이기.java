import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] check;
    static int N, cnt;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = (int) (input.charAt(j) - '0');
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !check[i][j]){
                    bfs(i, j);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(arrayList);
        for(int i =0; i < arrayList.size(); i++){
            sb.append(arrayList.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r,c});
        check[r][c] = true;
        cnt++;
        int houseNum = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            houseNum++;
            for(int d = 0; d< 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && !check[nr][nc]){
                    check[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        arrayList.add(houseNum);
    }
}