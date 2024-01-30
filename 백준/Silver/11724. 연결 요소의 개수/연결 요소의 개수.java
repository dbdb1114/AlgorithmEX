import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] nodeAndEdge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();

        int numberOfNode = nodeAndEdge[0];
        int numberOfEdge = nodeAndEdge[1];

        graph = new ArrayList[numberOfNode+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < numberOfEdge; i++) {

            int[] arriveAndDirection = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();

            graph[arriveAndDirection[0]].add(arriveAndDirection[1]);
            graph[arriveAndDirection[1]].add(arriveAndDirection[0]);
        }

        check = new boolean[numberOfNode+1];
        int answer = 0;

        for (int i = 1; i < check.length; i++) {
            if(!check[i]){
                recursiveDFS(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void recursiveDFS(int notVisited){

        if(check[notVisited]){
            return ;
        }

        check[notVisited] = true;

        graph[notVisited].stream().parallel().forEach(number -> {
            if(!check[number]){
                recursiveDFS(number);
            }
        });
    }

}
