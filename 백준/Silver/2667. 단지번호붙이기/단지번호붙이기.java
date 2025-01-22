import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		HashMap<Integer, Integer> dong = new HashMap<>();
		int dongNum = 1;

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < split.length; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]){
					int cnt = DFS(i,j,0);
					dong.put(dongNum++, cnt);
				}
			}
		}


		System.out.println(dong.size());
		dong.values()
			.stream().sorted()
			.forEach(System.out::println);
	}

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	private static int DFS(int x, int y, int cnt) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if(!isValidIndex(newX, newY)){
				continue;
			}

			if(map[newX][newY] == 1 && !visited[newX][newY]){
				cnt = DFS(newX, newY, cnt);
			}
		}

		return ++cnt;
	}

	private static boolean isValidIndex(int newX, int newY) {
		return newX >= 0 && newX < map.length && newY >= 0 && newY < map.length;
	}

}
