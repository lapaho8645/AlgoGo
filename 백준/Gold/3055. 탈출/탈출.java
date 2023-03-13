import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        char[][] map = new char[R][C];
        Queue<Location> flooded = new LinkedList<>();
        Queue<Location> hedgehog = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = input[0].charAt(j);
                if (map[i][j] == '*') {
                    flooded.add(new Location(i, j));
                } else if (map[i][j] == 'S') {
                    hedgehog.add(new Location(i, j, 0));
                    map[i][j] = '.';
                }
            }
        }
        boolean[][] visited = new boolean[R][C];
        boolean check = true;
        while (!hedgehog.isEmpty() && check) {
            if (!flooded.isEmpty())flooding(flooded, map);        // 물이 먼저 차
            int size = hedgehog.size();
            while (--size >= 0) {
                Location cur = hedgehog.poll();
                if (map[cur.r][cur.c] == 'D') {
                    System.out.println(cur.moveTime);
                    check = false;
                    break;
                }
                visited[cur.r][cur.c] = true;

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length
                            && (map[nr][nc] == '.' || map[nr][nc] == 'D') && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        hedgehog.add(new Location(nr, nc, cur.moveTime + 1));
                    }
                }
            }
        }
        if (check) System.out.println("KAKTUS");
    }

    public static void flooding(Queue<Location> flooded, char[][] map) {
        int size = flooded.size();
        while (--size >= 0) {
            Location cur = flooded.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length
                        && map[nr][nc] == '.') {
                    map[nr][nc] = '*';
                    flooded.add(new Location(nr, nc));
                }
            }
        }
    }

    public static class Location {
        int r, c;
        int moveTime;

        Location(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Location(int r, int c, int moveTime) {
            this.r = r;
            this.c = c;
            this.moveTime = moveTime;
        }
    }
}