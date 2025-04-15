import java.io.BufferedReader;
import java.io.InputStreamReader;
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

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<int[]>[] adjcList = new ArrayList[N+1];

		for(int i = 0; i < N+1; i++){
			adjcList[i] = new ArrayList<>();
		}

		for(int i = 0; i < E; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st1.nextToken());
			int n2 = Integer.parseInt(st1.nextToken());
			int d = Integer.parseInt(st1.nextToken());

			adjcList[n1].add(new int[] {n2, d});
			adjcList[n2].add(new int[] {n1, d});
		}

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st1.nextToken());
		int v2 = Integer.parseInt(st1.nextToken());

		int answer = Math.min(dijkstra(adjcList, new int[] {v1,v2, N}), dijkstra(adjcList, new int[] {v2,v1,N}));
		if(answer == Integer.MAX_VALUE){
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	public static int dijkstra(List<int[]>[] adjcList, int[] order){
		int answer = 0;
		int[] dist = new int[adjcList.length];
		for (int i = 0; i < order.length; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			boolean find = false;
			int start = 1;
			if(i > 0){
				start = order[i-1];
			}
			dist[start] = 0;
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[1]));
			pq.add(new int[] {start, 0});
			while(!pq.isEmpty()){
				int[] cur = pq.poll();
				if(cur[0] == order[i]){
					find = true;
					answer += cur[1];
					break;
				}

				for(int[] edge : adjcList[cur[0]]){
					if(dist[edge[0]] <= cur[1] + edge[1]){
						continue;
					}

					dist[edge[0]] = cur[1] + edge[1];
					pq.add(new int[] {edge[0], cur[1] + edge[1]});
				}
			}

			if(!find){
				return Integer.MAX_VALUE;
			}
		}
		return answer;
	}
}
