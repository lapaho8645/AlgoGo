import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int[] remainFish = new int[7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] space = new int[N][N];
        int sharkR = 0, sharkC = 0;
        int size = 2;
        int cnt = 0;
        PriorityQueue<Location> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                space[i][j] = sc.nextInt();
                if (space[i][j] == 9) {
                    sharkR = i;
                    sharkC = j;
                    space[i][j] = 0;
                    pq.add(new Location(sharkR, sharkC, 0));
                } else if (space[i][j] > 0)
                    remainFish[space[i][j]]++;
            }
        }
        int result = 0;
        boolean[][] visited = new boolean[N][N];
        space[sharkR][sharkC] = 0;
        visited[sharkR][sharkC] = true;
        while (!pq.isEmpty()) {
            int sum = 0;
            for (int i = 1; i < Math.min(size, 7); i++) {
                sum += remainFish[i];
            }
            if (sum == 0) break;
            boolean check = false;
            while (!pq.isEmpty()) {
                Location cur = pq.poll();
                if (space[cur.r][cur.c] != 0 && size > space[cur.r][cur.c]) {
                    cnt = cnt + 1;
                    if (cnt == size) {
                        size++;
                        cnt = 0;
                    }
                    remainFish[space[cur.r][cur.c]]--;
                    result += cur.distance;
                    sharkR = cur.r;
                    sharkC = cur.c;
                    check = true;
                    break;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && size >= space[nr][nc]) {
                        visited[nr][nc] = true;
                        pq.add(new Location(nr, nc, cur.distance + 1));
                    }
                }
            }
            if (!check) break;
            space[sharkR][sharkC] = 0;
            pq = new PriorityQueue<>();
            pq.add(new Location(sharkR, sharkC, 0));
            visited = new boolean[N][N];
            visited[sharkR][sharkC] = true;
        }
        System.out.println(result);
    }

    public static class Location implements Comparable<Location> {
        int r, c, distance;

        Location(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        @Override
        public int compareTo(Location o) {
            if (this.distance == o.distance) {
                if (this.r == o.r)
                    return this.c - o.c;
                return this.r - o.r;
            }
            return this.distance - o.distance;
        }
    }
}