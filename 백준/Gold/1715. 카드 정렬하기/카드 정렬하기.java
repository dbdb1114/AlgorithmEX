import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(bf.readLine()));
        }

        int sum = 0;
        while (queue.size() > 1){
            Integer num1 = queue.poll();
            Integer num2 = queue.poll();

            queue.add(num1+num2);
            sum += num1 +num2;
        }


        System.out.println(sum);
    }
}
