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
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for(int i = 0; i < V+1; i++){
			adjcList[i] = new ArrayList<>();
		}

		for(int i = 0; i < E; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st1.nextToken());
			int v = Integer.parseInt(st1.nextToken());
			int w = Integer.parseInt(st1.nextToken());
			adjcList[u].add(new int[] {v,w});
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[1]));
		pq.add(new int[] {start, 0});

		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int n = cur[0];
			int d = cur[1];

			for(int[] next : adjcList[n]){
				int newN = next[0];
				int newD = d + next[1];

				if(dist[newN] <= newD){
					continue;
				}
				dist[newN] = newD;

				pq.add(new int[] {newN, newD});
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < V+1; i++){
			if (i == start) {
				sb.append(0);
			} else if(dist[i] == Integer.MAX_VALUE){
				sb.append("INF");
			} else {
				sb.append(dist[i]);
			}
			if(i != V){
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}
