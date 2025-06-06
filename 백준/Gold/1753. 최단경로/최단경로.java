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
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		List<int[]>[] adjcList = new List[V+1];

		for(int i = 0; i < V+1; i++){
			adjcList[i] = new ArrayList<>();
		}

		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		for(int i = 0; i < E; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st1.nextToken());
			int v = Integer.parseInt(st1.nextToken());
			int w = Integer.parseInt(st1.nextToken());
			adjcList[u].add(new int[] {v,w});
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
		pq.add(new int[] {start, 0});

		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int n = cur[0];
			int d = cur[1];

			if(dist[n] < d) continue;

			for(int[] next : adjcList[n]){
				int newN = next[0];
				int newD = d + next[1];

				if(dist[newN] > newD){
					dist[newN] = newD;
					pq.add(new int[] {newN, newD});
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.print(sb);
	}
}
