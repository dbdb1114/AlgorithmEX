import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		int answer = 0;
		for(int i = 0; i < N; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				map[i+1][j+1] = Integer.parseInt(st1.nextToken());
			}
		}

		while(!checkAllMelt()){
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N+2][M+2];
			queue.add(new int[] {0,0});

			Queue<int[]> cheeseQueue = new LinkedList<>();

			while(!queue.isEmpty()){
				int[] cur = queue.poll();
				int nowX = cur[0];
				int nowY = cur[1];

				for(int i = 0; i < 4; i++){
					int newX = nowX + dx[i];
					int newY = nowY + dy[i];
					if(isInValidIndex(newX,newY) || visited[newX][newY]) {
						continue;
					}

					if(map[newX][newY] == 1) {
						cheeseQueue.add(new int[] {newX, newY});
						continue;
					}

					visited[newX][newY] = true;
					queue.add(new int[] {newX, newY});
				}
			}

			while(!cheeseQueue.isEmpty()){
				int[] cur = cheeseQueue.poll();
				int nowX = cur[0];
				int nowY = cur[1];

				int cnt = 0;
				for(int j = 0; j < 4; j++){
					if(isInValidIndex(nowX + dx[j], nowY + dy[j])){
						continue;
					}
					if(map[nowX+dx[j]][nowY+dy[j]]==0 && visited[nowX + dx[j]][nowY + dy[j]]){
						cnt++;
					}
				}
				if(cnt >= 2){
					map[nowX][nowY] = 2;
				}
			}

			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < M+2; j++) {
					if(map[i][j] == 2) {
						map[i][j] = 0;
					}
				}
			}
			answer++;
		}
		System.out.println(answer);
	}

	public static boolean isInValidIndex(int x, int y){
		return x < 0 || x >= N+2 || y < 0 || y >= M+2 ;
	}

	public static boolean checkAllMelt() {
		for(int i = 0; i < N+2; i++){
			for(int j = 0; j < M+2; j++){
				if(map[i][j]==1){
					return false;
				}
			}
		}
		return true;
	}
}
