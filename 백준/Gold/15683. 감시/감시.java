import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
	static int N;
	static int M;
	static int answer = Integer.MAX_VALUE;
	static Map<Integer, List<int[]>> moves = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nAndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = nAndM[0];
		M = nAndM[1];

		for (int i = 1; i <= 5; i++) {
			moves.put(i, new ArrayList<>());
		}

		moves.get(1).add(new int[] {0,1,0,0});
		moves.get(1).add(new int[] {0,0,1,0});
		moves.get(1).add(new int[] {0,0,0,1});
		moves.get(1).add(new int[] {1,0,0,0});

		moves.get(2).add(new int[] {0,1,0,1});
		moves.get(2).add(new int[] {1,0,1,0});

		moves.get(3).add(new int[] {1,1,0,0});
		moves.get(3).add(new int[] {0,1,1,0});
		moves.get(3).add(new int[] {0,0,1,1});
		moves.get(3).add(new int[] {1,0,0,1});

		moves.get(4).add(new int[] {1,1,0,1});
		moves.get(4).add(new int[] {0,1,1,1});
		moves.get(4).add(new int[] {1,1,1,0});
		moves.get(4).add(new int[] {1,0,1,1});

		moves.get(5).add(new int[] {1,1,1,1});

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		recursive(map, 0, 0);

		System.out.println(answer);
	}

	static void recursive(int[][] map, int x, int y) {
		if(y == M){
			x = x + 1;
			y = 0;
		}

		for (int i = x; i < N; i++) {
			for (int j = y; j < M; j++) {
				if(moves.containsKey(map[i][j])){
					for(int[] move : moves.get(map[i][j])){
						check(map, move, i, j);
						if(i == N - 1 && j == M - 1){
							countMap(map);
						}
						recursive(map, i, j+1);

						unCheck(map, move, i, j);
					}
				}
				if(i == N - 1 && j == M - 1){
					countMap(map);
				}
			}
			y=0;
		}
	}

	private static void countMap(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0){
					cnt++;
				}
			}
		}
		answer = Math.min(answer, cnt);
	}

	public static void check(int[][] map, int[] move, int x, int y){
		if(move[0] != 0){ // 위쪽
			for (int i = x-1; i>=0; i--){
				if(map[i][y] == 6){
					break;
				}
				if (map[i][y] == 0 || map[i][y] >= 10){
					map[i][y] += 10;
				}
			}
		}
		if(move[1] != 0){ // 오른쪽
			for (int i = y+1; i<M; i++){
				if(map[x][i] == 6){
					break;
				}
				if (map[x][i] == 0 || map[x][i] >= 10){
					map[x][i] += 10;
				}
			}
		}
		if(move[2] != 0){ // 아래쪽
			for (int i = x+1; i<N; i++){
				if(map[i][y] == 6){
					break;
				}
				if (map[i][y] == 0 || map[i][y] >= 10){
					map[i][y] += 10;
				}
			}
		}
		if(move[3] != 0){ // 왼쪽
			for (int i = y-1; i>=0; i--){
				if(map[x][i] == 6){
					break;
				}
				if (map[x][i] == 0 || map[x][i] >= 10){
					map[x][i] += 10;
				}
			}
		}
	}

	public static void unCheck(int[][] map, int[] move, int x, int y){
		if(move[0] != 0){ // 위쪽
			for (int i = x-1; i>=0; i--){
				if(map[i][y] == 6){
					break;
				}
				if (map[i][y] >= 10){
					map[i][y] -= 10;
				}
			}
		}
		if(move[1] != 0){ // 오른쪽
			for (int i = y+1; i<M; i++){
				if(map[x][i] == 6){
					break;
				}
				if (map[x][i] >= 10){
					map[x][i] -= 10;
				}
			}
		}
		if(move[2] != 0){ // 아래쪽
			for (int i = x+1; i<N; i++){
				if(map[i][y] == 6){
					break;
				}
				if (map[i][y] >= 10){
					map[i][y] -= 10;
				}
			}
		}
		if(move[3] != 0){ // 왼쪽
			for (int i = y-1; i>=0; i--){
				if(map[x][i] == 6){
					break;
				}
				if (map[x][i] >= 10){
					map[x][i] -= 10;
				}
			}
		}
	}
}
