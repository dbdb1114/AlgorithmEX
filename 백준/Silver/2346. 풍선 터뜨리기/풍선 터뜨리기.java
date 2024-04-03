import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    /**
     * 원형큐 느낌이다.
     * */
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        int[] message = new int[N+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            deque.add(i+1);
            message[i+1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        Integer poll = deque.poll();
        System.out.print(poll);

        while (!deque.isEmpty()) {
            if(message[poll] < 0){

                for (int j = 0; j < Math.abs(message[poll]); j++) {
                    Integer last = deque.pollLast();
                    deque.addFirst(last);
                }

                poll = deque.pollFirst();

            } else {

                for (int j = 0; j < Math.abs(message[poll]); j++) {
                    Integer first = deque.pollFirst();
                    deque.addLast(first);
                }

                poll = deque.pollLast();

            }
            System.out.print(" " + poll);
        }

    }

}
