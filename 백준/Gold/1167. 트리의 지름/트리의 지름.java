import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static class Node{
        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        int node;
        int distance;
    }

    static boolean[] visited;
    static int[] distanceArr;
    static ArrayList<Node>[] nodeArrayList;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int nodeQuantity = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[nodeQuantity+1];
        distanceArr = new int[nodeQuantity+1];

        nodeArrayList = new ArrayList[nodeQuantity+1];
        nodeArrayList[0] = new ArrayList<>();

        for (int i = 1; i < nodeQuantity+1; i++) {

            String[] line = bufferedReader.readLine().split(" ");
            int nodeNum = Integer.parseInt(line[0]);
            nodeArrayList[nodeNum] = new ArrayList<>();

            for (int j = 1; j < line.length - 1; j+=2) {

                int node = Integer.parseInt(line[j]);
                int distance = Integer.parseInt(line[j+1]);

                nodeArrayList[nodeNum].add(new Node(node, distance));
            }
        }

        BFS(1);

        int start = 0;
        for (int i = 0; i < distanceArr.length; i++) {
            if(distanceArr[i] > distanceArr[start]){
                start = i;
            }
        }

        distanceArr = new int[nodeQuantity+1];
        visited = new boolean[nodeQuantity+1];
        BFS(start);

        System.out.println(Arrays.stream(distanceArr).max().getAsInt());
    }

    static void BFS(int start){

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()){
            Node now_node = queue.poll();
            nodeArrayList[now_node.node].stream().forEach(next_node -> {
                if(!visited[next_node.node]){
                    visited[next_node.node] = true;
                    distanceArr[next_node.node] += next_node.distance + distanceArr[now_node.node];
                    queue.offer(next_node);
                }
            });
        }

    }
}
