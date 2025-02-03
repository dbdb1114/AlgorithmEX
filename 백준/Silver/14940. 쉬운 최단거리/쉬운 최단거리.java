import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 해결 전략
 * BFS로 순회하면서 기록하면 될 것 같음
 */
public class Main {
	// N과 M
	static int N;
	static int M;

	// 이차원 배열 두 개 [ 입력 및 출력 ]
	static int[][] map;
	static int[][] answer;

	// 방문 배열 하나
	static boolean[][] visited;

	// 상우하좌 [ 시계 방향 ]
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NandM = br.readLine().split(" ");
		N = Integer.parseInt(NandM[0]);
		M = Integer.parseInt(NandM[1]);
		int[] goal = new int[2];

		// 이차원 배열 초기화
		map = new int[N][M];
		answer = new int[N][M];
		visited = new boolean[N][M];

		// 지도 입력 받기
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if (map[i][j] == 2) {
					goal[0] = i;
					goal[1] = j;
				}
			}
		}

		BFS(goal);
        
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && answer[i][j] == 0){
					answer[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(answer[i][j]);
				if(j < M - 1){
					System.out.print(" ");
				}
			}
			if(i < N - 1){
				System.out.println();
			}
		}
	}

	public static void BFS(int[] start){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start[0], start[1], 0});

		while(!queue.isEmpty()){
			int[] poll = queue.poll();

			int nowX = poll[0];
			int nowY = poll[1];
			int nowDist = poll[2];

			if(visited[nowX][nowY]){
				continue;
			}

			visited[nowX][nowY] = true;
			answer[nowX][nowY] = nowDist;

			for (int i = 0; i < 4; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				int newDist = nowDist + 1;
				if(isValidIdx(newX, newY) && !visited[newX][newY]) {
					queue.add(new int[] {newX, newY, newDist});
				}
			}
		}
	}

	private static boolean isValidIdx(int x, int y){
		return x < N && x >= 0 && y < M && y >= 0 && map[x][y] == 1;
	}
}
