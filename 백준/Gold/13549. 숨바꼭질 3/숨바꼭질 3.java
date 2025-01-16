import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int answer = Integer.MAX_VALUE;
	static boolean[] visited = new boolean[100_001];
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		K = Integer.parseInt(line[1]);

		bfs(N, 0);
		System.out.println(answer);
	}

	public static void bfs(int now, int time) {
		Deque<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] {now, time});
		visited[now] = true;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			if (poll[0] == K) {
				answer = Math.min(answer,poll[1]);
				return;
			}

			if (isValid(poll[0] * 2)) {
				visited[poll[0] * 2] = true;
				queue.addFirst(new int[] {poll[0] * 2, poll[1]});
			}
			if (isValid(poll[0] - 1)) {
				visited[poll[0] - 1] = true;
				queue.addLast(new int[] {poll[0] - 1, poll[1] + 1});
			}
			if (isValid(poll[0] + 1)) {
				visited[poll[0] + 1] = true;
				queue.addLast(new int[] {poll[0] + 1, poll[1] + 1});
			}
		}
	}

	public static boolean isValid(int number) {
		return number >= 0 && number < visited.length && !visited[number];
	}
}
