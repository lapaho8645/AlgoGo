import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int dr[] = {0, -1, 0, 1};
    static int dc[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        int map[][] = new int[101][101];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x, y, d, g;
        for (int i = 0; i < N; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            d = sc.nextInt();
            g = sc.nextInt();
            map[y][x] = 1;
            LinkedList<Integer> list = new LinkedList<>();
            list.add(d);
            for(int j = 0; j < g; j++){
                int size = list.size();
                for(int k = size-1; k >= 0; k--){
                    list.add((list.get(k) + 1) % 4);
                }
            }
            for(int j = 0; j < list.size(); j++){
                int cur = list.get(j);
                y += dr[cur];
                x += dc[cur];
                map[y][x] = 1;
            }
        }
        int answer =0;
        for(int i = 0; i <= 99; i++){
            for(int j = 0; j <= 99; j++){
                if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1)
                    answer++;
            }
        }
        System.out.println(answer);
    }
}