import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<String> strQueue = new PriorityQueue<>((a,b)->{
            // 음수 처리
            if((a.startsWith("-") && !b.startsWith("-"))||
                a.length() > b.length()){
                return 1;
            } else if ((!a.startsWith("-") && b.startsWith("-"))||
                        b.length() > a.length()){
                return -1;
            }

            for (int i = 0; i < a.length(); i++) {
                int res = Character.compare(a.charAt(i), b.charAt(i));
                if(res != 0){
                    return res;
                }
            }
            return 0;
        });

        // 숫자 초기화
        for (int i = 0; i < N; i++) {
            String[] s = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(s[j]));
            }
        }

        // N번 직전까지 빼주기
        for (int i = 0; i < N-1; i++) {
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
