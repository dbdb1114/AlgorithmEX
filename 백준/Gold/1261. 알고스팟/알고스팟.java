import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int M;

	static int[][] distMap;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NandM = br.readLine().split(" ");

		N = Integer.parseInt(NandM[1]);
		M = Integer.parseInt(NandM[0]);

		map = new int[N][M];
		distMap = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(distMap[i], Integer.MAX_VALUE);
		}
		distMap[0][0] = 0;

		dfs(0,0);
		System.out.println(distMap[N-1][M-1]);
	}

	private static void dfs(int x, int y){
		Queue<int[]> site = new LinkedList<>();
		Queue<int[]> zeroSpot = new LinkedList<>();

		zeroSpot.add(new int[] {x,y});
		site.add(new int[] {x,y});

		while(!zeroSpot.isEmpty() || !site.isEmpty()){
			while(!site.isEmpty()){
				int[] poll = site.poll();

				int nowX = poll[0];
				int nowY = poll[1];

				zeroSpot.add(new int[] {nowX, nowY});

				for (int i = 0; i < 4; i++) {
					int newX = nowX + dx[i];
					int newY = nowY + dy[i];

					if(validIdx(newX, newY) && !visited[newX][newY] && map[newX][newY] == 0){
						distMap[newX][newY] = distMap[nowX][nowY];
						site.add(new int[] {newX,newY});
						zeroSpot.add(new int[] {newX,newY});
						visited[newX][newY] = true;
					}
				}
			}

			while(!zeroSpot.isEmpty()){
				int[] poll = zeroSpot.poll();

				int nowX = poll[0];
				int nowY = poll[1];

				for (int i = 0; i < 4; i++) {

					int newX = nowX + dx[i];
					int newY = nowY + dy[i];

					if(validIdx(newX, newY)) {
						distMap[newX][newY] = Math.min(distMap[newX][newY], distMap[nowX][nowY] + 1);
						if(!visited[newX][newY]){
							site.add(new int[] {newX, newY});
							visited[newX][newY] = true;
						}
					}
				}
			}
		}
	}
    

	private static boolean validIdx(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}
