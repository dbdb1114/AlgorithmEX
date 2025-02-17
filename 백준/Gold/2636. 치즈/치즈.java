import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		boolean[][] visited = new boolean[size[0]][size[1]];
		int[][] matrix = new int[size[0]][size[1]];

		for(int i = 0; i < matrix.length; i++){
			matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
		}


		// 남아있는 치즈 카운트
		// 돌고있는 영역 카운트
		// 돌고있는 영역이 전부 카운트 됐다
		// 치즈 반환
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(ar->ar[2]));
		queue.add(new int[] {0,0,0});
		int[] dx = new int[] {1, 0, -1, 0};
		int[] dy = new int[] {0, 1, 0, -1};

		Map<Integer,Integer> distCount = new HashMap<>();
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			int nowX = cur[0];
			int nowY = cur[1];
			int nowDist = cur[2];

			if(matrix[nowX][nowY] == 1) {
				distCount.putIfAbsent(nowDist,0);
				distCount.put(nowDist,distCount.get(nowDist) + 1);
			}

			for (int i = 0; i < 4; i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				int newDist = nowDist + 1;

				if(newX >= matrix.length || newX < 0 || newY >= matrix[0].length || newY < 0 || visited[newX][newY]){
					continue;
				}

				visited[newX][newY] = true;

				if(matrix[newX][newY] == 1){
					queue.add(new int[] {newX, newY, newDist});
				} else {
					queue.add(new int[] {newX, newY, nowDist});
				}
			}
		}

		Integer key = distCount.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().get();
		System.out.println(key);
		System.out.println(distCount.get(key));
	}

}
