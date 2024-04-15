import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int destination;
        int cost;

        public Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 헛간의 수
        int M = Integer.parseInt(st.nextToken()); // 길의 수

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C)); // 양방향 그래프이므로 반대 방향도 추가
        }

        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.offer(new Edge(1, 0)); // 시작 헛간의 비용은 0

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (cost[current.destination] < current.cost) continue; // 현재 비용이 더 크면 스킵

            for (Edge next : graph.get(current.destination)) {
                int nextCost = current.cost + next.cost;
                if (nextCost < cost[next.destination]) {
                    cost[next.destination] = nextCost;
                    pq.offer(new Edge(next.destination, nextCost));
                }
            }
        }

        System.out.println(cost[N]); // 목적지 헛간의 비용 출력
    }
}
