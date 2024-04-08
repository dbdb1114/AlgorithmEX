import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    /**
     N개의 정점과 M개의 간선의 무방향 그래프가 주어진다.
     1부터 N의 모든 간선의 가중치는 1이다. ( 1로 양방향을 표시한다. )
     첫째 줄에 정점의 수 N, 간선의 수 M, 시작 정점 R이 주어진다.

     첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다.
     i번째 줄에는 정점 i의 방문 순서를 출력한다.
     시작 정점의 방문 순서는 1이다.
     시작 정점에서 방문할 수 없는 경우 0을 출력한다.

     주어진 정점과 정점의 연결을 보고, 주어진 시작지점에서의 방문 순서를 구하라.

     1. 방문 배열 필요
     2. 예제 출력을 보면, 1 4를 입력 받았는데도, 2번을 먼저 방문했다.
        오름차순으로 방문하는 것 같다.

     2번의 경우 때문에 간선 정보 입력은 일반적으로는 ArrayList를 활용하지만, PriorityQueue를 활용한다.

     PriorityQueue<Integer>[] pr = new PriorityQueue[N];

     정보 받는 재귀
     public void recursive(PriorityQueue pr){
        while(pr이 비었있지 않을 때){
            poll = pr.poll; // 다음 방문 노드 인덱스
            if(방문했다면) continue;
            checkArr[poll] = true;
            answerArr[poll] = order;
            recursive(간선정보[poll])
        }
     }

     */

    static PriorityQueue<Integer>[] linkNode;
    static boolean[] checkArr;
    static int[] answerArr;
    static int order = 1;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[2]);
        M = Integer.parseInt(input[1]);

        // 문제의 정점들은 1번부터 시작하기 때문에 N+1로 설정
        linkNode = new PriorityQueue[N+1];
        checkArr = new boolean[N+1];
        answerArr = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            linkNode[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < M; i++) {
            String[] s = bf.readLine().split(" ");

            int U = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            
            linkNode[U].add(V);
            linkNode[V].add(U);
        }

        checkArr[R] = true;
        answerArr[R] = order;
        order++;
        DFS(linkNode[R]);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answerArr.length; i++) {
            sb.append(answerArr[i] + "\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }


    public static void DFS(PriorityQueue<Integer> pr){
        while(!pr.isEmpty()){
            int poll = pr.poll();
            if(checkArr[poll]) continue;
            checkArr[poll] = true;
            answerArr[poll] = order++;
            DFS(linkNode[poll]);
        }
    }
}
