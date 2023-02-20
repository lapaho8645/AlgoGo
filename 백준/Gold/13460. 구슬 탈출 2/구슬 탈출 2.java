import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;
    static char[][] map;
    static Queue<BallInfo> ball = new LinkedList<>();
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][n][m];
        BallInfo first = new BallInfo(0, 0, 0, 0, 1);
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'R') {
                    first.rr = i;
                    first.rc = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    first.br = i;
                    first.bc = j;
                    map[i][j] = '.';
                }
            }
        }
        ball.add(first);
        bfs();
    }

    public static void bfs() {
        while (!ball.isEmpty()) {
            BallInfo cur = ball.poll();
            visited[cur.rr][cur.rc][cur.br][cur.bc] = true;
            if (cur.cnt > 10) {
                System.out.println(-1);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nrr = cur.rr + dr[d];
                int nrc = cur.rc + dc[d];
                int nbr = cur.br + dr[d];
                int nbc = cur.bc + dc[d];
                int tempR = cur.br;
                int tempC = cur.bc;
                boolean redCheck = false;
                boolean blueCheck = false;
                boolean check = false;
                while (nrr >= 0 && nrr < n && nrc >= 0 && nrc < m) {
                    if (!check && nrr == tempR && nrc == tempC) {
                        while (nbr >= 0 && nbr < n && nbc >= 0 && nbc < m) {
                            if (map[nbr][nbc] == '.') {
                                nbr += dr[d];
                                nbc += dc[d];
                            } else if (map[nbr][nbc] == 'O') {
                                blueCheck = true;
                                break;
                            } else {
                                break;
                            }
                        }
                        check = true;

                    } else if (check && nrr == nbr - dr[d] && nrc == nbc - dc[d]) {
                        break;
                    } else if (map[nrr][nrc] == '.') {
                        nrr += dr[d];
                        nrc += dc[d];

                    } else if (map[nrr][nrc] == 'O') {
                        redCheck = true;
                        break;
                    } else break;
                }
                while (nbr >= 0 && nbr < n && nbc >= 0 && nbc < m) {
                    if (!redCheck && (nbr == nrr - dr[d] && nbc == nrc - dc[d])) {
                        break;
                    }
                    if (map[nbr][nbc] == '.') {
                        nbr += dr[d];
                        nbc += dc[d];
                    } else if (map[nbr][nbc] == 'O') {
                        blueCheck = true;
                        break;
                    } else {
                        break;
                    }
                }
                if (blueCheck && redCheck) {
                    continue;
                } else if (blueCheck) {
                    continue;
                } else if (redCheck) {
                    System.out.println(cur.cnt);
                    return;
                }

                if (!visited[nrr - dr[d]][nrc - dc[d]][nbr - dr[d]][nbc - dc[d]])
                    ball.add(new BallInfo(nrr - dr[d], nrc - dc[d], nbr - dr[d], nbc - dc[d], cur.cnt + 1));
            }

        }
        System.out.println(-1);
    }

    public static class BallInfo {
        int rr, rc, br, bc, cnt;

        BallInfo(int rr, int rc, int br, int bc, int cnt) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.cnt = cnt;
        }
    }
}