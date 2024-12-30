import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import org.w3c.dom.Node;

/**
 * [==========================문제 분석============================]
 * N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다.
 * 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다.
 * A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라.
 *
 * 도시의 번호는 1부터 N까지이다.
 * [==예제==]
 * [==입력==]
 * 첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고
 * 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다.
 * 그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다.
 *
 * 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
 * 그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다.
 * 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.
 * 그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다.
 * 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
 * [==출력==]
 * 첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 .5초
 *  3. 메모리 제한 128MB
 * [==========================해결 전략============================]
 * 비용은 long타입을 사용 해야 될 수도 있다
 * 출발 도착 버스비
 * 최대한 효율적인 코드를 짜야한다.
 * 비용 행렬을 만든다.1~5
 * 행렬을 순회하며 최소비용을 찾는다.
 * [==========================슈도 코드============================]
 * main () {
 *     int N,M
 *     int[][] fee;
 *     int start;
 *     int end;
 *
 *     for(0~M)
 *         fee[line[0]][line[1]] = line[2];
 * }
 *
 * DFS (int now, int end, int fee) {
 *      if(now == end) {
 *          answer = Math.min(fee, answer);
 *      }
 *
 *      for(int i = 0; i < N; i++){
 *
 *      }
 * }
*/
public class Main {

    static int N;
    static int M;
    static ArrayList<Node> nodes[];
    static int[] fee;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N+1];
        visited = new boolean[N+1];
        fee = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            fee[i] = Integer.MAX_VALUE;
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");

            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);

            nodes[from].add(new Node(to, weight));
        }

        String[] line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);
        
        fee[start] = 0;
        dikjstra(start);

        System.out.println(fee[end]);
    }

    private static void dikjstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            visited[cur.to] = true;


            // 이미 처리된 노드라면 스킵 (현재 fee와 비교)
            if (cur.weight > fee[cur.to]) {
                continue;
            }
            
            // cur.to 에서 출발하는 노드들
            for (Node node : nodes[cur.to]){
                if(fee[cur.to] + node.weight < fee[node.to]){
                    fee[node.to] = fee[cur.to] + node.weight;
                    pq.add(new Node(node.to, fee[node.to]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {

        public int to;
        public int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Node o1){
            return this.weight - o1.weight;
        }
    }
}
