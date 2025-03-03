import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer nm = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(nm.nextToken());
		int N = Integer.parseInt(nm.nextToken());

		int[][] box = new int[N][M];
		for(int i = 0; i < N; i++){
			StringTokenizer line = new StringTokenizer(br.readLine());
			int j = 0;
			while(line.hasMoreTokens()){
				box[i][j] = Integer.parseInt(line.nextToken());
				j++;
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(box[i][j] == 1){
					queue.add(new int[] {i,j,0});
				}
			}
		}

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		int answer = 0;
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int day = cur[2];
			answer = day;

			for(int i = 0; i < 4; i++){
				int nX = x + dx[i];
				int nY = y + dy[i];
				int nDay = day + 1;

				if(nX < 0 || nX >= N || nY >= M || nY < 0 ||
					box[nX][nY] == -1 || box[nX][nY] == 1){
					continue;
				}

				box[nX][nY] = 1;
				queue.add(new int[] {nX, nY, nDay});
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0){
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(answer);

	}
}
