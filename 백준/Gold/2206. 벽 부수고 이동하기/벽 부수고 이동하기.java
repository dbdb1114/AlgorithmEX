import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[][] map;
	static int[][][] dist;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dist = new int[N][M][2];
		for(int i = 0; i < N; i++){
			String[] split = br.readLine().split("");
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(split[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j][0] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(ar->ar[2]));
		// Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,1,0});
		dist[0][0][0] = 1;

		int[] dx = new int[] {-1, 0, 1, 0};
		int[] dy = new int[] {0, 1, 0, -1};

		int answer = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int nowX = cur[0];
			int nowY = cur[1];
			int nowDist = cur[2];
			int nowWall = cur[3];

			if(nowX == N - 1 && nowY == M - 1){
				answer = Math.min(nowDist, answer);
			}

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				int nextDist = nowDist + 1;
				int nextWall = nowWall;

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
					continue;
				}

				// 벽 처리
				if (map[nextX][nextY] == 1 && nowWall == 0) {
					nextWall++;
				} else if (map[nextX][nextY] == 1 && nowWall >= 1) {
					continue;
				}

				// 벽 처리 이후
				if (nextWall == 0 && dist[nextX][nextY][1] == 0 &&
					nextDist >= dist[nextX][nextY][0]) {
					continue;
				} else if (nextWall == 1 && nextDist >= dist[nextX][nextY][0]) {
					continue;
				}

				dist[nextX][nextY][0] = nextDist;
				dist[nextX][nextY][1] = nextWall;

				queue.add(new int[] {nextX, nextY, nextDist, nextWall});
			}
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
