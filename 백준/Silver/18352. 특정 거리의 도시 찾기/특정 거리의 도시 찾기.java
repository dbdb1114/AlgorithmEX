import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static ArrayList<Integer>[] nodes;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n+1];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer elementToken = new StringTokenizer(bf.readLine());
            int start =Integer.parseInt(elementToken.nextToken());
            int end = Integer.parseInt(elementToken.nextToken());
            nodes[start].add(end);
        }

        distance = new int[n+1];
        visited = new boolean[n+1];

        BFS(x);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < distance.length; i++) {
            if(distance[i] == k){
                answer.append(i+"\n");
            }
        }
        if (answer.length()==0){
            answer.append(-1);
        }
        System.out.println(answer);

    }
    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){

            int now = queue.poll();

            for (Integer no : nodes[now]) {
                if(!visited[no]){
                    distance[no] = distance[now] + 1;
                    visited[no] = true;
                    queue.add(no);
                }
            }
        }

    }
}
