import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;

public class Main {
    /**
     * [==========================문제 분석============================]
     * 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다.
     * 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다.
     * 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
     * (둘러 쌓여있다면)
     * 그림이 입력으로 주어졌을 때,
     * 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
     *
     * [==예제==]
     * RRRBB
     * GGBBB
     * BBBRR
     * BBRRR
     * RRRRR
     *
     * 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다.
     * (빨강 2, 파랑 1, 초록 1)
     * 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다.
     * (빨강-초록 2, 파랑 1)
     *
     * 그림이 입력으로 주어졌을 때,
     * 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
     *
     * [==입력==]
     * 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
     * 둘째 줄부터 N개 줄에는 그림이 주어진다.
     * [==출력==]
     * 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의
     * 구역의 수를 공백으로 구분해 출력한다.
     * [==========================제한 조건============================]
     *  1. (1 ≤ N ≤ 100)
     *      => N이 적긴 하지만, N*N 배열이므로 최대 10000이다.
     *      => 물론 그래도 많은 수는 아니라 빡쎄게는 아니어도 적절히 신경써야한다.
     *  2. 시간 제한 1초
     *  3. 메모리 제한 128MB
     *
     *  => 메모리를 적당히 신경쓰면 된다. 적절한 자료구조 사용
     * [==========================해결 전략============================]
     * 1. 2차원의 방문배열을 설정한다.
     * 2. 우-하단으로 분석해나가는 방식으로 하면 될 것 같다.
     *    만약 첫째줄에서 R을 모두 탐색했다면,
     *    둘째줄로 가서 R을 탐색하고,
     *    R의 범위가 끝날 때까지 탐색하는 방식
     * 3. R과 G의 인접을 어떻게 해결할 것인가?
     *    - 1. 인접 횟수로 판단한다면 R과 G의 분리된 구역이 연결되는 경우가 생기므로 안됨.
     *    - 2. 두 번 탐색을 하는 것은?  => 가장 안전하고, 시간도 괜찮을 것 같음.
     * [==========================슈도 코드============================]
     * 전역 필드
     * 1. N
     * 2. 2차원의 방문배열 ( Array 사용 )
     * 3. 입력 받는 그림 2차원 배열 ( Array 사용 )
     * 4. 구역 카운팅 변수 두 개
     *
     * main() {
     *     N입력받기
     *
     *      RGB 입력 받으면서
     *      2차원 그림 배열 초기화
     *
     *      적록색약용 BFS 한 번
     *      일반용 BFS 한 번
     * }
     *
     *
     * BFS() {
     *
     *     큐에 0,0 추가
     *
     *     for(외곽 탐색){
     *         for(내곽 탐색){
     *             if(방문했는지?) continue;
     *             큐에 추가
     *             while(){
     *                 일반용 두 개 다 초기화 조건분기처리하기
     *
     *                 if(적록색약 방문배열){
     *
     *                 }
     *             }
     *
     *         }
     *     }
     *
     * }
     *
    */


    static int N;
    static String[][] picture;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        visit = new boolean[N][N];
        picture = new String[N][N];

        for (int i = 0; i < N; i++) {
            picture[i] = bf.readLine().split("");
        }

        int normal = BFS(false);
        visit = new boolean[N][N];
        int blind = BFS(true);
        System.out.println(normal + " " + blind);
    }

    public static int BFS(boolean rgBlind){
        int count = 0;
        for (int i = 0; i < N; i++) {
            Queue<int[]> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if(visit[i][j]) continue;;

                // 이번 구역에 대한 컬러 설정과
                // 큐에 인덱스 추가
                queue.add(new int[] {i,j});
                String color = setColor.apply(picture[i][j],rgBlind);

                while(!queue.isEmpty()){

                    int[] poll = queue.poll();
                    
                    int i1 = poll[0];
                    int j1 = poll[1];

                    if (visit[i1][j1]) continue;

                    boolean hasLeft = j1-1 >= 0;
                    boolean hasRight = j1+1 < N;
                    boolean hasDown = i1+1 < N;
                    boolean hasUp = i1-1 >=0;

                    visit[i1][j1] = true;

                    // 좌측 탐색
                    if(hasLeft && setColor.apply(picture[i1][j1-1],rgBlind).equals(color) && !visit[i1][j1-1]){
                        queue.add(new int[] {i1, j1-1});
                    }

                    // 우측 탐색
                    if(hasRight && setColor.apply(picture[i1][j1+1],rgBlind).equals(color) && !visit[i1][j1+1]){
                        queue.add(new int[] {i1, j1+1});
                    }

                    // 하단 탐색
                    if(hasDown && setColor.apply(picture[i1+1][j1],rgBlind).equals(color) && !visit[i1+1][j1]){
                        queue.add(new int[] {i1+1, j1});
                    }

                    // 상단 탐색
                    if(hasUp && setColor.apply(picture[i1-1][j1],rgBlind).equals(color) && !visit[i1-1][j1]){
                        queue.add(new int[] {i1-1, j1});
                    }

                }
                count++;
            }
        }
        return count;
    }


    static BiFunction<String,Boolean,String> setColor = (a, b)->{
        if(b && a.equals("R")){
            return "G";
        } else {
            return a;
        }
    };
}
