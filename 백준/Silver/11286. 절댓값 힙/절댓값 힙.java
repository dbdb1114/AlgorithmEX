import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>((a,b)->{
            int abs = Long.compare(Math.abs(a),Math.abs(b));
            if(abs == 0){
                return Long.compare(a,b);
            } else {
                return abs;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(bf.readLine());
            if(num != 0){
                queue.add(num);
            } else if (queue.isEmpty()) {
                sb.append(0 + "\n");
            } else {
                sb.append(queue.poll() + "\n");
            }
        }

        System.out.println(sb);

    }
}
