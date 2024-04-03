import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            String[] s = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(s[j]));
            }
        }

        for (int i = 0; i < N-1; i++) {
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
