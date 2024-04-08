import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
/**
 *
 * [==========================문제 분석============================]
 *
 *  너비 우선 탐색(BFS)                            ;;while문에서 큐를 활용한 탐색을 많이 함.
 * N개의 정점과 M개의 간선으로 구성된 무방향 그래프
 * 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다.
 *
 * [==입력==]
 * 첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000),
 * 간선의 수 M (1 ≤ M ≤ 200,000),
 * 시작 정점 R (1 ≤ R ≤ N)
 *
 * [==출력==]
 * 첫째 줄부터 N개의 줄에 정수를 한 개씩 출력
 * i번째 줄에는 정점 i의 방문 순서
 *
 *
 * [==========================제한 조건============================]
 *  1.  N (5 ≤ N ≤ 100,000), M (1 ≤ M ≤ 200,000), R (1 ≤ R ≤ N)
 *  2. 시간 제한 1초
 *  3. 메모리 제한 512 MB
 *
 *  => 데이터 수 많지 않고, 시간 제한도 데이터 수에 비해서 빡쎄지 않음. 요구하는대로 그대로 구현하면 될듯
 *  => 메모리는 자유를 준 듯
 *
 * [==========================해결 전략============================]
 * 1. 해당 문제는 입출력 값 받는 것
 * 2. 정점 인덱스가 1부터 있다는 것을 고려한 방문 배열, 연결 정보 배열 등의 크기를 조절하거나
 *    혹은 입출력시 고려해야한.
 * 3. 필요한 필드
 *   -0. 정점별 연결 정보 저장 PriorityQueue<Integer> 배열 = 뉴 배열[N+1]
 *   -1. 방문체크 배열       boolean[] 배열 = 뉴 배열[N+1]
 *   -2. 빙믄 순서 저장 배열  int[] answer = 뉴 배열[N+1]
 *   -3. 방문 순서 체크 인덱스 order = 1;
 *
 * [==========================슈도 코드============================]
 * 전역 필드
 *
 * PriorityQueue<Integer> 배열 = 뉴 배열[N+1]
 * boolean[] 배열 = 뉴 배열[N+1]
 * int[] answer = 뉴 배열[N+1]
 * order = 1;
 *
 * 메인함수 {
 *     입력받기 ( N, M, R )
 *     PriorityQueue<Integer> 배열 = 뉴 배열[N+1]
 *     boolean[] 배열 = 뉴 배열[N+1]
 *     int[] answer = 뉴 배열[N+1]
 *
 *     PriorityQueue배열 초기화 for문
 *
 *     BFS(우선순위큐[R]);
 *     정답 출력
 * }
 *
 * BFS (첫 큐) {
 *     탐색큐 입력된 큐로 초기화
 *
 *     while(큐가 빌 때까지){
 *         now = 큐.poll();
 *         if(방문[now]) continue
 *         방문[now] = true;
 *         정답배열[now] = order++;
 *         탐색큐.add( 정점정보배열[now] )
 *     }
 * }
 *
 *
*/

    static PriorityQueue<Integer>[] nodes;
    static boolean[] checkAr;
    static int[] answerAr;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        nodes = new PriorityQueue[N+1];
        checkAr = new boolean[N+1];
        answerAr = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            nodes[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < M; i++) {
            String[] twoNode = bf.readLine().split(" ");

            int node1 = Integer.parseInt(twoNode[0]);
            int node2 = Integer.parseInt(twoNode[1]);

            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }


        checkAr[R] = true;
        answerAr[R] = order++;
        BFS(nodes[R]);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answerAr.length; i++) {
            sb.append(answerAr[i] + "\n");
        }
        sb.delete(sb.length()-1, sb.length());

        System.out.println(sb);
    }

    private static void BFS(PriorityQueue<Integer> node) {
        Queue<Integer> queue = new LinkedList<>();

        while(!node.isEmpty()){
            queue.add(node.poll());
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(checkAr[now]) continue;
            checkAr[now] = true;
            answerAr[now] = order++;

            while(!nodes[now].isEmpty()){
                queue.add(nodes[now].poll());
            }
        }
    }

}
