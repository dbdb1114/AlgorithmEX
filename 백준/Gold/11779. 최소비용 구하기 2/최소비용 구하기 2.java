import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int N;
	static int M;
	static List<int[]>[] adjcList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adjcList = new ArrayList[N+1];
		long[] dist = new long[N+1];
		Arrays.fill(dist,Long.MAX_VALUE);
		List<Integer>[] path = new ArrayList[N+1];

		for(int i = 0; i < N + 1; i++){
			adjcList[i] = new ArrayList<>();
			path[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			adjcList[s].add(new int[] {e, d});
		}

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st1.nextToken());
		int end = Integer.parseInt(st1.nextToken());

		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[1]));
		dist[start] = 0;
		pq.add(new long[] { start, 0 });

		while (!pq.isEmpty()) {
			long[] cur = pq.poll();
			int n = (int) cur[0];
			long d = cur[1];

			if (dist[n] < d) continue;

			for (int[] adjc : adjcList[n]) {
				if (dist[adjc[0]] > d + adjc[1]) {
					dist[adjc[0]] = d + adjc[1];

					path[adjc[0]].clear();
					path[adjc[0]].addAll(path[n]);
					path[adjc[0]].add(n);

					pq.add(new long[] { adjc[0], dist[adjc[0]] });
				}
			}
		}


		StringBuilder sb = new StringBuilder();
		sb.append(dist[end])
			.append("\n")
			.append(path[end].size() + 1)
			.append("\n");
		path[end].forEach(c->sb.append(c + " "));
		sb.append(end);
		System.out.println(sb);

	}
}
