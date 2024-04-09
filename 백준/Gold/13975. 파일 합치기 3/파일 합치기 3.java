import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            bf.readLine();
            long[] s = Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long i1 = madePQ(s);
            sb.append(i1 + "\n");
        }
        
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }

    public static long madePQ(long[] s){
        PriorityQueue<Long> queue = new PriorityQueue<>();
        long sum = 0;

        for (long longs : s) {
            queue.add(longs);
        }

        while(queue.size() > 1){
            long book1 = queue.poll();
            long book2 = queue.poll();

            sum += book1 + book2;

            queue.add(book1 + book2);
        }
        return sum;
    }
}
