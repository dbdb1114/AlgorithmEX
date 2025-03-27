import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
	static int M;
	static int N;
	static int[][] map;
	static int[][] memo;
	static boolean[][] visited;
	static int answer = 0;
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		memo = new int[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(memo[i], -1);
		}
		visited = new boolean[M][N];
		for(int i = 0; i < M; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}

		visited[0][0] = true;
		DFS(new int[] {0,0});
		System.out.println(answer);
	}

	static void DFS(int[] now) {
		int nowX = now[0];
		int nowY = now[1];

		if(nowX == M - 1 && nowY == N -1) {
			answer++;
			return;
		}

		if(memo[nowX][nowY] != -1){
			answer += memo[nowX][nowY];
			return;
		}

		int nowAnswer = answer;

		for(int i = 0; i < 4; i++){
			int newX = nowX + dx[i];
			int newY = nowY + dy[i];
			if(newX < 0 || newX >= M || newY < 0 || newY >= N || visited[newX][newY] ){
				continue;
			}
			if(map[newX][newY] >= map[nowX][nowY]){
				continue;
			}

			visited[newX][newY] = true;
			DFS(new int[] {newX, newY});
			visited[newX][newY] = false;
		}
		memo[nowX][nowY] = answer - nowAnswer;
	}
}
