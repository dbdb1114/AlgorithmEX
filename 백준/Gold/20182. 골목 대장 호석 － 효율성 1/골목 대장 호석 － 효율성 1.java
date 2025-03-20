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
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int answerVisit = Integer.MAX_VALUE;
		int answerDist = Integer.MAX_VALUE;
		int[][] dist = new int[N+1][2];

		for (int i = 0; i < N+1; i++) {
			dist[i][0] = Integer.MAX_VALUE;
		}

		List<int[]>[] adjList = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st1.nextToken());
			int to = Integer.parseInt(st1.nextToken());
			int ftDist = Integer.parseInt(st1.nextToken());

			adjList[from].add(new int[] {to, ftDist});
			adjList[to].add(new int[] {from, ftDist});
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[1]));
		for(int[] edge : adjList[start]){
			pq.add(new int[]{edge[0], 1, edge[1], edge[1]});
			dist[edge[0]][0] = 1;
			dist[edge[0]][1] = edge[1];
		}

		// 방문 노드도 더 많고,
		// 거리도 더 멀면,
		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int now = cur[0];
			int vcnt = cur[1];
			int nowDist = cur[2];
			int mdist = cur[3];

			for(int[] edge : adjList[now]){
				if(nowDist + edge[1] > money){
					continue;
				}
				if(dist[edge[0]][0] < vcnt+1){
					continue;
				}

				int newMaxDist = Math.max(mdist, edge[1]);
				dist[edge[0]][0] = vcnt+1;
				dist[edge[0]][1] = newMaxDist;
				pq.add(new int[] {edge[0], vcnt + 1, nowDist + edge[1], newMaxDist});
			}
		}

		if (dist[end][0] == Integer.MAX_VALUE){
			System.out.println(-1);
		} else {
			System.out.println(dist[end][1]);
		}
	}

}
