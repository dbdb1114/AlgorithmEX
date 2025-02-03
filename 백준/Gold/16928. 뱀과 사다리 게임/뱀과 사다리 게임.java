import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * */
public class Main {
	static Map<Integer, Integer> shortLoad = new HashMap<>();
	static boolean[] visited = new boolean[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NandM = br.readLine().split(" ");
		int N = Integer.parseInt(NandM[0]);
		int M = Integer.parseInt(NandM[1]);

		for (int i = 0; i < N + M; i++) {
			String[] road = br.readLine().split(" ");
			shortLoad.put(Integer.parseInt(road[0]), Integer.parseInt(road[1]));
		}

		BFS();
	}

	public static void BFS() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(ar -> ar[1]));

		pq.add(new int[] {1,0});

		while(!pq.isEmpty()){

			int[] cur = pq.poll();
			int now = cur[0];
			int dist = cur[1];

			if(now > 100 || visited[now]) {
				continue;
			}
			visited[now] = true;

			if(now == 100){
				System.out.println(dist);
				return;
			}


			for (int i = 1; i < 7; i++) {
				int nextPos;
				if(shortLoad.containsKey(now + i)){
					nextPos = shortLoad.get(now+i);
				} else {
					nextPos = now + i;
				}

				pq.add(new int[] {nextPos, dist + 1});
			}
		}
	}
}
