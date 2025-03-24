import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int[][] map;
	static int N;
	static int[] dx = new int[] {-1, 0, 1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	static int mySize = 2;
	static int myEat = 0;
	static int myX;
	static int myY;
	static int timer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					myX = i;
					myY = j;
				}
			}
		}

		while(findFish() == 0){}

		System.out.println(timer);
	}

	public static int findFish(){
		PriorityQueue<int[]> canEatFish = new PriorityQueue<>((a1,a2)->{
			if(a1[2] == a2[2]){
				if(a1[0] != a2[0]){
					return a1[0] - a2[0];
				} else {
					return a1[1] - a2[1];
				}
			} else {
				return a1[2] - a2[2];
			}
		});
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[2]));
		pq.add(new int[]{myX,myY,0});
		boolean[][] visited = new boolean[N][N];

		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int nowX = cur[0];
			int nowY = cur[1];
			int nowDist = cur[2];

			if(1 <= map[nowX][nowY] && map[nowX][nowY] <= 6 && map[nowX][nowY] < mySize){
				if(canEatFish.isEmpty()){
					canEatFish.add(new int[] {nowX, nowY, nowDist});
				} else if (canEatFish.peek()[2] == nowDist){
					canEatFish.add(new int[] {nowX, nowY, nowDist});
				} else if (canEatFish.peek()[2] > nowDist){
					canEatFish.clear();
					canEatFish.add(new int[] {nowX, nowY, nowDist});
				}
				continue;
			}

			for(int i = 0; i < 4; i++){
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				int newDist = nowDist + 1;

				if(newX < 0 || newX >= N || newY < 0 || newY >= N ||
					map[newX][newY] > mySize || visited[newX][newY]){
					continue;
				}
				visited[newX][newY] = true;
				pq.add(new int[]{newX, newY, newDist});
			}
		}

		if(canEatFish.isEmpty()){
			return -1;
		} else {
			int[] cur = canEatFish.poll();
			map[myX][myY] = 0;
			myX = cur[0];
			myY = cur[1];
			timer += cur[2];
			myEat++;
			if(myEat == mySize){
				myEat = 0;
				mySize++;
			}
			map[myX][myY] = 9;

			return 0;
		}
	}
}
