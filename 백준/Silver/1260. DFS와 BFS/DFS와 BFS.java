import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;



public class Main {


    static boolean[] visited;
    static ArrayList<Integer>[] nodesConnection;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] firstCondition = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = firstCondition[0]; // 노드의 개수
        int M = firstCondition[1]; // 에지의 개수
        int V = firstCondition[2]; // 시작점


        nodesConnection = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            nodesConnection[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int[] connection = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodesConnection[connection[0]].add(connection[1]);
            nodesConnection[connection[1]].add(connection[0]);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(nodesConnection[i]);
        }

        visited = new boolean[N+1];
        DFS(V);
        System.out.println();
        visited = new boolean[N+1];
        BFS(V);
        bufferedReader.close();

    }
    public static void DFS(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i : nodesConnection[start]) {
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now +" ");
            nodesConnection[now].stream().forEach(number -> {
                if(!visited[number]){
                    visited[number] = true;
                    queue.add(number);
                }
            });
        }
    }
}
