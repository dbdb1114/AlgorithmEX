import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [==========================문제 분석============================]
 * 외판원 순회 문제는 영어로 Traveling Salesman problem (TSP) 라고 불리는 문제
 * computer science 분야에서 가장 중요하게 취급되는 문제 중 하나이다.
 *
 * 1번부터 N번까지 번호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다.(없을 수도 있다.)
 * 외판원이 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로를 계획하려고 한다.
 * 단, 한 번 갔던 도시로는 다시 갈 수 없다. (맨 마지막에 여행을 출발했던 도시로 돌아오는 것은 예외)
 * 이런 여행 경로는 여러 가지가 있을 수 있는데, 가장 적은 비용을 들이는 여행 계획을 세우고자 한다.
 *
 * 각 도시간에 이동하는데 드는 비용은 행렬 W[i][j]형태로 주어진다.
 * W[i][j]는 도시 i에서 도시 j로 가기 위한 비용을 나타낸다.
 * 즉, W[i][j] 는 W[j][i]와 다를 수 있다.
 *
 * 모든 도시간의 비용은 양의 정수이다. W[i][i]는 항상 0이다.
 * 도시 i에서 도시 j로 갈 수 없는 경우도 있으며 이럴 경우 W[i][j]=0이라고 하자.
 *
 * [==예제==]
 * 첫째 줄에 도시의 수 N이 주어진다. 다음 N개의 줄에는 비용 행렬이 주어진다.
 * 각 행렬의 성분은 1,000,000 이하의 양의 정수이며, 갈 수 없는 경우는 0이 주어진다.
 * W[i][j]는 도시 i에서 j로 가기 위한 비용을 나타낸다.
 * 항상 순회할 수 있는 경우만 입력으로 주어진다.
 *
 * 첫째 줄에 외판원의 순회에 필요한 최소 비용을 출력한다.
 *
 * [==입력==]
 * 4
 * 0 10 15 20
 * 5 0 9 10
 * 6 13 0 12
 * 8 8 9 0
 * [==출력==]
 * 35
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  (2 ≤ N ≤ 10)
 *  ( 각 행렬의 성분은 1,000,000 이하의 양의 정수 )
 *  2. 시간 제한 2초
 *  3. 메모리 제한 256MB
 * [==========================해결 전략============================]
 * 시작점 체크를 해야하므로, DFS를 택한다. DFS를 이용하여 각 경로의 비용을 탐색한다.
 * 동시에 가장 작은값을 넘어가는지도 체크한다.
 *
 * totaly : 방문 배열, 비용 이차원 배열
 * constant : 시작점 유지, 이전 최소 비용 변수,
 * changeable : 누적 비용 변수, depth 변수
 * [==========================슈도 코드============================]
 *
 * boolean[][] visited;
 * int[][] W;
 * int answer;
 * int N;
 *
 * main(){
 *     int N [init]
 *     for(N번){
 *         W[i] = readlineToIntAr
 *     }
 *
 *     DFS();
 *     print(answer);
 * }
 *
 * DFS(int start, int now, int sum, int depth){
 *     if( depth == N && now == start){
 *         answer = Math.min(answer,sum);
 *     }
 *     if( sum > answer ){
 *         return;
 *     }
 *
 *     // now 노드에서 갈 수 있는 곳들
 *     ar[now].stream().foreach(x->{
 *         if(visited[x]) continue;
 *         visited[x] = true;
 *         sum += W[now][x];
 *         DFS(start,x, sum, depth + 1);
 *     })
 * }
*/
public class Main {

    static Set<Integer>[] nodes;
    static boolean[] visited;
    static int[][] W;
    static int answer = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        nodes = new HashSet[N+1];
        visited = new boolean[N+1];
        W = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            nodes[i] = new HashSet();
            String[] line = bf.readLine().split(" ");

            for (int j = 0; j < N; j++) {

                int cost = Integer.parseInt(line[j]);
                W[i][j+1] = cost;

                if(cost != 0){
                    nodes[i].add(j+1);
                }

            }
        }

        for (int i = 1; i < N + 1; i++) {
            visited[i] = true;
            DFS(i, i, 0, 1);
            Arrays.fill(visited, false);
        }

        System.out.println(answer);
    }

    private static void DFS(int start, int now, int sum, int depth) {
        if( depth == N && nodes[now].contains(start)){
            sum += W[now][start];
            answer = Math.min(answer,sum);
            return;
        }

        if( sum > answer ){
            return;
        }

        for (int node: nodes[now]) {
            if(visited[node]) continue;
            visited[now] = true;
            sum += W[now][node];

            DFS(start, node, sum, depth + 1);

            sum -= W[now][node];
            visited[now] = false;
        }
    }

}
