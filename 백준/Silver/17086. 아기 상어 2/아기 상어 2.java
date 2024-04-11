import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [==========================문제 분석============================]
 * N×M 크기의 공간에 아기 상어 여러 마리가 있다.
 * 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다.
 * 한 칸에는 아기 상어가 최대 1마리 존재한다.
 *
 * 어떤 칸의 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리이다.
 * 두 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해서 지나야 하는 칸의 수이고,
 * 이동은 인접한 8방향(대각선 포함)이 가능하다.
 *
 * 안전 거리가 가장 큰 칸을 구해보자.
 * [==예제==]
 * 첫째 줄에 공간의 크기 N과 M(2 ≤ N, M ≤ 50)이 주어진다.
 * 둘째 줄부터 N개의 줄에 공간의 상태가 주어지며
 * 0은 빈 칸, 1은 아기 상어가 있는 칸이다.
 * 빈 칸과 상어의 수가 각각 한 개 이상의 입력만 주어진다.
 *
 * [==입력==]
 * 5 4
 * 0 0 1 0
 * 0 0 0 0
 * 1 0 0 0
 * 0 0 0 0
 * 0 0 0 1
 * [==출력==]
 * 2
 * [==========================제한 조건============================]
 *  1. 입력값 범위
 *  (2 ≤ N, M ≤ 50) => 탐색 개수가 최대 250개이다.
 *  O(N^2)도 괜찮다.
 *  2. 시간 제한 2초
 *  3. 메모리 제한 512MB
 * [==========================해결 전략============================]
 * [case1]
 * 1. 방향 탐색을 사용한다. dx = {} / dy = {}
 * 2. 각 칸별로 모든 안전거리를 구한다.
 * 3. 칸별로 갈 수 있는 모든 위치를 탐색하고, 1이 나오면 종료한다.
 * 4. 다만 모든 탐색별로 몇 번째 탐색인지 정확히 유지해야한다.
 * =>
 * [==========================슈도 코드============================]
 * int[] dx = {-1 -1 0 +1 +1 +1 0 -1}
 * int[] dy = {0 1 1 1 0 -1 -1 -1 }
 *
 *
 * main(){
 *     N M  크기 입력받기
 *     int[][] map 지도 저장하기
 *     for(map순회){
 *          BFS(start인덱스)
 *     }
 * }
 *
 * BFS(start){
 *      Q.add(start)
 *      while(!Q.isEmpty){
 *          poll = Q.poll()
 *
 *          for(poll에 대해서 dx순회){
 *              인덱스 valid() check && 방문여부 체크 ;
 *              Q에 추가
 *          }
 *
 *      }
 * }
 *
 *
 * }
*/
public class Main {
    static int answer = 0;
    static int[][] map;
    static boolean[][] visit;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int maxDis = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) continue;
                int dis = BFS(new int[] {i,j,0});
                if(dis > maxDis){
                    maxDis = dis;
                }

                visit = new boolean[N][M];

            }
        }

        System.out.println(maxDis);
    }


    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1 };

    private static int BFS(int[] start){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);

        while(!queue.isEmpty()){

            int[] pos = queue.poll();

            if(map[pos[0]][pos[1]] == 1){
                return pos[2];
            }

            visit[pos[0]][pos[1]] = true;
            
            for (int i = 0; i < 8; i++) {

                int newX = pos[0] + dx[i];
                int newY = pos[1] + dy[i];

                if(validIdx(newX, newY)){
                    visit[newX][newY] = true;
                    queue.add(new int[] {newX, newY, pos[2]+1});
                }
            }

        }

        return 0;
    }

    private static boolean validIdx(int newX, int newY) {
        return newX >= 0 && newY >= 0 && newX < N && newY < M && !visit[newX][newY];
    }
}
