import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [==========================문제 분석============================]
 * 젤다의 전설 게임에서 화폐의 단위는 루피(rupee)다.
 * 그런데 간혹 '도둑루피'라 불리는 검정색 루피도 존재하는데,
 * 이걸 획득하면 오히려 소지한 루피가 감소하게 된다!
 *
 * 젤다의 전설 시리즈의 주인공, 링크는 지금 도둑루피만 가득한 N x N 크기의 동굴의 제일 왼쪽 위에 있다.
 * [0][0]번 칸이기도 하다.
 * 왜 이런 곳에 들어왔냐고 묻는다면 밖에서 사람들이 자꾸 "젤다의 전설에 나오는 녹색 애가 젤다지?"라고 물어봤기 때문이다.
 * 링크가 녹색 옷을 입은 주인공이고 젤다는 그냥 잡혀있는 공주인데,
 * 게임 타이틀에 젤다가 나와있다고 자꾸 사람들이 이렇게 착각하니까 정신병에 걸릴 위기에 놓인 것이다.
 *
 * 하여튼 젤다...아니 링크는 이 동굴의 반대편 출구, 제일 오른쪽 아래 칸인 [N-1][N-1]까지 이동해야 한다.
 * 동굴의 각 칸마다 도둑루피가 있는데, 이 칸을 지나면 해당 도둑루피의 크기만큼 소지금을 잃게 된다.
 * 링크는 잃는 금액을 최소로 하여 동굴 건너편까지 이동해야 하며, 한 번에 상하좌우 인접한 곳으로 1칸씩 이동할 수 있다.
 *
 * 링크가 잃을 수밖에 없는 최소 금액은 얼마일까?
 * [==예제==]
 * [==입력==]
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 *
 * 각 테스트 케이스의 첫째 줄에는 동굴의 크기를 나타내는 정수 N이 주어진다.
 * (2 ≤ N ≤ 125) N = 0인 입력이 주어지면 전체 입력이 종료된다.
 *
 * 이어서 N개의 줄에 걸쳐 동굴의 각 칸에 있는 도둑루피의 크기가 공백으로 구분되어 차례대로 주어진다.
 * 도둑루피의 크기가 k면 이 칸을 지나면 k루피를 잃는다는 뜻이다. 여기서 주어지는 모든 정수는 0 이상 9 이하인 한 자리 수다.
 * [==출력==]
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 N초
 *  3. 메모리 제한 NMB
 * [==========================해결 전략============================]
 * [==========================슈도 코드============================]
 */
public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int problem = 0;
		while (true) {
			String nString = br.readLine();
			if (nString.equals("0"))
				return;

			int N = Integer.parseInt(nString);
			int[][] map = new int[N][N];
			int[][] distMap = new int[N][N];
			boolean[][] visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(distMap[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}

			distMap[0][0] = map[0][0];
			visited[0][0] = true;

			calculateDist(map, distMap, visited);

			System.out.println("Problem " + ++problem + ": " + distMap[N - 1][N - 1]);
		}
	}

	static void calculateDist(int[][] map, int[][] distMap, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {0, 0});

		while (!queue.isEmpty()) {

			int[] poll = queue.poll();

			int x = poll[0];
			int y = poll[1];

			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (validIndex(newX, newY, map.length)) {
					if (distMap[x][y] + map[newX][newY] < distMap[newX][newY]) {
						distMap[newX][newY] = distMap[x][y] + map[newX][newY];
						queue.add(new int[] {newX, newY});
					}
					if (!visited[newX][newY]) {
						visited[newX][newY] = true;
						queue.add(new int[] {newX, newY});
					}
				}
			}
		}
	}

	private static boolean validIndex(int newX, int newY, int limit) {
		return newX >= 0 && newY >= 0 && newX < limit && newY < limit;
	}
}
