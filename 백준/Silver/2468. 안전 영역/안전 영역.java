import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [==========================문제 분석============================]
 * 먼저 어떤 지역의 높이 정보를 파악한다.
 * 그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는
 * 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다.
 * 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.
 *
 * 어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인
 * 2차원 배열 형태로 주어지며 배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다.
 *
 * 이제 위와 같은 지역에 많은 비가 내려서 높이가 4 이하인 모든 지점이 물에 잠겼다고 하자.
 * 이 경우에 물에 잠기는 지점을 회색으로 표시하면 다음과 같다.
 *
 * 물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 위, 아래, 오른쪽 혹은 왼쪽으로
 * 인접해 있으며 그 크기가 최대인 영역을 말한다.
 * 위의 경우에서 물에 잠기지 않는 안전한 영역은 5개가 된다(꼭짓점으로만 붙어 있는 두 지점은 인접하지 않는다고 취급한다).
 *
 * [==예제==]
 * [==입력==]
 * [==출력==]
 * [==========================제한 조건============================]
 *  1. 입력값 범위 N은 2 이상 100 이하의 정수
 *  2. 시간 제한 1 초
 *  3. 메모리 제한 128 MB
 * [==========================해결 전략============================]
 * 1. 물에 잠기지 않는 모든 곳을 탐색한다.
 *      => 최대와 최소를 확인하여 비의 최대 최소로 설정한다.
 * 2. 해당 위치를 저장한 후에 각 위치들의 연결성을 확인하며, 안전지대의 개수를 확인한다.
 *
 * 물이 잠기지않는 곳을 탐색하여, 해당 위치별로 BFS를 실시한다. 그렇게 해서 안전지대의 크기를 다시 확인하고,
 * 수위를 높혀서 다시 물이 잠기지 않는 곳을 탐색한다.
 *
 * 즉, 물의 수위를 높히는 반복문 안에서 물의 수위를 다 높혔을 때, 안전지대에 대한 BFS실행 / DFS를 실행해도 된다.
 * 위 과정을 반복하여, 안전지대가 가장 많을 때를 도출한다.
 *
 * [==========================슈도 코드============================]
*/
public class Main {

    static int N;
    static int[][] rainMap; // 10000 => 전체 탐색 * 100 => 1000000 * BFS
    static boolean[][] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        rainMap = new int[N][N];
        visit = new boolean[N][N];

        // 위험 수위 저장
        int maxRain = 0;
        int minRain = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int rain = Integer.parseInt(line[j]);
                rainMap[i][j] = rain;
                maxRain = Math.max(rain, maxRain);
                minRain = Math.min(rain, minRain);
            }
        }


        for (int i = minRain; i < maxRain; i++) {
            // 모든 영역들에 대해서 DFS를 실행하면 된다.
            int safe = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(!visit[j][k] && rainMap[j][k] > i) {

                        DFS(j ,k ,i);
                        safe++;
                    } else {
                        visit[j][k] = true;
                    }
                }
            }
            answer = Math.max(answer,safe);
            visit = new boolean[N][N];
        }

        // 모든 곳이 비에 잠기는 경우를 고려하여, 최소 1로 잡아둔다.
        System.out.println(Math.max(answer, 1));

    }

    public static void DFS(int x, int y,int rain){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!validIdx(nx,ny)) continue;

            if(!visit[nx][ny] && rainMap[nx][ny] > rain){ // 안전지대일 때
                visit[nx][ny] = true;
                DFS(nx,ny,rain);
            } else {
                visit[nx][ny] = true;
            }
        }
    }

    public static boolean validIdx(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
