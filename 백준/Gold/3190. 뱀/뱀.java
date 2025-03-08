import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] body = new boolean[N][N];
		Queue<int[]> bodyPos = new LinkedList<>();
		Map<Integer, String> direction = new HashMap<>();

		// 사과는 1로 기록
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}

		// 방향 정보는 Map에 초기화
		int L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			direction.put(Integer.parseInt(st.nextToken()),st.nextToken());
		}

		int[] dx = new int[] {-1, 0, 1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		int nowDx = 1;
		int nowDy = 1;
		int time = 0;
		body[0][0] = true;
		bodyPos.add(new int[] {0,0});
		int[] nowPos = new int[] {0,0};

		while(true) {
			int nextX = nowPos[0] + dx[nowDx];
			int nextY = nowPos[1] + dy[nowDy];
			
			time++;

			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || body[nextX][nextY]){
				break;
			}


			// 꼬리 줄이기
			if(map[nextX][nextY] != 1) {
				int[] cur = bodyPos.poll();
				body[cur[0]][cur[1]] = false;
			} else {
				map[nextX][nextY] = 0;
			}

			// 머리 늘리기
			bodyPos.add(new int[] {nextX, nextY});
			body[nextX][nextY] = true;

			nowPos[0] = nextX;
			nowPos[1] = nextY;
			// 현재 위치 최신화
			if(direction.containsKey(time)) {
				if(direction.get(time).equals("D")){
					if(nowDx == 3){
						nowDx = 0;
						nowDy = 0;
					} else {
						nowDx += 1;
						nowDy += 1;
					}
				} else {
					if(nowDx == 0){
						nowDx = 3;
						nowDy = 3;
					} else {
						nowDx -= 1;
						nowDy -= 1;
					}
				}
			}
		}

		System.out.println(time);
	}
}
