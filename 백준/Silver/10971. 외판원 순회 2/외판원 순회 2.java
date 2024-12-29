import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [==========================문제 분석============================]
 * 외판원 순회 문제는 영어로 Traveling Salesman problem (TSP) 라고 불리는 문제로
 * computer science 분야에서 가장 중요하게 취급되는 문제 중 하나이다.
 * 여러 가지 변종 문제가 있으나, 여기서는 가장 일반적인 형태의 문제를 살펴보자.
 *
 * 1번부터 N번까지 번호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다. (길이 없을 수도 있다)
 * 이제 한 외판원이 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는
 * 순회 여행 경로를 계획하려고 한다. 단, 한 번 갔던 도시로는 다시 갈 수 없다. (맨 마지막에 여행을 출발했던 도시로 돌아오는 것은 예외)
 * 이런 여행 경로는 여러 가지가 있을 수 있는데, 가장 적은 비용을 들이는 여행 계획을 세우고자 한다.
 *
 * 각 도시간에 이동하는데 드는 비용은 행렬 W[i][j]형태로 주어진다.
 * W[i][j]는 도시 i에서 도시 j로 가기 위한 비용을 나타낸다.
 * 비용은 대칭적이지 않다. 즉, W[i][j] 는 W[j][i]와 다를 수 있다.
 * 모든 도시간의 비용은 양의 정수이다. W[i][i]는 항상 0이다.
 * 경우에 따라서 도시 i에서 도시 j로 갈 수 없는 경우도 있으며 이럴 경우 W[i][j]=0이라고 하자.
 *
 * N과 비용 행렬이 주어졌을 때, 가장 적은 비용을 들이는 외판원의 순회 여행 경로를 구하는 프로그램을 작성하시오.
 * [==예제==]
 * 4
 * 0 10 15 20
 * 5 0 9 10
 * 6 13 0 12
 * 8 8 9 0
 *
 * 35
 * [==입력==]
 * 첫째 줄에 도시의 수 N이 주어진다.
 * (2 ≤ N ≤ 10) 다음 N개의 줄에는 비용 행렬이 주어진다.
 * 각 행렬의 성분은 1,000,000 이하의 양의 정수이며,
 * 갈 수 없는 경우는 0이 주어진다. W[i][j]는 도시 i에서 j로 가기 위한 비용을 나타낸다.
 *
 * 항상 순회할 수 있는 경우만 입력으로 주어진다.
 * [==출력==]
 * 첫째 줄에 외판원의 순회에 필요한 최소 비용을 출력한다.
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  2. 시간 제한 N초
 *  3. 메모리 제한 NMB
 * [==========================해결 전략============================]
 * 가능 한 모든 경우에서 비용을 Math.min 하면 된다.
 * DFS를 사용하고, 시작지점을 visit배열에 체크하지 않는다.
 * 탈출 조건을
 * [==========================슈도 코드============================]
 * 메인함수
 *  N과 W를 전역으로 입력 받는다.
 *  for( i 1 ~ N){
 *      DFS(시작점)
 *  }
 *
 * DFS (시작점Y, 비용) {
 *     if(모두 방문 했다면){
 *         answer = Math.min(answer, 비용)
 *         return;
 *     }
 *     for(W[Y] 1 ~ N){
 *         if(방문X){
 *            비용 += w[i]
 *            방문체크
 *            DFS(i)
 *            비용 -= w[i]
 *            방문체크해제
 *         }
 *     }
 * }
*/
public class Main {

    static boolean[] visited;
    static int[][] W;
    static int N;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        W = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                W[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            findOut(i,i,0,1);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    private static void findOut(int start, int pos, int price, int depth) {
        if(depth == N){
            if(W[pos][start] != 0){
                price += W[pos][start];
                answer = Math.min(price,answer);
            }
            return;
        }
        
        if(price > answer){
            return;
        }

        for (int i = 0; i < N; i++) {
            int targetPrice = W[pos][i];
            if(!visited[i] && targetPrice != 0){
                visited[i] = true;
                findOut(start, i, price + targetPrice, depth + 1);
                visited[i] = false;
            }
        }
    }
}
