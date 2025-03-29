
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		int[] dx = new int[] {-1, 0, 1, 0};
		int[] dy = new int[] {0, -1, 0, 1};
		int[][] backD = new int[][] {{1,0}, {0,1},{-1,0},{0,-1}};
		int answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int rX = Integer.parseInt(st1.nextToken());
		int rY = Integer.parseInt(st1.nextToken());
		int rD = Integer.parseInt(st1.nextToken());
		if(rD == 1){
			rD = 3;
		} else if (rD == 3){
			rD = 1;
		}

		for(int i = 0; i < N; i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {rX,rY,rD});
		while(!qu.isEmpty()){
			int[] cur = qu.poll();
			int nowX = cur[0];
			int nowY = cur[1];
			int nowD = cur[2];

			if(map[nowX][nowY] == 0){
				map[nowX][nowY] = 2;
				answer++;
			}


			boolean moveNext = false;
			for(int i = 1; i <= 4; i++){
				int newD = rotate(nowD, i);
				int newX = nowX + dx[newD];
				int newY = nowY + dy[newD];

				if(newX < 0 || newX >= N || newY < 0 || newY >= M || map[newX][newY] == 1 || map[newX][newY] == 2){
					continue;
				}

				if(map[newX][newY] == 0){
					moveNext = true;
					qu.add(new int[] {newX, newY, newD});
					break;
				}
			}
			if(moveNext){
				continue;
			}

			// 빈 칸이 없는 경우
			int newX = nowX + backD[nowD][0];
			int newY = nowY + backD[nowD][1];

			if(newX < 0 || newX >= N || newY < 0 || newY >= M || map[newX][newY] == 1){
				continue;
			}

			if(map[newX][newY] != 1){
				qu.add(new int[] {newX, newY, nowD});
			}
		}

		System.out.println(answer);
	}

	static int rotate(int now, int rotate){
		now += rotate;
		if(now > 3){
			now -= 4;
		}
		return now;
	}
}
