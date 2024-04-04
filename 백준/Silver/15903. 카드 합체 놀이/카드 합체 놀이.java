import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk1 = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(tk1.nextToken());
        long M = Long.parseLong(tk1.nextToken());

        StringTokenizer tk2 = new StringTokenizer(bf.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Long.parseLong(tk2.nextToken()));
        }

        for (long i = 0; i < M; i++) {
            Long num1 = queue.poll();
            Long num2 = queue.poll();

            queue.add(num1+num2);
            queue.add(num1+num2);
        }

        long answer = 0;
        for (Long lon : queue) {
            answer += lon;
        }

        System.out.println(answer);
    }
}

