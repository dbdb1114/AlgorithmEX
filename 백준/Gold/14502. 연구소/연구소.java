import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 바이러스의 확산을 막기 위해 벽을 세운다.
 N * M


 1. 0인 곳 배열 초기화
 2. 0인 곳을 3개씩 고르며 백트래킹
 3. 전염시키는 메소드 실행
 4. 0인 곳 갯수 세기
 */

class Main {
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<int[]> zeroPositions = new ArrayList<>();
		int[][] map = new int[N][M];

		for(int i = 0; i < N; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st1.nextToken());
				if(map[i][j] == 0) {
					zeroPositions.add(new int[] {i,j});
				}
			}
		}

		for(int i = 0; i < zeroPositions.size(); i++){
			for(int j = i + 1; j < zeroPositions.size(); j++){
				for(int k = j + 1; k < zeroPositions.size(); k++){
					int[] one = zeroPositions.get(i);
					int[] two = zeroPositions.get(j);
					int[] three = zeroPositions.get(k);

					map[one[0]][one[1]] = 1;
					map[two[0]][two[1]] = 1;
					map[three[0]][three[1]] = 1;

					fluid(map);

					map[one[0]][one[1]] = 0;
					map[two[0]][two[1]] = 0;
					map[three[0]][three[1]] = 0;
				}
			}
		}
		System.out.println(answer);
	}

	public static void fluid(int[][] originMap){
		int[][] map = new int[originMap.length][originMap[0].length];
		for(int i = 0; i < originMap.length; i++){
			for (int j = 0; j < originMap[0].length; j++) {
				map[i][j] = originMap[i][j];
			}
		}

		boolean[][] visited = new boolean[map.length][map[0].length];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				if(map[i][j] != 2 || visited[i][j]) continue;
				fluid1(new int[] {i,j}, map, visited);
			}
		}

		int cnt = 0;
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				if(map[i][j] == 0) {
					cnt++;
				}
			}
		}
		answer = Math.max(cnt, answer);
	}

	public static void fluid1(int[] pos, int[][] map, boolean[][] visited) {
		int[] dx = new int[] {1, 0, -1, 0};
		int[] dy = new int[] {0, 1, 0, -1};

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {pos[0], pos[1]});
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length
					|| map[nx][ny] == 1 || visited[nx][ny]){
					continue;
				}

				map[nx][ny] = 2;
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}
}
