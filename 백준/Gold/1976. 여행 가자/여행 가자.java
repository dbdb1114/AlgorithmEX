import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	
	static int[][] map;
	static boolean[] visited;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		check = new boolean[N+1];

		for (int i = 1; i < N+1; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j+1] = Integer.parseInt(line[j]);
			}
		}

		int[] trip = new int[M];
		String[] strTrip = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			trip[i] = Integer.parseInt(strTrip[i]);
		}

		BFS(trip[0]);
		for (int i = 0; i < trip.length; i++) {
			if(!visited[trip[i]]){
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}

	public static void BFS(int start){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while(!queue.isEmpty()){
			Integer cur = queue.poll();

			if(visited[cur]){
				continue;
			}
			visited[cur] = true;

			for (int i = 1; i < map[cur].length; i++) {
				if (map[cur][i] == 1){
					queue.add(i);
				}
			}
		}

	}
}
