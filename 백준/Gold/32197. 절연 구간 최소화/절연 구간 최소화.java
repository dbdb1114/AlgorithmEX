import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nAndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = nAndM[0];
		int M = nAndM[1];
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist,Integer.MAX_VALUE);

		List<int[]>[] edges = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++){
			edges[i] = new ArrayList<int[]>();
		}

		for(int i = 0; i < M; i++){
			int[] edge = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
			edges[edge[0]].add(new int[] {edge[1], edge[2]});
			edges[edge[1]].add(new int[] {edge[0], edge[2]});
		}

		int[] startAndEnd = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		int start = startAndEnd[0];
		int end = startAndEnd[1];

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(ar -> ar[2]));

		for(int[] edge : edges[start]) {
			pq.add(new int[]{edge[0], edge[1], 0});
		}

		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int now = cur[0];
			int nowElectron = cur[1];
			int nowDist = cur[2];

			if(dist[now] < nowDist){
				continue;
			}

			dist[now] = nowDist;
			
			if(end == now){
				break;
			}

			for(int[] edge : edges[now]) {
				int edgeDist = 0;
				if(edge[1] != nowElectron){
					edgeDist = 1;
				}

				if(dist[edge[0]] <= nowDist + edgeDist) {
					continue;
				}

				pq.add(new int[]{edge[0], edge[1], nowDist + edgeDist});
			}
		}

		System.out.println(dist[end]);
	}
}
