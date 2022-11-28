import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int dr [] = {0, 0, -1, 1};
	static int dc [] = {-1, 1, 0, 0};
	static int M, N;
	static int [][] map, visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		map = new int [M][N];
		visited = new int [M][N];
		for(int i = 0; i < M; i++) {
			Arrays.fill(visited[i], -1);
		}
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		System.out.println(dfs(0,0));
	}
	public static int dfs(int r, int c) {
		if(r == M-1 && c == N-1) {
			return 1;
		}
		
		if(visited[r][c] > -1) {
			return visited[r][c];
		}
		int tmp=0;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] < map[r][c]) {
				 tmp+= dfs(nr, nc);
			}
		}
		return visited[r][c]=tmp;
		
	}

}