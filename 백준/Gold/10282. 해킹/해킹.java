import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Computer {
        int id;
        int time;
        List<Node> dependencies;

        public Computer(int id) {
            this.id = id;
            this.time = Integer.MAX_VALUE;
            this.dependencies = new ArrayList<>();
        }
    }

    static class Node {
        int id;
        int time;

        public Node(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int D = Integer.parseInt(info[1]);
            int C = Integer.parseInt(info[2]);

            Computer[] computers = new Computer[N + 1];
            computers[C] = new Computer(C);

            for (int i = 0; i < D; i++) {
                String[] depInfo = br.readLine().split(" ");
                int a = Integer.parseInt(depInfo[0]);
                int b = Integer.parseInt(depInfo[1]);
                int time = Integer.parseInt(depInfo[2]);
                
                if (computers[b] == null) {
                    computers[b] = new Computer(b);
                }

                if (computers[a] == null) {
                    computers[a] = new Computer(a);
                }

                computers[b].dependencies.add(new Node(a, time));


                computers[b].dependencies.add(new Node(a, time));
            }

            int[] timeToInfect = new int[N + 1];
            Arrays.fill(timeToInfect, Integer.MAX_VALUE);
            timeToInfect[C] = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(C);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (Node node : computers[curr].dependencies) {
                    int next = node.id;
                    int time = node.time;

                    if (timeToInfect[next] > timeToInfect[curr] + time) {
                        timeToInfect[next] = timeToInfect[curr] + time;
                        queue.offer(next);
                    }
                }
            }

            int count = 0;
            int maxTime = 0;
            for (int i = 1; i <= N; i++) {
                if (timeToInfect[i] != Integer.MAX_VALUE) {
                    count++;
                    maxTime = Math.max(maxTime, timeToInfect[i]);
                }
            }

            sb.append(count).append(" ").append(maxTime).append("\n");
        }

        System.out.print(sb.toString());
    }
}
